<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-2-14
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../baselist.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>role show</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/main.css" media="all"/>
    <!-- The jQuery module must be introduced before the introduction of bootstrap -->
    <script src="${pageContext.request.contextPath}/components/jquery-module/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/laydate/laydate.js" type="text/javascript"></script>

    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>

    <script>
        //yyyy-MM-dd被固定了
        laydate.render({
            elem: '#demoLayDate' //指定元素 id
        });
    </script>
    <script>
        function formSubmitA (url,sTarget){
            document.forms[0].target = sTarget
            document.forms[0].action = url;
            document.forms[0].submit();
            return true;
        }
    </script>
</head>
<body>
<form name="form2">
    <!-- 工具栏部分 ToolBar -->
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="view"><a href="#">查看</a></li>
                        <li id="new"><a href="${pageContext.request.contextPath}/sys/toCreateRole.action">新建</a></li>
                        <li id="update"><a href="#">修改</a></li>
                        <li id="delete"><a href="#" onclick="formSubmitA('${pageContext.request.contextPath}/sys/removeRole.action','_self')">删除</a></li>
                        <li id="search"><a href="#">查询</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!-- 页面主体部分（列表等） -->
    <div class="textbox" id="centerTextbox">

        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">
                    <h2>角色列表</h2>
                </div>
            </div>
        </div>

        <div>


            <div class="eXtremeTable">
                <table id="ec_table"  cellspacing="0"  cellpadding="0"  class="table"  width="98%">
                    <thead>
                        <tr>
                            <td>角色描述</td>
                            <td>角色是否冻结</td>
                            <td>description</td>
                        </tr>
                    </thead>

                    <tbody class="tab-content">
                    <c:forEach items="${datalist}" var="r">
                    <tr>
                        <td><input type="checkbox" name="rid" value="${r.rid}"/></td>
                        <td>${r.role_name}</td>
                        <td>${r.available}</td>
                        <td>${r.description}</td>
                    </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>


        </div>
</form>
</body>
</html>
