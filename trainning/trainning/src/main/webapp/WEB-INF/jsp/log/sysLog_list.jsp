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
                    </p>

                </div>
                <div class="card-block">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                            <th>序号</th>
                            <th class="text-center">账号</th>
                            <th class="text-center">IP</th>
                            <th class="text-center">请求URL</th>
                            <th class="text-center">请求方法</th>
                            <th class="text-center" >操作时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="s" varStatus="n">
                        <tr>
                            <td class="text-center"><input type="checkbox" name="chks" value="${s['ID']}"></td>
                            <td>${n.count}</td>
                            <td class="text-center">${s['ACCOUNT']}</td>
                            <td class="text-center">${s['IP']}</td>
                            <td class="text-center">${s['URL']}</td>
                            <td class="text-center">${s['METHOD']}</td>
                            <td class="text-center">${s['CREATE_TIME']}</td>
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
                                    <a href="log/list/${pageInfo.pageNum-1}"><i class="ion-chevron-left"></i></a>
                                </li>
                            </c:if>
                            <c:if test="${not pageInfo.hasPreviousPage}">
                                <li class="disabled" >
                                    <a href="javasciprt:void(0)"><i class="ion-chevron-left"></i></a>
                                </li>
                            </c:if>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="pn">
                                <li class="${pn==pageInfo.pageNum?'active':''}">
                                    <a href="log/list/${pn}">${pn}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <c:if test="${pageInfo.hasNextPage}">
                            <li >
                                <a href="log/list/${pageInfo.pageNum+1}"><i class="ion-chevron-right"></i></a>
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
                        <font color="red">当前没有查询到结果记录</font>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="modal-clazz" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card-header bg-green bg-inverse">
                <h4>班级</h4>
                <ul class="card-actions">
                    <li>
                        <button data-dismiss="modal" type="button"><i class="ion-close"></i></button>
                    </li>
                </ul>
            </div>
            <div class="card-block">
                <form action="clazz/saveOrUpdate" method="post" class="js-validation-bootstrap form-horizontal">
                    <input type="hidden" name="id" value="">
                    <div class="form-group">
                        <label class="col-md-3 control-label" >名称</label>
                        <div class="col-md-7">
                            <input type="text" name="name" value="" class="form-control" placeholder="请输入班级名称" />
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
    $(function(){
        $("#all").click(function (){
            var that = $(this);
            $("input[name=chks]").each(function(index,item){
                $(this).prop("checked",that.prop("checked"));
            });
        });

        $("#delete").click(function (){
            var ids = "";
            $("input[name=chks]:checked").each(function (index,item){
                ids += $(this).val()+"~";
            });
            if(ids==""){
                alert("请选择要删除的数据！");
                return;
            }else{
                if(confirm('您确定要删除吗？')){
                    ids = ids.substring(0,ids.length-1);
                    location.href = "teacher/deleteAll?ids="+ids;
                }
            }
        });
    })


</script>
