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
            <div class="card">
                <div class="card-block">
                    <form action="clazz/batchDelete" method="post" id="form">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                                <th>序号</th>
                                <th class="hidden-xs w-15">账号</th>
                                <th class="hidden-xs w-15">IP</th>
                                <th class="hidden-xs w-15">请求路径</th>
                                <th class="hidden-xs w-15">方法</th>
                                <th class="hidden-xs w-15">操作时间</th>
                                <th class="text-center" style="width: 100px;">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="s" varStatus="v">
                                <tr>
                                    <td class="text-center"><input type="checkbox" value="${s['ID']}" name="check" ></td>
                                    <td>${v.count}</td>
                                    <td class="hidden-xs">${s['ACCOUNT']}</td>
                                    <td class="hidden-xs">${s['IP']}</td>
                                    <td class="hidden-xs">${s['URL']}</td>
                                    <td class="hidden-xs">${s['METHOD']}</td>
                                    <td class="hidden-xs">${s['CREATE_TIME']}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${pageInfo.total>0}">
                            <div class="card-block">
                                <nav>
                                    <ul class="pagination pagination-sm">
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li >
                                                <a href="/teacher/queryList/${pageInfo.pageNum-1}"><i class="ion-chevron-left"></i></a>
                                            </li>
                                        </c:if>
                                        <c:if test="${not pageInfo.hasPreviousPage}">
                                            <li class="disabled">
                                                <a href="javascript:void(0)"><i class="ion-chevron-left"></i></a>
                                            </li>
                                        </c:if>
                                        <c:forEach items="${pageInfo.navigatepageNums}" var="s">
                                            <li class="${s==pageInfo.pageNum?'active':''}">
                                                <a href="/teacher/queryList/${s}">${s}</a>
                                            </li>
                                        </c:forEach>

                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li>
                                                <a href="/teacher/queryList/${pageInfo.pageNum+1}"><i class="ion-chevron-right"></i></a>
                                            </li>
                                        </c:if>
                                        <c:if test="${not pageInfo.hasNextPage}">
                                            <li class="disabled">
                                                <a href="javascript:void(0)"><i class="ion-chevron-right"></i></a>
                                            </li>
                                        </c:if>
                                    </ul>
                                    <ul>
                                        <li>当前第${(pageInfo.pageNum-1)*pageInfo.pageSize+1}条——第${pageInfo.hasNextPage?pageInfo.pageNum*pageInfo.pageSize:pageInfo.total}条记录/共${pageInfo.total}条记录</li>
                                        <li>当前共${pageInfo.pages}页</li>

                                    </ul>
                                </nav>
                            </div>
                        </c:if>
                        <c:if test="${pageInfo.total==0}">
                            <div class="error">
                                 <span background-color="red">
                                当前没有查询到记录
                            </span>
                            </div>
                        </c:if>
                    </form>
                </div>
                <!-- .card-block -->
            </div>
            <!-- .card -->
            <!-- End Hover Table -->

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
