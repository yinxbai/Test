<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html class="app-ui">

<head>
<%@include file="/common/header.jsp"%>
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
                    </div>
                    <!-- End Section Content -->
                </div>
            </div>
            <!-- End Page header -->
            <!-- Page content -->
            <div class="page-content" >
                <div class="container">
                    <div class="row">
                        <!-- Login card -->
                        <div class="col-md-6 col-md-offset-3" >
                            <div class="card">
                                <h3 class="card-header h4">Login</h3>
                                <div class="card-block">
                                    <form action="login" method="post">
                                        <div class="form-group">
                                            <label class="sr-only" for="frontend_login_email">用户名</label>
                                            <input name="account" type="text" class="form-control" id="frontend_login_email" placeholder="Account" />
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="frontend_login_password">密码</label>
                                            <input name="password"  type="password" class="form-control" id="frontend_login_password" placeholder="Password" />
                                        </div>
                                        <div class="form-group">
                                            <label for="teacher" class="css-input switch switch-sm switch-app">
                                                <input type="radio" id="teacher" name="flag" value="1" checked/><span></span> 老师</a>
                                            </label>&nbsp;&nbsp;
                                            <label for="student" class="css-input switch switch-sm switch-app">
                                                <input type="radio" id="student" name="flag" value="0" /><span></span> 学生</a>
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-app btn-block" id="sub">登录</button>
                                    </form>
                                    ${message}
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

            <!-- Modal -->
            <div class="modal" id="modal-signup-terms" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="card-header bg-blue bg-inverse">
                            <h4>Terms &amp; Conditions</h4>
                            <ul class="card-actions">
                                <li>
                                    <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                                </li>
                            </ul>
                        </div>
                        <div class="card-block">
                            <p>Dolor posuere proin blandit accumsan senectus netus nullam curae, ornare laoreet adipiscing luctus mauris adipiscing pretium eget fermentum, tristique lobortis est ut metus lobortis tortor tincidunt himenaeos habitant
                                quis dictumst proin odio sagittis purus mi, nec taciti vestibulum quis in sit varius lorem sit metus mi.</p>
                            <p>Dolor posuere proin blandit accumsan senectus netus nullam curae, ornare laoreet adipiscing luctus mauris adipiscing pretium eget fermentum, tristique lobortis est ut metus lobortis tortor tincidunt himenaeos habitant
                                quis dictumst proin odio sagittis purus mi, nec taciti vestibulum quis in sit varius lorem sit metus mi.</p>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-sm btn-default" type="button" data-dismiss="modal">Close</button>
                            <button class="btn btn-sm btn-app" type="button" data-dismiss="modal"><i class="ion-checkmark"></i> Ok</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End modal -->

        </main>



    </div>
    <!-- .app-layout-container -->
</div>
<!-- .app-layout-canvas -->

<!-- Apps Modal -->
<!-- Opens from the button in the header -->
<div id="apps-modal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-sm modal-dialog modal-dialog-top">
        <div class="modal-content">
            <!-- Apps card -->
            <div class="card m-b-0">
                <div class="card-header bg-app bg-inverse">
                    <h4>Apps</h4>
                    <ul class="card-actions">
                        <li>
                            <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                        </li>
                    </ul>
                </div>
                <div class="card-block">
                    <div class="row text-center">
                        <div class="col-xs-6">
                            <a class="card card-block m-b-0 bg-app-secondary bg-inverse" href="index.html">
                                <i class="ion-speedometer fa-4x"></i>
                                <p>Admin</p>
                            </a>
                        </div>
                        <div class="col-xs-6">
                            <a class="card card-block m-b-0 bg-app-tertiary bg-inverse" href="frontend_home.html">
                                <i class="ion-laptop fa-4x"></i>
                                <p>Frontend</p>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- .card-block -->
            </div>
            <!-- End Apps card -->
        </div>
    </div>
</div>
<!-- End Apps Modal -->

<!-- AppUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock and App.js -->
<script src="assets/js/core/jquery.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/core/jquery.slimscroll.min.js"></script>
<script src="assets/js/core/jquery.scrollLock.min.js"></script>
<script src="assets/js/core/jquery.placeholder.min.js"></script>
<script src="assets/js/app.js"></script>
<script src="assets/js/app-custom.js"></script>
<script>

    $(function(){
        $("[name=account]").focus();
        $("#sub").click(function(){
            var account = $("[name=account]").val();
            var password = $("[name=password]").val();
            if(account==""){
                alert("用户名不能为空");
                return false;
            }
            if(password==""){
                alert("密码不能为空");
                return false;
            }
        });
    });



</script>
</body>

</html>
