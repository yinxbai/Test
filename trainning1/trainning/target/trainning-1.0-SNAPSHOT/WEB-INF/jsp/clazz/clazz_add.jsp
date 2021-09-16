<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%--<base href="<%=request.getContextPath()%>/">--%>
    <jsp:include page="${pageContext.request.contextPath}/common/head_link.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/clazz_validation.js"></script>
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
                        <button class="btn btn-sm btn-danger" type="button" id="delte">删除</button>
                    </p>

                </div>
                <div class="card-block">
                    <form action="clazz/save" method="post" class="js-validation-bootstrap form-horizontal">
                       <input type="hidden" name="id" value="${id}">
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="name">名称X</label>
                            <div class="col-md-7">
                                <input type="text" name="name" class="form-control" id="name" />
                            </div>
                        </div>
                        <button type="submit" class="btn btn-app btn-block">保存</button>
                    </form>
                </div>
                <!-- .card-block -->
            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/common/footer_js.jsp"></jsp:include>
<script type="text/javascript">
    $(function(){
        $("#add").click(function (){
            location.href = "${pageContext.request.contextPath}/clazz/add";
        });

    })
</script>
</body>
</html>
