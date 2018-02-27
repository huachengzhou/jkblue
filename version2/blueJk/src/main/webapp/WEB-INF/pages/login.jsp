<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>陕西杰信商务综合管理平台</title>

    <script src="${pageContext.request.contextPath}/static/laydate/laydate.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet"
          type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/npm.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/laydate/laydate.js" type="text/javascript"></script>
    <style>
        body{
            background: #00F7DE;
        }
    </style>
</head>

<body>
<div style="height: auto;width: 1000px;margin-left: auto;margin-right: auto;margin-top: 50px;" class="panel">
    <div style="width: 100%;height: auto;text-align: center;" class="page-header">
        <h2 class="panel-title" style="display: inline-block;text-align: center;">杰信商务登录平台</h2>
    </div>
    <div style="width: 100%;height: auto;text-align: center;margin-top:10px;" class="panel-body">
        <form class="form-group" method="post" action="${pageContext.request.contextPath}/fmain.action">
            <input type="text" name="userName" id="userName" placeholder="userName" class="form-control"><br/>
            <input type="password" name="password" id="password" placeholder="password" class="form-control"><br/>
            <input type="submit" value="submit" class="btn btn-default" style="display: inline-block;width: 100px;height: 40px;"><br/>
        </form>
    </div>

    <div style="width: 100%;height: auto;text-align: center;" class="panel-body">
        <a href="${pageContext.request.contextPath}/basicinfo/factory/list.action">factory list</a>
    </div>

    <div style="width: 100%;height:90px;text-align: center;" class="panel-footer">
        <div style="float: left; margin-left: 50px;" class="panel-body"><button class="btn btn-info" style="height:30px;width:100px;">系统帮助</button></div>
        <div style="float: right; margin-right: 50px;" class="panel-body"><button class="btn btn-info" style="height:30px;width:100px;">加入收藏</button></div>
    </div>
</div>


</body>
</html>


