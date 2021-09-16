<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html class="app-ui">

<head>
    <base href="${pageContext.request.contextPath}/">
    <!-- Meta -->
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

    <!-- Document title -->
    <title>Login</title>

    <meta name="description" content="AppUI - Frontend Template & UI Framework" />
    <meta name="robots" content="noindex, nofollow" />

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="assets/img/favicons/apple-touch-icon.png" />
    <link rel="icon" href="assets/img/favicons/favicon.ico" />

    <!-- Google fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,400italic,500,900%7CRoboto+Slab:300,400%7CRoboto+Mono:400" />

    <!-- AppUI CSS stylesheets -->
    <link rel="stylesheet" id="css-font-awesome" href="assets/css/font-awesome.css" />
    <link rel="stylesheet" id="css-ionicons" href="assets/css/ionicons.css" />
    <link rel="stylesheet" id="css-bootstrap" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" id="css-app" href="assets/css/app.css" />
    <link rel="stylesheet" id="css-app-custom" href="assets/css/app-custom.css" />
    <!-- End Stylesheets -->
</head>

<body class="app-ui">
<div class="app-layout-canvas">
    <div class="app-layout-container">

        <main class="app-layout-content">
            <!-- Page header -->
            <div class="page-header bg-green bg-inverse">
                <div class="container">
                    <!-- Section Content -->
                    <div class="p-y-lg text-center">
                        <h1 class="display-2">教学培训管理系统</h1>
                        <p class="text-muted">Unlimited ideas. Unlimited power. Unlimited joy. Unlimited opportunities.</p>
                    </div>
                    <!-- End Section Content -->
                </div>
            </div>
            <!-- End Page header -->

            <!-- Page content -->
            <div class="page-content">
                <div class="container">
                    <div class="row">
                        <!-- Login card -->
                        <div class="col-md-6 col-md-offset-3" >
                            <div class="card">
                                <h3 class="card-header h4">欢迎使用潘潘教学培训管理系统</h3>
                                <div class="card-block">
                                    <form action="login" method="post" class="js-validation-bootstrap form-horizontal">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                <input type="text" name="account" class="form-control" id="account" placeholder="用户名" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                                 <input type="password" name="password" class="form-control" id="password" placeholder="密码" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="teacher" class="css-input switch switch-sm switch-app">
                                                <input type="radio" id="teacher" name="flag" value="1"/><span></span>老师</a>
                                            </label>
                                            <label for="student" class="css-input switch switch-sm switch-app">
                                                <input type="radio" id="student" name="flag" value="0" checked/><span></span>学生</a>
                                            </label>

                                        </div>
                                        <button type="submit" class="btn btn-app btn-block">登陆</button>
                                        <div class="form-group"><span style="color: red; font-weight: bold">${message}</span></div>
                                    </form>

                                </div>
                                <!-- .card-block -->
                            </div>
                            <!-- .card -->
                        </div>
                        <!-- .col-md-6 -->
                        <!-- End login -->
                    </div>
                    <!-- .row -->
                </div>
                <!-- .container -->
            </div>
            <!-- End page content -->

        </main>


    </div>
    <!-- .app-layout-container -->
</div>
<!-- .app-layout-canvas -->

<!-- AppUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock and App.js -->
<script src="assets/js/core/jquery.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/core/jquery.slimscroll.min.js"></script>
<script src="assets/js/core/jquery.scrollLock.min.js"></script>
<script src="assets/js/core/jquery.placeholder.min.js"></script>
<script src="assets/js/app.js"></script>
<script src="assets/js/app-custom.js"></script>

<!-- Page JS Plugins -->
<script src="assets/js/plugins/jquery-validation/jquery.validate.min.js"></script>

<!-- Page JS Code -->
<script src="assets/js/pages/base_forms_validation.js"></script>
</body>

</html>