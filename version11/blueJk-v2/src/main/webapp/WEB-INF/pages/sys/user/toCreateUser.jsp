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
            var organizationid = document.getElementById('organizationid').value;
            document.getElementById('organizationid').value = encodeURI(organizationid);
            var name = document.getElementById('name').value;
            document.getElementById('name').value = encodeURI(name);

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
                        <li id="save"><a  href="#" onclick="formSubmitA('${pageContext.request.contextPath}/sys/createUser.action','_self');">确定</a></li>
                        <li id="back"><a href="${pageContext.request.contextPath}/sys/listUser.action">返回</a></li>
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
                        <td>
                        <input type="text" id="organizationid" name="organizationid" class="form-control" placeholder="organizationid">
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <input type="text" name="username" class="form-control" placeholder="username">
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <input type="text" name="name" id="name" class="form-control" placeholder="name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <input type="password" name="password" class="form-control" placeholder="password">
                        </td>
                    </tr>

                    <tr>
                        <td class="columnTitle_mustbe">用户是否启用：</td>
                        <td class="tableContentAuto">
                            <input type="radio" name="lock_User" value="true" class="input" checked>启用
                            <input type="radio" name="lock_User" value="false" class="input">不启用
                        </td>
                    </tr>
                    <c:forEach items="${roles}" var="r">
                    <tr>
                        <td style="text-align: center;">
                                <input class="form-control" type="checkbox" name="rid" value="${r.rid}">${r.description}<br/>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>


</form>
</body>
</html>

