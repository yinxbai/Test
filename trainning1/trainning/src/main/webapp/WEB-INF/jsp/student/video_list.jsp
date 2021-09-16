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
                            <th width="50px" class="text-center" ><input type="checkbox" id="all"></th>
                            <th width="80px" class="text-center">序号</th>
                            <th width="350px"class="text-center" >课程名称</th>
                            <th class="text-center">视频</th>
                            <td class="text-center">上传时间</td>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="s" varStatus="n">
                            <tr>
                                <td class="text-center"><input type="checkbox" name="chks" value="${s.id}"></td>
                                <td class="text-center">${n.count}</td>
                                <td class="text-center">${s.title}</td>
                                <td class="text-center">${s.videoFileName}</td>
                                <td class="text-center">${s.createTime}</td>
                                <td class="text-center">
                                    <button class="btn btn-xs btn-primary" name="play" onclick="play('${s.videoUrl}')">播放</button>
                                    <button class="btn btn-xs btn-app-green">下载</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- .card-block -->
                <div class="card-block">
                    <c:if test="${pageInfo.total>0}">
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
                    </c:if>
                    <c:if test="${pageInfo.total==0}">
                        <span><font color="red">对不起，暂时没有查到相关记录</font></span>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/common/footer_js.jsp"></jsp:include>
</body>
</html>
<script type="text/javascript">
    function play(url) {
        parent.$("#modal-normal-video").modal('show');
        parent.$("#video").attr("src","<%=request.getContextPath()%>"+url);
    }

</script>
