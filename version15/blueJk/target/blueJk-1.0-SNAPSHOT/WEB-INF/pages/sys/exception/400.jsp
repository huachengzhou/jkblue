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
<title>请求无效</title>
</head>

<body>
	<center>
		<label>code 400</label> <label><font color="red">${ex}</font></label>
	</center>
	<hr>
	<center>
		<a href="/fmain.action">main</a>
	</center>
</body>
</html>
