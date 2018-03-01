<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>登录界面</title>
    <link href="${pageContext.request.contextPath}/components/a1/css/default.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="${pageContext.request.contextPath}/components/a1/css/styles.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/components/a1/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/components/a1/css/loaders.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/components/module-bootstrap/bootstrap-3.3.7-dist/js/npm.js" type="text/javascript"></script>
</head>
<body>
<div class='login'>
    <div class='login_title'>
        <span>管理员登录</span>
    </div>
    <div class='login_fields'>
        <form id="login_main" name="loginForm" method="post" action="${pageContext.request.contextPath}/sys/login.action">
            <div class='login_fields__user'>
                <div class='icon'>
                    <img alt="" src='${pageContext.request.contextPath}/components/a1/img/user_icon_copy.png'>
                </div>
                <input name="username" placeholder='用户名' maxlength="16" type='text' autocomplete="off"/>
                <div class='validation'>
                    <img alt="" src='${pageContext.request.contextPath}/components/a1/img/tick.png'>
                </div>
            </div>
            <div class='login_fields__password'>
                <div class='icon'>
                    <img alt="" src='${pageContext.request.contextPath}/components/a1/img/lock_icon_copy.png'>
                </div>
                <input name="password" placeholder='密码' maxlength="16" type='password' autocomplete="off">
                <div class='validation'>
                    <img alt="" src='${pageContext.request.contextPath}/components/a1/img/tick.png'>
                </div>
            </div>
            <div class="login_fields__password" style="margin-left: 40px;">
                <a href=""><img class="img-rounded" style="height: 25px;width:70px;" src='${pageContext.request.contextPath}/getJPGCode.action'></a>
            </div>
            <div class='login_fields__password'>
                <div class='icon'>
                    <img alt="" src='${pageContext.request.contextPath}/components/a1/img/key.png'>
                </div>
                <input type="text" name="_code" placeholder="验证码">${loginFailed}
            </div>
            <div class='login_fields__password' style="margin-left:30px;">
                <p>是否记住我
                    <input type="radio" name="rememberMe" value="1">
                    否<input type="radio" name="rememberMe" value="0">
                    <br/>
                </p>
            </div>
            <div class='login_fields__submit'>
                <input type='button' value='登录' id="btnLogin">
            </div>
        </form>
    </div>
</div>
<div class='authent'>
    <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
</div>
<div class="OverWindows"></div>

<link href="layui/css/layui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/components/a1/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/components/a1/js/jquery-ui.min.js"></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/components/a1/js/stopExecutionOnTimeout.js?t=1'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/components/a1/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/components/a1/js/Particleground.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/components/a1/js/Treatment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/components/a1/js/jquery.mockjax.js"></script>
<script type="text/javascript">
    //粒子背景特效
    $('body').particleground({
        dotColor: '#E8DFE8',
        lineColor: '#133b88'
    });
   window.onload = function () {
       var login_main = document.getElementById('login_main');
       btnLogin.onclick = function () {
           var username = document.forms["loginForm"]["username"].value;
           var password = document.forms["loginForm"]["password"].value;
           var code = document.forms["loginForm"]["_code"].value;
           var rememberMe = document.forms["loginForm"]["rememberMe"].value;
           if(username!=null&&username!=''){
               if(password!=null&&password!=''){
                   if(code!=null&&code!=''){
                       if(rememberMe!=null&&rememberMe!=''&&rememberMe!='0'){
                            login_main.submit();//提交
                       }else {
                           alert("没有勾选"+"rememberMe");
                       }
                   }else {
                       alert("验证码"+"未填写");
                   }
               }else {
                   alert("password"+"未填写");
               }
           }else {
                alert("username"+"未填写");
           }
       }

   }
</script>

</body>
</html>
