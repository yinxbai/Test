<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="/common/header.jsp" %>
</head>
<body class="app-ui layout-has-drawer layout-has-fixed-header">
<div class="container-fluid p-y-md">
    <div class="row">
        <div class="col-lg-12">
            <!-- Hover Table -->
            <div class="card">
                <div class="card-header">

                    <div class="card-block">
                        <form action="courseResource/batchDelete" method="post" id="form">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th class="text-center" style="width: 50px;"><input type="checkbox" id="all"></th>
                                    <th>序号</th>
                                    <th class="hidden-xs w-15">标题</th>

                                    <th class="hidden-xs w-15">视频名称</th>

                                    <th class="hidden-xs w-15">创建时间</th>
                                    <th class="text-center" style="width: 100px;">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="s" varStatus="v">
                                    <tr>
                                        <td class="text-center"><label>
                                            <input type="checkbox" value="${s.id}" name="check">
                                        </label></td>
                                        <td>${v.count}</td>
                                        <td class="hidden-xs">${s.title}</td>
                                        <td class="hidden-xs">${s.videoFileName}</td>
                                        <td class="hidden-xs">${s.createTime}</td>
                                        <td class="text-center">
                                            <button class="btn btn-xs btn-primary" type="button" name="play"
                                                    onclick="playVedio('${s.video}')">播放
                                            </button>
<%--                                            <button class="btn btn-xs btn-app-green" type="button"--%>
<%--                                                    onclick="download('${s.video}','${s.videoFileName}')">下载--%>
<%--                                            </button>--%>
                                            <a class="btn btn-xs btn-app-green" href="courseResource/download?path=${s.video}&filename=${s.videoFileName}">下载</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
                <!-- .card-block -->
            </div>
            <!-- .card -->
            <!-- End Hover Table -->
        </div>
    </div>
</div>
<%@include file="/common/footer.jsp" %>
<script>
    function deleteById(id) {
        if (confirm("您确定要删除吗?")) {
            location.href = "courseResource/delete/" + id;
        }
    }

    function download(url, name) {
        // console.log("download()")
        $.ajax({
            url: "courseResource/download?path=" + url + '&filename='+name,
            type: "get",
            success: function (data) {
                console.log(data)
            },
            error: function () {
                alert("出错了");
            }
        })
    }

    function playVedio(url) {
        parent.$("#modal-normal-video").modal('show');
        parent.$("video").attr("src", "<%=request.getContextPath()%>" + url);
    }

    $(function () {
        $("#add").click(function () {
            location.href = "courseResource/add";
        });
        $("#delete").click(function () {
            var ids = "";
            $("input[name=check]:checked").each(function () {
                ids += $(this).val() + ",";
            });
            if (ids == "") {
                alert("请选择数据！");
                return;
            } else {
                if (confirm("是否删除？")) {
                    $("#form").submit();
                }
            }
        });
    });
</script>
</body>
</html>
