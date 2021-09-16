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
                        <button class="btn btn-sm btn-primary" type="button" id="add">新增</button>
                        <button class="btn btn-sm btn-danger" type="button" id="delete">删除</button>
                    </p>

                </div>
                <div class="card-block">
                    <table class="table table-hover">
                        <thead>
                        <tr >
                            <th width="50px" class="text-center"><input type="checkbox" id="all"></th>
                            <th width="100px" class="text-center">序号</th>
                            <th width="200px" class="text-center">标题</th>
                            <th width="150px" class="text-center">PPT</th>
                            <th width="150px" class="text-center">视频</th>
                            <th width="150px" class="text-center">作业</th>
                            <th width="150px" class="text-center">时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="s" varStatus="n">
                        <tr>
                            <td class="text-center"><input type="checkbox" value="${s.id}" name="chks"></td>
                            <td class="text-center">${n.count}</td>
                            <td class="text-center">${s.title}</td>
                            <td class="text-center"><a href="courseResource/download?url=${s.pptUrl}&filename=${s.pptFileName}">${s.pptFileName}</a></td>
                            <td class="text-center"><a href="courseResource/download?url=${s.videoUrl}&filename=${s.videoFileName}">${s.videoFileName}</a></td>
                            <td class="text-center"><a href="courseResource/download?url=${s.exerciseUrl}&filename=${s.exerciseFileName}">${s.exerciseFileName}</a></td>
                            <td class="text-center">${s.createTime}</td>

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
<jsp:include page="${pageContext.request.contextPath}/common/footer_js.jsp"></jsp:include>
<!-- Page JS Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/plugins/datatables/jquery.dataTables.min.js"></script>
<!-- Page JS Code -->
<script src="${pageContext.request.contextPath}/assets/js/pages/base_tables_datatables.js"></script>

<script type="text/javascript">
    $(function(){
        $("#add").click(function (){
            location.href = "${pageContext.request.contextPath}/courseResource/add";
        });

         $("#all").click(function (){
             var that = $(this);
             $("input[name=chks]").each(function (index, item){
                 $(this).prop("checked",that.prop("checked"));
             });
         });

         $("#delete").click(function(){
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
                    location.href = "teacher/deleteAll/"+ids;
                }
            }
         });
    })
</script>
</body>
</html>
