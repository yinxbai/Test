<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    System.out.println(request.getSession().getId());
%>

<!DOCTYPE html>
<html class="app-ui">
<head>
    <%@include file="/common/header.jsp"%>
</head>

<body class="app-ui layout-has-drawer layout-has-fixed-header">
<div class="app-layout-canvas">
    <div class="app-layout-container">
        <!-- Drawer -->
        <aside class="app-layout-drawer">
            <!-- Drawer scroll area -->
            <div class="app-layout-drawer-scroll">
                <!-- Drawer logo -->
                <div id="logo" class="drawer-header">
                    <a href="index.html"><img class="img-responsive" src="assets/img/logo/logo-backend.png" title="AppUI" alt="AppUI" /></a>
                </div>
                <!-- Drawer navigation -->
                <nav class="drawer-main">
                    <ul class="nav nav-drawer">
                        <c:if test="${fn:contains(user,'role')}">
                            <li class="nav-item nav-item-has-subnav">
                                <a href="javascript:void(0)"><i class="ion-ios-calculator-outline"></i> 教学管理</a>
                                <ul class="nav nav-subnav">
                                    <li>
                                        <a href="courseResource/list/1/${user.id}" target="main">课件资源</a>
                                    </li>
                                    <li>
                                        <a href="" target="main">班级名录</a>
                                    </li>
                                    <li>
                                        <a href="exercise/list/1" target="main">批改作业</a>
                                    </li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${not fn:contains(user,'role')}">
                            <li class="nav-item nav-item-has-subnav">
                                <a href="javascript:void(0)"><i class="ion-ios-compose-outline"></i> 学习天地</a>
                                <ul class="nav nav-subnav">
                                    <li>
                                        <a href="courseResource/exercise" target="main">我的作业</a>
                                    </li>
                                    <li>
                                        <a href="courseResource/play" target="main">视频点播</a>
                                    </li>

                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${fn:contains(user,'role')}">
                            <li class="nav-item nav-item-has-subnav"><li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="ion-ios-list-outline"></i> 学生管理</a>
                            <ul class="nav nav-subnav">

                                <li>
                                    <a href="student/list" target="main">学生信息</a>
                                </li>
                            </ul>
                        </li>
                        </c:if>
                        <c:if test="${fn:contains(user, 'role')}">
                            <li class="nav-item nav-item-has-subnav">
                                <a href="javascript:void(0)"><i class="fa fa-cog"></i> 系统管理</a>
                                <ul class="nav nav-subnav">
                                    <li>
                                        <a href="clazz/list" target="main">班级管理</a>
                                    </li>

                                    <li>
                                        <a href="teacher/queryList/1" target="main">教师管理</a>
                                    </li>

                                    <li>
                                        <a href="log/list/1" target="main">日志管理</a>
                                    </li>
                                </ul>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- End drawer -->

        <!-- Header -->
        <header class="app-layout-header">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="header-navbar-collapse">
                        <!-- .navbar-left -->
                        <ul class="nav navbar-nav navbar-right navbar-toolbar hidden-sm hidden-xs">
                            <li class="dropdown dropdown-profile">
                                <a href="javascript:void(0)" data-toggle="dropdown">
                                    <span class="m-r-sm">${user.name}<span class="caret"></span></span>
                                    <img class="img-avatar img-avatar-48" src="assets/img/avatars/avatar3.jpg" alt="User profile pic" />
                                </a>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li>
                                        <a href="javascript:void(0)"  data-toggle="modal" data-target="#modal-normal" >修改密码</a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)" id="logout">退出</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <!-- .navbar-right -->
                    </div>
                </div>
                <!-- .container-fluid -->
            </nav>
            <!-- .navbar-default -->
        </header>
        <!-- End header -->

        <main class="app-layout-content">
            <iframe src="" name="main" width="100%" height="650" frameborder="0"></iframe>
        </main>

    </div>
    <!-- .app-layout-container -->
</div>
<!-- .app-layout-canvas -->

<!-- Apps Modal -->
<!-- Opens from the button in the header -->


<!-- Normal Modal -->
<div class="modal" id="modal-normal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <h4>密码修改</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><em class="ion-close"></em></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="changePassword" method="post">
                    <div class="form-group">
                        <label class="col-md-3 control-label">新密码</label>
                        <div class="col-md-7">
                            <input name="account" type="text" class="form-control" id="account" placeholder="请输入新密码" />
                        </div>
                    </div>
                    <br><br>
                    <div class="form-group">
                        <label class="col-md-3 control-label">确认密码</label>
                        <div class="col-md-7">
                            <input name="password"  type="password" class="form-control"  id="password" placeholder="请确认密码" />
                        </div>
                    </div>
                    <br><br>
                    <button type="submit" class="btn btn-app btn-block" id="sub">修改</button>
                </form>
            </div>

        </div>
    </div>
</div>
<div class="modal" id="modal-normal-video" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <h4>视频播放</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button" onclick="playPause() "><em class="ion-close"></em></button>
                    </li>
                </ul>
            </div>
        <div class="card-block">
          <video src="" id="video" preload="false" width="100%" height="100%" controls="controls"></video>
        </div>
    </div>
</div>
<!-- End Apps Modal -->
<!-- AppUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock and App.js -->
<%@include file="/common/footer.jsp"%>
<!-- Page JS Code -->
<script>
    $(function(){
        alert(${user}+1);
        $("#logout").click(function(){
            if(confirm("您确定要退出吗?")){
                location.href = "logout";
            }
        });
        /*App.initHelpers('slick');*/
    });
    function playPause() {
        let video = $("video")[0];
        video.close();
    }
</script>
</body>
</html>