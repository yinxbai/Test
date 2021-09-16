<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%--<base href="<%=request.getContextPath()%>/">--%>
    <jsp:include page="${pageContext.request.contextPath}/common/head_link.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid p-y-md">
    <div class="row">
        <div class="col-lg-12">
            <!-- Hover Table -->
            <div class="card">
                <div class="card-header">
                    <p>
                        <button class="btn btn-sm btn-primary" type="button" id="exportExcel">导出Excel</button>
                        <button class="btn btn-sm btn-danger" type="button" id="importExcel">导入Excel</button>
                    </p>
                    <c:if test="${sys!=0}">
                    <p>
                        <button class="btn btn-sm btn-primary" type="button" id="add">新增</button>
                        <button class="btn btn-sm btn-danger" type="button" id="deleteAll">删除</button>
                    </p>
                    </c:if>
                </div>

                <div class="card-block">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                            <th class="text-center">序号</th>
                            <th class="text-center">姓名</th>
                            <th class="text-center">账号</th>
                            <th class="text-center">密码</th>
                            <th class="text-center">性别</th>
                            <th class="text-center">班级</th>
                            <th class="text-center">电话</th>
                            <th class="text-center">出生日期</th>
                            <c:if test="${sys!=0}">
                            <th class="text-center" style="width: 100px;">操作</th>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="s" varStatus="n">
                        <tr>
                            <td class="text-center"><input type="checkbox" value="${s.id}" name="chks"></td>
                            <td>${n.count}</td>
                            <td class="text-center">${s.name}</td>
                            <td class="text-center">${s.account}</td>
                            <td class="text-center">${s.password}</td>
                            <td class="text-center">${s.sex==1?'男':'女'}</td>
                            <td class="text-center">${s.clazz.name}</td>
                            <td class="text-center">${s.telphone}</td>
                            <td class="text-center">${s.birthday}</td>
                            <c:if test="${sys!=0}">
                            <td class="text-center">
                                <div class="btn-group">
                                    <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="编辑" onclick="edit('${s.id}')"><i class="ion-edit"></i></button>
                                    <button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="删除" onclick="del('${s.id}')"><i class="ion-close"></i></button>
                                </div>
                            </td>
                            </c:if>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-block">
                        <nav>
                            <ul class="pagination pagination-sm">
                                <c:if test="${pageInfo.hasPreviousPage}">
                                    <li >
                                        <a href="teacher/queryList/${pageInfo.pageNum-1}"><i class="ion-chevron-left"></i></a>
                                    </li>
                                </c:if>
                                <c:if test="${not pageInfo.hasPreviousPage}">
                                    <li class="disabled" >
                                        <a href="javasciprt:void(0)"><i class="ion-chevron-left"></i></a>
                                    </li>
                                </c:if>
                                <c:forEach items="${pageInfo.navigatepageNums}" var="pn">
                                <li class="${pn==pageInfo.pageNum?'active':''}">
                                    <a href="teacher/queryList/${pn}">${pn}</a>
                                </li>
                                </c:forEach>
                                <li>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <li >
                                        <a href="teacher/queryList/${pageInfo.pageNum+1}"><i class="ion-chevron-right"></i></a>
                                    </li>
                                </c:if>
                                <c:if test="${not pageInfo.hasNextPage}">
                                    <li class="disabled" >
                                        <a href="javasciprt:void(0)"><i class="ion-chevron-right"></i></a>
                                    </li>
                                </c:if>
                            </ul>
                            <ul class="pagination pagination-sm">
                                <li>当前第${(pageInfo.pageNum-1)*pageInfo.pageSize+1} ~ ${pageInfo.pageNum*pageInfo.pageSize>pageInfo.total?pageInfo.total:pageInfo.pageNum*pageInfo.pageSize}条/共${pageInfo.total}条</li>
                                <li>共${pageInfo.pages}页</li>
                            </ul>
                        </nav>
                </div>
                <!-- .card-block -->
            </div>
        </div>
    </div>
</div>

