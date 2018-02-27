<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-1-31
  Time: 下午1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <script src="${pageContext.request.contextPath}/static/laydate/laydate.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"> </script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/laydate/laydate.js" type="text/javascript"></script>
    <script>
        //yyyy-MM-dd被固定了
        laydate.render({
            elem: '#demoLayDate' //指定元素 id
        });
    </script>
</head>
<body>
<div class="panel" style="height: auto;width: 1000px; margin: 0 auto;">
    <div style="width: 100%;height: auto;text-align: center;margin-top:80px;">
        <a href="${pageContext.request.contextPath}/testView.action">testView</a>
    </div>
</div>
</body>
</html>
