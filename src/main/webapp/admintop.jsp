<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.inner {
	width: 600px;
	margin: 0 auto;
	margin-top: 80px;
	text-align: center;
}

</style>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/buttonstyle.css">
<title>admintop</title>
</head>
<body>
	<jsp:include page="/adminheader.jsp" />
	<div class="inner">
		<button onclick="location.href='/ProjectJava/BookManagementServlet'"
			class="top_btn">教科書管理</button>
		<button
			onclick="location.href='/ProjectJava/AccountManagementServlet'"
			class="top_btn">会員管理</button>
	</div>
</body>
</html>