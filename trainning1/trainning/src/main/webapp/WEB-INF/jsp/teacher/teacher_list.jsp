<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
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
                    <p>
                        <input id="save" type="button" class="btn btn-app-blue" value="新增" data-toggle="modal" data-target="#modal-add" />
                        <input id="delete" type="button" class="btn btn-danger" value="删除" />
                    </p>
                </div>
                <div class="card-block">
                    <form action="teacher/batchDelete" method="post" id="form">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                            <th>序号</th>
                            <th class="hidden-xs w-15">账号</th>
                            <th class="hidden-xs w-15">姓名</th>
                            <th class="hidden-xs w-15">班级</th>
                            <th class="hidden-xs w-15">角色</th>
                            <th class="text-center" style="width: 100px;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="s" varStatus="v">
                            <tr>
                                <td class="text-center"><input type="checkbox" value="${s.id}" name="check"></td>
                                <td>${v.count}</td>
                                <td class="hidden-xs">${s.account}</td>
                                <td class="hidden-xs">${s.name}</td>
                                <td class="hidden-xs">${s.clazz.name}</td>
                                <td class="hidden-xs">${s.role}</td>
                                <td class="text-center">
                                    <div class="btn-group">
                                        <button class="btn btn-xs btn-default" type="button"  title="Edit client"  data-toggle="modal" data-target="#modal-normal" onclick="info(${s.id},${s.name},${s.clazz.id},${s.role})"><i class="ion-edit"></i></button>
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
                <h4>教师信息修改</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="clazz/update" method="post">
                    <input type="hidden" id="hid" name="id"/>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="newName">姓名</label>
                        <div class="col-md-7">
                            <input name="name" type="text" class="form-control" id="newName"  />
                        </div><br><br>
                        <label class="col-md-3 control-label" for="clazzs">班级</label>
                        <div class="col-md-7 form-group">
                            <select name="clazz.id" id="clazzs">
                                <option value="">--请选择--</option>
                            </select>
                        </div><br><br>
                        <label class="col-md-3 control-label" for="newRole">角色</label>
                        <div class="col-md-7 form-group">
                            <input name="role" type="text" class="form-control" id="newRole"  />
                        </div>
                    </div>
                    <br><br>
                    <button type="submit" class="btn btn-app btn-block" id="subm">修改</button>
                </form>
            </div>

        </div>
    </div>
</div>

<div class="modal" id="modal-add" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <h4>新增教师</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="clazz/save" method="post">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="addName">姓名</label>
                        <div class="col-md-7">
                            <input name="name" type="text" class="form-control" id="addName"  />
                        </div><br><br>
                        <label class="col-md-3 control-label" for="clazzes">班级</label>
                        <div class="col-md-7 form-group">
                            <select name="clazz.id" id="clazzes">
                                <%--<c:forEach items="${clazzList}" var="c" >
                                    <option value="${c.id}" ${customer.city.id==c.id?"selected":""}>${c.name}</option>
                                </c:forEach>--%>
                            </select>
                        </div><br><br>
                        <label class="col-md-3 control-label" for="addRole">角色</label>
                        <div class="col-md-7 form-group">
                            <input name="role" type="text" class="form-control" id="addRole"  />
                        </div>
                    </div>
                    <br><br>
                    <button type="submit" class="btn btn-app btn-block" id="sub">提交</button>
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
            location.href = "teacher/delete/" + id;
        }
    }
    $(function(){
        $("#modal-normal").on("show.bs.modal",function (e) {

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
        $.ajax({
            url:"city/list",
            type:"get",
            dataType:"json",
            success:function (data){
                $("#clazzs").find('<option>').remove();
                $("#clazzs").append("<option value=''>--请选择--</option>");
                $.each(data,function(index,item){
                    $("#clazzs").append("<option value='"+item.id+"'>"+item.name+"</option>")
                });
            }
        })
    });
</script>
</body>
</html>
