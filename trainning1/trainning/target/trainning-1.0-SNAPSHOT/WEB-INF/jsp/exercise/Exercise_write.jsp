<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="application/msword;charset=gbk" %>
<%@page contentType="application/vnd.ms-excel;charset=gbk" %>
<!DOCTYPE html>
<html lang="as">
<head>
  <%@include file="/common/header.jsp"%>
</head>
<body>
<div class="form-group">
  <wbr>
      <resource src="${pageContext.request.contextPath}${exercise}" type="wbr/word" />
  </wbr>
  <div class="card-block">
    <nav>
      <ul class="pagination pagination-sm">
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

</script>
</html>
