<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html class="app-ui">

<head>
    <!-- Meta -->
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

    <!-- Document title -->
    <title></title>

    <meta name="description" content="AppUI - Admin Dashboard Template & UI Framework" />
    <meta name="author" content="rustheme" />
    <meta name="robots" content="noindex, nofollow" />

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="assets/img/favicons/apple-touch-icon.png" />
    <link rel="icon" href="assets/img/favicons/favicon.ico" />

    <!-- Google fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,400italic,500,900%7CRoboto+Slab:300,400%7CRoboto+Mono:400" />

    <!-- Page JS Plugins CSS -->
    <link rel="stylesheet" href="assets/js/plugins/slick/slick.min.css" />
    <link rel="stylesheet" href="assets/js/plugins/slick/slick-theme.min.css" />

    <!-- AppUI CSS stylesheets -->
    <link rel="stylesheet" id="css-font-awesome" href="assets/css/font-awesome.css" />
    <link rel="stylesheet" id="css-ionicons" href="assets/css/ionicons.css" />
    <link rel="stylesheet" id="css-bootstrap" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" id="css-app" href="assets/css/app.css" />
    <link rel="stylesheet" id="css-app-custom" href="assets/css/app-custom.css" />
    <!-- End Stylesheets -->
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
                        <c:if test="${fn:contains(user, 'role')}">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="ion-ios-calculator-outline"></i>教学管理</a>
                            <ul class="nav nav-subnav">
                                <li>
                                    <a href="courseResource/list/1/${user.id}" target="main">课件资源</a>
                                </li>
                                <li>
                                    <a href="base_ui_widgets.html" target="main">批改作业</a>
                                </li>
                                <li>
                                    <a href="student/findStudentByTeacher/0/${user.id}/1" target="main">班级名录</a>
                                </li>
                            </ul>
                        </li>
                        </c:if>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="ion-ios-compose-outline"></i> 学习天地</a>
                            <ul class="nav nav-subnav">
                                <li>
                                    <a href="exercise/list/${user.id}/1" target="main">我的作业</a>
                                </li>
                                <li>
                                    <a href="student/queryVideoCoruseResource/${user.id}/1" target="main">视频点播</a>
                                </li>
                            </ul>
                        </li>
                        <c:if test="${fn:contains(user, 'role')}">
                        <c:if test="${user.role==1}">
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="ion-ios-list-outline"></i> 学生管理</a>
                            <ul class="nav nav-subnav">
                                <li>
                                    <a href="student/list/1" target="main">学生信息</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="fa fa-cog"></i> 系统管理</a>
                            <ul class="nav nav-subnav">
                                <li>
                                    <a href="clazz/queryByPage/1" target="main">班级管理</a>
                                </li>
                                <li>
                                    <a href="/teacher/queryList/1" target="main">教师管理</a>
                                </li>
                                <li>
                                    <a href="log/list/1" target="main">日志管理</a>
                                </li>
                            </ul>
                        </li>
                        </c:if>
                        </c:if>
                    </ul>
                </nav>
                <!-- End drawer navigation -->

            </div>
            <!-- End drawer scroll area -->
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
                                        <a href="javascript:void(0)" data-toggle="modal" data-target="#modal-normal">修改密码</a>
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

<!-- Apps Modal 修改密码-->
<div class="modal" id="modal-normal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <h4>密码修改</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="changePassword" method="post" class="js-validation-bootstrap form-horizontal">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="newPassword">新密码</label>
                        <div class="col-md-7">
                            <input type="text" name="newPassword" class="form-control" id="newPassword" placeholder="请输入新密码" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="confirmPassword">确认密码</label>
                        <div class="col-md-7">
                            <input type="password" name="confirmPassword" class="form-control" id="confirmPassword" placeholder="请确认新密码" />
                        </div>
                    </div>
                    <button type="submit" class="btn btn-app btn-block">修改</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- End Apps Modal 修改密码 -->
<!-- Apps Modal 视频点播-->
<div class="modal" id="modal-normal-video" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button" id="video-close"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <video src="" id="video" preload="false" width="100%" height="100%" controls="controls"></video>
            </div>
        </div>
    </div>
</div>
<!-- AppUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock and App.js -->
<script src="assets/js/core/jquery.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/core/jquery.slimscroll.min.js"></script>
<script src="assets/js/core/jquery.scrollLock.min.js"></script>
<script src="assets/js/core/jquery.placeholder.min.js"></script>
<script src="assets/js/app.js"></script>
<script src="assets/js/app-custom.js"></script>

<!-- Page Plugins -->
<script src="assets/js/plugins/slick/slick.min.js"></script>
<script src="assets/js/plugins/chartjs/Chart.min.js"></script>
<script src="assets/js/plugins/flot/jquery.flot.min.js"></script>
<script src="assets/js/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="assets/js/plugins/flot/jquery.flot.stack.min.js"></script>
<script src="assets/js/plugins/flot/jquery.flot.resize.min.js"></script>

<!-- Page JS Code -->

<script>
    $(function(){
        $("#logout").click(function (){
            if(confirm("您确定要退出吗？")){
                location.href = "logout";
            }
        });

        $("#video-close").click(function(){
            $("#video")[0].pause();
        });
    });
</script>

</body>

</html>