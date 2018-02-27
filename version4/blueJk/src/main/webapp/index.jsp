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
    <meta http-equiv="Refresh" content="2;url=${pageContext.request.contextPath}/home.action">
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/laydate/laydate.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/components/jquery-mini/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
    <script>
        //yyyy-MM-dd被固定了
        laydate.render({
            elem: '#demoLayDate' //指定元素 id
        });
    </script>
    <!--
        2秒后跳转到home Controller ==> View
    -->
    <script>
        function myFunction() {
            var odiv = document.getElementById('odiv');
            var d = new Date();
            var t = d.toLocaleTimeString();
            odiv.innerText = t;
        }
        (function () {
            setInterval("myFunction()", 1);
        }());
    </script>
</head>
<body>
<!--
    <div class="panel" style="height: auto;width: 1000px; margin: 0 auto;">
        <div style="width: 100%;height: auto;text-align: center;margin-top:80px;">
            <a href="${pageContext.request.contextPath}/testView.action">testView</a><br/>
        </div>
    </div>
 -->
<%--
    <jsp:forward page="WEB-INF/views/home.jsp" />
 --%>
    <div class="panel" style="margin-left: auto;margin-right: auto;margin-top: 50px;text-align: center;">
        正在跳转中 time:<label id="odiv"/>
    </div>
</body>
</html>
