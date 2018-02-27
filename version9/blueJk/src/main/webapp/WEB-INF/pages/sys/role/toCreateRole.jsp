<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
    <!-- 必须在引入bootstrap之前先引入jquery模块 -->
    <!-- The jQuery module must be introduced before the introduction of bootstrap -->
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>

    <!-- 必须在bootstrap之前先引入tether模块 -->
    <!-- The tether module must be introduced before bootstrap -->
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/tether/tether-1.3.3/dist/js/tether.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/tether/tether-1.3.3/dist/css/tether.min.css" rel="stylesheet" type="text/css">

    <!-- 引入bootstrap模块 -->
    <!-- Introducing bootstrap module -->
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-4.0.0-alpha.6-dist/js/popper.min.js"></script>
    <script>
        function formSubmitA (url,sTarget){
            var description = document.getElementById('description').value;
            document.getElementById('description').value = encodeURI(description);
            document.forms[0].target = sTarget
            document.forms[0].action = url;
            document.forms[0].submit();
            return true;
        }
    </script>
</head>
<body>
<form method="post" class="form-group" name="formEXAMPLE">
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="save"><a  href="#" onclick="formSubmitA('${pageContext.request.contextPath}/sys/toAddRole.action','_self');">确定</a></li>
                        <li id="back"><a href="${pageContext.request.contextPath}/sys/listRole.action">返回</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">

        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">
                    新增角色信息
                </div>
            </div>
        </div>
        <div>
            <div>
                <table class="commonTable" cellspacing="1">
                    <tr>
                        <td class="columnTitle_mustbe">角色名称：</td>
                        <td class="tableContent"><input type="text" name="role_name"/></td>
                        <td class="columnTitle_mustbe">角色中文描述：</td>
                        <td class="tableContent"><input type="text" name="description" id="description"/></td>
                    </tr>
                    <tr>
                        <td class="columnTitle_mustbe">角色是否启用：</td>
                        <td class="tableContentAuto">
                            <input type="radio" name="available" value="true" class="input" checked>启用
                            <input type="radio" name="available" value="false" class="input">不启用
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: center;">
                            <c:forEach items="${privileges}" var="privilege">
                                <input class="form-control" type="checkbox" name="pid" value="${privilege.pid}">${privilege.description}<br/>
                            </c:forEach>
                        </td>
                    </tr>
                </table>
            </div>
        </div>


</form>
</body>
</html>

