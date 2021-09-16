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
                <p>
                    <input id="add" type="button" class="btn btn-app-blue" value="新增" data-toggle="modal" data-target="#modal-add" />
                    <input id="delete" type="button" class="btn btn-danger" value="删除" />
                </p>
<%--                <div class="card-actions">
                    <code>.table-hover</code>
                </div>--%>
            </div>
            <div class="card-block">
                <form action="clazz/batchDelete" method="post" id="form">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                        <th>序号</th>
                        <th class="hidden-xs w-15">名称</th>
                        <th class="text-center" style="width: 100px;">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="s" varStatus="v">
                        <tr>
                            <td class="text-center"><input type="checkbox" value="${s.id}" name="check" ></td>
                            <td>${v.count}</td>
                            <td class="hidden-xs">${s.name}</td>
                            <td class="text-center">
                                <div class="btn-group">
                                    <button class="btn btn-xs btn-default" type="button"  title="Edit client"  data-toggle="modal" data-target="#modal-normal" data-info="${s.name}" data-id="${s.id}"><i class="ion-edit"></i></button>
                                    <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Remove client"  onclick="deleteById('${s.id}')" ><i class="ion-close"></i></button>
                                    <%--<input hidden type="text" value="${s.id}">  onclick="deleteById('${s.id}')"--%>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
<div class="modal" id="modal-normal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <h4>班级修改</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="clazz/update" method="post">
                    <div class="form-group">
                        <label class="col-md-3 control-label">新班级名</label>
                        <div class="col-md-7">
                            <input type="hidden" id="hid" name="id"/>
                            <input name="name" type="text" class="form-control" id="newName"  />
                        </div>
                    </div>
                    <br><br>
                    <button type="submit" class="btn btn-app btn-block" id="sub">修改</button>
                </form>
            </div>

        </div>
    </div>
</div>

<div class="modal" id="modal-add" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <h4>新增班级</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="clazz/save" method="post">
                    <div class="form-group">
                        <label class="col-md-3 control-label">班级名</label>
                        <div class="col-md-7">
                            <select>
                                <option></option>
                            </select>
                        </div>
                    </div>
                    <br><br>
                    <button type="submit" class="btn btn-app btn-block" >新增</button>
                </form>
            </div>

        </div>
    </div>
</div>
<!-- End Apps Modal -->
<%@include file="/common/footer.jsp"%>
<script>
    function deleteById(id){
        if (confirm("您确定要删除吗?")) {
            location.href = "clazz/delete/" + id;
        }
    }
    $(function(){
        $("#all").click(function(){
            var flag = $(this).prop("checked");
            $("input[name=check]").each(function(index,item){
                $(this).prop("checked",flag);
            });
        });
        $("#modal-normal").on("show.bs.modal",function (e) {
            var name = $(e.relatedTarget).data("info");
            var id = $(e.relatedTarget).data("id");
            $("#newName").attr("value",name);
            $("#newName").focus();
            $("#hid").val(id);
        });
        $("#addName,#newName").blur(function () {

            $.ajax({
                url:"clazz/searchByName",
                data:{"name":$(this).val()},
                type:"post",
                /* dataType:"json", */
                success:function(data){
                    if(data=="true"){
                        alert("班级名重复,请重新输入!");
                        $("#newName").val("");
                        $("#newName").focus();
                    }
                }
            });
        });

        $("#add").click(function () {
            $("#addName").focus();
        });
        $("#delete").click(function(){
            var ids = "";
            $("input[name=check]:checked").each(function(){
                ids += $(this).val()+",";
            });
            if(ids==""){
                alert("请选择数据！");
                return;
            }else{
                if(confirm("是否删除？")){
                    $("#form").submit();
                }
            }

        });
        /*App.initHelpers('slick');*/
    });
</script>
</body>
</html>
