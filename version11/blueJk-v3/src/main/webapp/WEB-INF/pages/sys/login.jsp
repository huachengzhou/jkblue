<%@ page language="java" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>陕西杰信商务综合管理平台</title>

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

    <script src="${pageContext.request.contextPath}/js/common.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/skin/default/css/login.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function kickout(){
            var href=location.href;
            if(href.indexOf("kickout")>0){
                alert("您的账号在另一台设备上登录，您被挤下线，若不是您本人操作，请立即修改密码！");
            }
        }
        window.onload=kickout();
    </script>
</head>

<body>

<form id="login_main" method="post">
    <div id="warpbox">
        <div class="main">
            <div class="zck">
                <div class="zc">
                    <div class="zc_line">用户名：
                        <input type="text" value="" name="username" id="userName"
                               onkeyup="showGs(event)"
                               onFocus="this.select();"
                               autocomplete="off" title="请您输入用户名"/><div id="ts" style="z-index:1;"></div></div>
                    <div class="zc_line">密　码：
                        <input type="password" value="" name="password" id="password"
                               onfocus="$('#ts').css('display','none');this.select();"
                               onKeyDown="javascript:if(event.keyCode==13){ submitFind(); }"
                               title="请您输入密码"/><br/>
                        是否记住我<input type="checkbox" name="rememberMe" value="1"><br/>
                    </div>
                </div>
                <div class="dl">
                    <input  class="dl_img" value="" type="button" onclick="formSubmit('${pageContext.request.contextPath}/sys/login.action','_self');"/>
                    <input class="reset_img" value="" type="reset"/>
                </div>
            </div>
            <div class="bqxx" style="text-align:right;margin-top:0px;">
                <a href="#">系统帮助</a> | <a href="#" onclick="bookmarkit();">加入收藏</a>
            </div>
            <div class="mirro erro_intro">
                <label style="color: red;font-size: 14px;">${loginFailed}</label>
            </div>

        </div>
    </div>
</form>
<script type="text/JavaScript">
    document.getElementById('login_main').userName.focus();
</script>
</body>
</html>


