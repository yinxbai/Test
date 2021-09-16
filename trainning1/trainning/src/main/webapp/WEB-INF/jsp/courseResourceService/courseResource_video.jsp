<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
</head>
<body>
<div class="form-group">
    <video height="50%" width="50%" controls>
        <source src="${pageContext.request.contextPath}${video}" type="video/mp4">
    </video>
    <div class="card-block">
        <nav>
            <ul class="pagination pagination-sm">
                <li>
                    <a href="javascript:playPause();">播放/停止</a>
                </li>
                <li>
                    <a href="javascript:history.go(-1)">退出</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
<%@include file="/common/footer.jsp"%>
<script type="text/javascript">
    function makeBig() {
        let video = $("video")[0];
        video.height(video.videoHeight*2);
    }
    function playPause() {
        let video = $("video")[0];
        if (video.paused){
            video.play();
        }else {
            video.pause();
        }
    }
    function makeNormal() {
        let video = $("video")[0];
        video.height(video.height);
    }
</script>
</html>
