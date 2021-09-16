<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
                        <button class="btn btn-sm btn-danger" type="button" id="back" onclick="history.back()">返回</button>
                    </p>

                </div>
                <div class="card-block">
                    <form action="courseResource/save" enctype="multipart/form-data" method="post" class="js-validation-bootstrap form-horizontal">
                       <input type="hidden" name="id" value="${id}">
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="title">标题<span class="text-orange">*</span></label>
                            <div class="col-md-7">
                                <input type="text" name="title" id="title" class="form-control"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label" >课件<span class="text-orange">*</span></label>
                            <div class="col-md-7">
                                <input type="file" name="ppt" class="form-control" id="ppt" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label" >视频<span class="text-orange">*</span></label>
                            <div class="col-md-7">
                                <input type="file" name="video" class="form-control" id="video" accept="video/mpeg"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label" >作业<span class="text-orange">*</span></label>
                            <div class="col-md-7">
                                <input type="file" name="exercise" class="form-control" id="exercise" />
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

</body>
</html>
<!-- Page JS Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/plugins/jquery-validation/jquery.validate.min.js"></script>

<!-- Page JS Code -->
<script src="${pageContext.request.contextPath}/js/courseResource_validation.js"></script>
