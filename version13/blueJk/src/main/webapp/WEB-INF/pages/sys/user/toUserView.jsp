<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-2-16
  Time: 上午11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
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
                    用户信息
                </div>
            </div>
        </div>
        <div>
            <div>
                <table class="commonTable" cellspacing="1">
                    <tbody style="text-align: center;">
                    <tr>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <td>${user.username}</td>
                    </tr>
                    <tr>
                        <td>${user.organizationid}</td>
                    </tr>
                    <tr>
                        <td> <fmt:formatDate value="${user.time}" /></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>


</form>
</body>
</html>
