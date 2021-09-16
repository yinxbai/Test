<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/6/4
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Meta -->
    <base href="${pageContext.request.contextPath}/"/>
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
<div class="container-fluid p-y-md">
    <div class="row">
        <div class="col-lg-12">
            <!-- Hover Table -->
            <div class="card">
                <div class="card-header">
                    <%--                <div class="card-actions">
                                        <code>.table-hover</code>
                                    </div>--%>
                </div>
                <div class="card-block">
                    <p>
                        <input  type="button" class="btn btn-danger" value="返回" onclick="javascript:history.go(-1)"/>
                    </p>
                    <form action="courseResource/save" method="post" id="form" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${id}">
                        <table class="table table-hover">

                                <tr >
                                    <td class="hidden-xs">标题</td>
                                    <td><input type="text" name="title"></td>
                                </tr>
                                <tr>
                                    <td class="hidden-xs">ppt</td>
                                    <td><input type="file" name="pptFile"></td>
                                </tr>
                                <tr>
                                    <td class="hidden-xs">视频</td>
                                    <td><input type="file" name="videoFile"></td>
                                </tr>
                                <tr>
                                    <td class="hidden-xs">作业</td>
                                    <td><input type="file" name="exerciseFile"></td>

                                </tr>
                        </table>
                        <button type="submit" class="btn btn-app btn-block" id="sub">提交</button>
                    </form>


                </div>
                <!-- .card-block -->
            </div>
            <!-- .card -->
            <!-- End Hover Table -->
        </div>
    </div>
</div>

<!-- Normal Modal -->


<!-- End Apps Modal -->
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

<script>

    $(function(){

    });
</script>
</body>
</html>
