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
<title>服务器内部错误</title>
</head>

<body>
	<center>
		<label>code 500</label> <label><font color="red">${ex}</font></label>
	</center>
	<hr>
	<center>
		<label style="color: #b92c28">内部异常</label>
	</center>
</body>
</html>
