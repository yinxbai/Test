<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="br">
<head>
    <%@include file="/common/header.jsp"%>
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
                    <form action="courseResource/batchDelete" method="post" id="form">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                                <th>序号</th>
                                <th class="hidden-xs w-15">标题</th>

                                <th class="hidden-xs w-15">作业名称</th>

                                <th class="hidden-xs w-15">创建时间</th>
                                <th class="text-center" style="width: 100px;">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="s" varStatus="v">
                                <tr >
                                    <td class="text-center"><input type="checkbox" value="${s.id}" name="check"></td>
                                    <td>${v.count}</td>
                                    <td class="hidden-xs">${s.title}</td>
                                    <td class="hidden-xs"><a href="/courseResource/edit?path=${s.exercise}">${s.exerciseFileName}</a></td>
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
                </div>
                <!-- .card-block -->
            </div>
            <!-- .card -->
            <!-- End Hover Table -->
        </div>
    </div>
</div>

<!-- Normal Modal -->
<%@include file="/common/footer.jsp"%>

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
