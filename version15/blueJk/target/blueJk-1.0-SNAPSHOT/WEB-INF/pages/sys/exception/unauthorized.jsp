<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>异常处理页面</title>
</head>

<body>
	<center>
		<label>code </label> <label><font class="red">${exception}</font></label>
	</center>
	<hr>
	<center>
		<label style="color: #b92c28">没有相关的权限</label>
	</center>
</body>
</html>
