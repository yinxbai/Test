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
                    <div><input id="add" type="button" class="btn btn-app-blue" value="新增" data-toggle="modal" data-target="#modal-add" />
                        <input id="del" type="button" class="btn btn-danger" value="删除">
                    </div>
                </div>
                <div class="card-block">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th class="text-center" style="width: 50px;"><input type="checkbox" id="selectAll"></th>
                            <th>序号</th>
                            <th class="hidden-xs w-15">名称</th>
                            <th class="text-center" style="width: 100px;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="s" varStatus="v">
                            <tr>
                                <td class="text-center"><input type="checkbox" value="${s.id}" name="chk"></td>
                                <td>${v.count}</td>
                                <td class="hidden-xs">${s.name}</td>
                                <td class="text-center">
                                    <div class="btn-group">
                                        <button class="btn btn-xs btn-default" type="button"  title="Edit client"  data-toggle="modal" data-target="#modal-normal" data-info="${s.name}" data-id="${s.id}"><i class="ion-edit"></i></button>
                                        <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Remove client" onclick="deleteById(${s.id})"><i class="ion-close"></i></button>
                                            <%--<input hidden type="text" value="${s.id}">--%>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- .card-block -->
            </div>
            <!-- .card -->
            <!-- End Hover Table -->
        </div>
    </div>
</div>

<!-- Normal Modal -->

<div class="modal" id="modal-add" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card-header bg-green bg-inverse">
                        <h4>班级修改</h4>
                        <ul class="card-actions">
                            <li>
                                <button data-dismiss="modal" type="button" onclick="window.close()"><i class="ion-close"></i></button>
                            </li>
                        </ul>
                    </div>
                    <div class="card">
                        <div class="card-block">
                            <form class="js-validation-bootstrap form-horizontal" action="student/save" method="post">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="name">Name <span class="text-orange">*</span></label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="name" name="name" placeholder="Choose a nice Name..." />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="val-email">Account <span class="text-orange">*</span></label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="val-email" name="account" placeholder="Enter your valid account..." />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="val-password">Password <span class="text-orange">*</span></label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="password" id="val-password" name="password" placeholder="Choose a good one.." />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="val-email">Sex <span class="text-orange">*</span></label>
                                    <div class="col-md-7">
                                        <label for="man" class="css-input switch switch-sm switch-app">
                                            <input type="radio" id="man" name="sex" value="1" checked/><span></span> 男</a>
                                        </label>&nbsp;&nbsp;
                                        <label for="women" class="css-input switch switch-sm switch-app">
                                            <input type="radio" id="women" name="sex" value="0" /><span></span> 女</a>
                                        </label>
                                    </div>
                                </div>
                                <div>
                                    <label class="col-md-4 control-label" for="val-password">Birthday <span class="text-orange">*</span></label>
                                    <div class="col-md-7">
                                        <label for="birthday"></label><input type="date" name="birthday" id="birthday">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="clazz">班级 <span class="text-orange">*</span></label>
                                    <div class="col-md-7">
                                        <select class="form-control" id="clazz" name="clazz">
                                            <option value="">Please select</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="val-password">Telephone <span class="text-orange">*</span></label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="telephone" name="telephone" placeholder="Input you telephone.." />
                                    </div>
                                </div>
                                <div class="form-group m-b-0">
                                    <div class="col-md-8 col-md-offset-5">
                                        <button class="btn btn-app" type="submit">保存</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- .card-block -->
                    </div>
                    <!-- .card -->
                    <!-- Bootstrap Forms Validation -->
                </div>
                <!-- .card -->
                <!-- End Material (floating) registration -->
            </div>
        </div>
    </div>
</div>
            <!-- .col-lg-4 -->
<!-- End Apps Modal -->
<%@include file="/common/footer.jsp"%>
<script>
    function deleteById(id){
        if (confirm("您确定要删除吗?")) {
            alert(id);
            location.href = "clazz/delete/" + id;
        }
    }
    $(function(){
        $("#modal-normal").on("show.bs.modal",function (e) {

        });
        $("#add").click(function () {
            $("#addName").focus();
        });

       $("#del").click(function (){
           let ids = "";
           $("input[name=chk]:checked").each(function (){
               ids += $(this).val() + ",";
           });
           if (ids==""){
               alert("请输入要删除的数据！");
           }else {
               if (confirm("确定要删除吗？")){
                   $("#form").submit();
               }
           }
       });
       $("#selectAll").click(function (){
           let flag = $(this).prop("checked");
           $("input[name=chk]").each(function (){
               $(this).prop("checked",flag);
           });
       });

    });
</script>
</body>
</html>