<!-- Apps Modal 新增学生-->
<div class="modal" id="modal-student-add" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="student/saveOrUpdate" method="post" class="js-validation-bootstrap form-horizontal">
                   <input type="hidden" name="id" id="id" value="">
                    <div class="form-group">
                        <label class="col-md-3 control-label" >姓名<span class="text-orange">*</span></label>
                        <div class="col-md-7">
                            <input type="text" name="name" class="form-control" id="name" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" >账号<span class="text-orange">*</span></label>
                        <div class="col-md-7">
                            <input type="text" name="account" class="form-control" id="account" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" >密码<span class="text-orange">*</span></label>
                        <div class="col-md-7">
                            <input type="password" name="password" class="form-control" id="password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" >性别</label>
                        <div class="col-md-7">
                            <label for="sex-1" class="css-input switch switch-sm switch-app">
                                <input type="radio" id="sex-1" name="sex" value="1" checked/><span></span>男</a>
                            </label>
                            <label for="sex-0" class="css-input switch switch-sm switch-app">
                                <input type="radio" name="sex" id="sex-0" value="0" /><span></span>女</a>
                            </label>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" >电话</label>
                        <div class="col-md-7">
                            <input type="text" name="telphone" class="form-control" id="telphone" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" >出生日期</label>
                        <div class="col-md-7">
                            <input type="date" name="birthday" class="form-control" id="birthday" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" >班级<span class="text-orange">*</span></label>
                        <div class="col-md-7">
                            <select name="clazz.id" class="form-control" id="clazz">

                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-app btn-block">保存</button>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/common/footer_js.jsp"></jsp:include>
<!-- Page JS Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/plugins/datatables/jquery.dataTables.min.js"></script>
<!-- Page JS Code -->
<script src="${pageContext.request.contextPath}/assets/js/pages/base_tables_datatables.js"></script>

<script type="text/javascript">
    $(function(){
        $("#add").click(function (){
            $("#modal-student-add form")[0].reset();
            $(".form-group").removeClass( 'has-error' );
            $(".help-block").remove();
            $.ajax({
                url:"clazz/queryJson",
                type:"post",
                dataType:"json",
                success:function (data){
                    $("#clazz").html("");
                    $("#clazz").append("<option value='' >--请选择--</option>");
                    $.each(data,function (index,item){
                        $("#clazz").append("<option value='"+item.id+"'>"+item.name+"</option>");
                    })
                    $("#modal-student-add").modal("show");
                }
            });
        });

         $("#all").click(function (){
             var that = $(this);
             $("input[name=chks]").each(function (index, item){
                 $(this).prop("checked",that.prop("checked"));
             });
         });

         $("#deleteAll").click(function(){
            var ids = "";
            $("input[name=chks]:checked").each(function(index,item){
                ids += $(this).val()+",";
            });
            if(ids==""){
                alert("请选择要删除的数据！");
                return;
            }else{
                if(confirm("您确定要删除吗？")){
                    ids = ids.substring(0,ids.length-1);
                    location.href = "student/deleteAll?ids="+ids;
                }
            }
         });

    })
    function edit(id){
        $.ajax({
            url:"${pageContext.request.contextPath}/student/findById",
            type: "post",
            data:{"id":id},
            dataType:"json",
            success: function (data){
               $("#modal-student-add form [name=id]").val(data.id);
                $("#modal-student-add form [name=account]").val(data.account);
                $("#modal-student-add form [name=password]").val(data.password);
                $("#modal-student-add form [name=name]").val(data.name);
                $("#modal-student-add form [name=telphone]").val(data.telphone);
                $("#modal-student-add form [name=birthday]").val(data.birthday);
                if(data.sex==1){
                    $("#modal-student-add form [name=sex]:eq(0)").prop("checked",true);
                }else{
                    $("#modal-student-add form [name=sex]:eq(1)").prop("checked",true);
                }
                var clazzId = data.clazz.id;
                $.ajax({
                    url:"clazz/queryJson",
                    type:"post",
                    dataType:"json",
                    success:function (data){
                        $("#clazz").html("");
                        $("#clazz").append("<option value='' >--请选择--</option>");
                        $.each(data,function (index,item){
                            $("#clazz").append("<option value='"+item.id+"' ${clazzId==item.id?'selected':''}>"+item.name+"</option>");
                        })
                    }
                });
                $("#modal-student-add").modal("show");
            }
        });
    }
    function del(id){
        if(confirm(("您确定要删除吗？"))){
            location.href = "${pageContext.request.contextPath}/student/del?id="+id;
        }
    }
</script>
</body>
</html>
<!-- Page JS Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/plugins/jquery-validation/jquery.validate.min.js"></script>
<!-- Page JS Code -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/student_validation.js"></script>

