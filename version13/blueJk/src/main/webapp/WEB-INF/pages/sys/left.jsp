<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 18-2-14
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp" %>
<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/main.css" media="all"/>
<html>
<head>
    <title>left</title>
</head>
<body id="left_frame">
<form method="post">
    <div class="PositionFrame_black" id="PositionFrame"></div>

    <!-- begin1  -->

    <!-- end1 -->

    <!-- begin1  -->

    <div id="sidebar" class="sidebar">
        <div class="sidebar_t">
            <div class="sidebar_t_l"></div>
            <div class="sidebar_t_c"></div>
            <div class="sidebar_t_r"></div>
        </div>
        <div class="panel">
            <div class="panel_icon"><img src="../skin/default/images/icon/user1_lock.png" /></div>
            <div class="panel-header">
                <div class="panel-title">
                    权限管理
                </div>

                <div class="panel-content">
                    <ul>


                        <li><a href="${pageContext.request.contextPath}/sys/listRole.action" target="main" id="aa_12" onclick="linkHighlighted(this)">角色管理</a></li>


                        <li><a href="dept/deptList.html" target="main" id="aa_13" onclick="linkHighlighted(this)">部门管理</a></li>


                        <li><a href="${pageContext.request.contextPath}/sys/listUser.action" target="main" id="aa_14" onclick="linkHighlighted(this)">用户管理</a></li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="sidebar_t">
            <div class="sidebar_b_l"></div>
            <div class="sidebar_t_c"></div>
            <div class="sidebar_b_r"></div>
        </div>
    </div>

    <!-- end1 -->

    <!-- begin1  -->

    <!-- end1 -->

</form>
</body>
</html>
