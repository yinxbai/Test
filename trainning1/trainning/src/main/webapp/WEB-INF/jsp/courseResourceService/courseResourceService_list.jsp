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
                        <input id="add" type="button" class="btn btn-app-blue" value="新增"  />
                        <input id="delete" type="button" class="btn btn-danger" value="删除" />
                    </p>
                    <%--                <div class="card-actions">
                                        <code>.table-hover</code>
                                    </div>--%>
                </div>
                <div class="card-block">
                    <form action="${pageContext.request.contextPath}/courseResource/batchDelete" method="post" id="form">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                                <th>序号</th>
                                <th class="hidden-xs w-15">标题</th>
                                <th class="hidden-xs w-15">ppt</th>
                                <th class="hidden-xs w-15">视频</th>
                                <th class="hidden-xs w-15">练习</th>
                                <th class="hidden-xs w-15">创建时间</th>
                                <th class="text-center" style="width: 100px;">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="s" varStatus="v">
                                <tr >
                                    <td class="text-center"><input type="checkbox" value="${s.id}" name="check"></td>
                                    <td>${v.count}</td>
                                    <td class="hidden-xs">${s.title}</td>
                                    <td class="hidden-xs"><a href="courseResource/download?path=${s.ppt}&filename=${s.pptFileName}">${s.pptFileName}</a></td>
                                    <td class="hidden-xs"><a href="courseResource/download?path=${s.video}&filename=${s.videoFileName}">${s.videoFileName}</a></td>
                                    <td class="hidden-xs"><a href="courseResource/download?path=${s.exercise}&filename=${s.exerciseFileName}">${s.exerciseFileName}</a></td>
                                    <td class="hidden-xs">${s.createTime}</td>
                                    <td class="text-center">
                                        <div class="btn-group">
                                            <button class="btn btn-xs btn-default" type="button"  title="Edit client"  data-toggle="tooltip" ><i class="ion-edit"></i></button>
                                            <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Remove client" onclick="deleteById(${s.id})"><i class="ion-close"></i></button>
                                                <%--<input hidden type="text" value="${s.id}">--%>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                    <div class="card-block">
                        <nav>
                            <ul class="pagination pagination-sm">
                                <c:if test="${pageInfo.hasPreviousPage}">
                                    <li >
                                        <a href="/courseResource/list/${pageInfo.pageNum-1}/${user.id}"><i class="ion-chevron-left"></i></a>
                                    </li>
                                </c:if>
                                <c:if test="${not pageInfo.hasPreviousPage}">
                                    <li class="disabled">
                                        <a href="javascript:void(0)"><i class="ion-chevron-left"></i></a>
                                    </li>
                                </c:if>
                                <c:forEach items="${pageInfo.navigatepageNums}" var="s">
                                    <li class="${s==pageInfo.pageNum?'active':''}">
                                        <a href="/courseResource/list/${s}/${user.id}">${s}</a>
                                    </li>
                                </c:forEach>

                                <c:if test="${pageInfo.hasNextPage}">
                                    <li>
                                        <a href="/courseResource/list/${pageInfo.pageNum+1}/${user.id}"><i class="ion-chevron-right"></i></a>
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
    function deleteById(id){
        if (confirm("您确定要删除吗?")) {
            location.href = "teacher/delete/" + id;
        }
    }
    $(function(){
        $("#modal-normal").on("show.bs.modal",function (e) {
            var name = $(e.relatedTarget).data("info");
            var id = $(e.relatedTarget).data("id");
            $("#newName").attr("value",name);
            $("#newName").focus();
            $("#hid").val(id);
        });
        $("#add").click(function () {
            location.href = "courseResource/add";
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
