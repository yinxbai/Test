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
                <div class="card-block">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th width="80px" class="text-center">序号</th>
                            <th width="350px"class="text-center" >课程名称</th>
                            <th class="text-center">作业</th>
                            <th class="text-center">我交的作业</th>
                            <td class="text-center">上传时间</td>
                            <td class="text-center">分数</td>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="s" varStatus="n">
                            <tr>
                                <td class="text-center">${n.count}</td>
                                <td class="text-center">${s['title']}</td>
                                <td class="text-center">${s['exercise_filename']}</td>
                                <td class="text-center"><a href="${s['file_url']}">${s['file_name']}</a></td>
                                <td class="text-center">${s['CREATE_TIME']}</td>
                                <td class="text-center">${s['score']}</td>
                                <td class="text-center">
                                    <c:if test="${s['file_url']==null}">
                                        <button class="btn btn-xs btn-primary" name="btn-upload" onclick="upload('${s['id']}')">上传作业</button>
                                    </c:if>
                                   </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- .card-block -->
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
            </div>
        </div>
    </div>
</div>
<!-- 模态窗口 -->
<div class="modal" id="modal-exercise" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button" id="video-close"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="exercise/save" method="post" enctype="multipart/form-data" class="js-validation-bootstrap form-horizontal">
                    <input type="hidden" name="studentId" value="${user.id}">
                    <input type="hidden" name="courseResourceId" value="">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="exercise">附件</label>
                        <div class="col-md-7">
                            <input type="file" name="upload" class="form-control" id="exercise" placeholder="请上传作业" />
                        </div>
                    </div>
                    <button type="submit" class="btn btn-app btn-block">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/common/footer_js.jsp"></jsp:include>
</body>
</html>
<script type="text/javascript">
    function upload(courseResourceId){
        $("[name=btn-upload]").click(function (){
            $("form")[0].reset();
            $("#modal-exercise [name=courseResourceId]").val(courseResourceId);
            $("#modal-exercise").modal("show");
        });
    }


</script>
