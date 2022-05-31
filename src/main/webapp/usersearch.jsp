<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/buttonstyle.css">
<style type="text/css">
.inner {
	width: 400px;
	margin: 0 auto;
	margin-top: 30px;
}

h2 {
	text-align: center;
}

table {
	border-collapse: collapse;
	border: 1px solid #ccc;
	text-align: center;
	line-height: 1.5;
}

table th {
	padding: 8px;
	font-weight: bold;
	vertical-align: top;
	background: #60b4df;
	color: #ffffff;
}

table td {
	padding: 8px;
	vertical-align: top;
}

table tr:nth-child(even) {
	background: #eceff1;
}

.back_btn {
	padding: 2px 10px;
}

.back {
	margin: 30px 0;
}

.back .back_btn {
	margin-left: auto;
}

.err {
	color: red;
}
</style>
<title>usersearch</title>
</head>
<body>
	<jsp:include page="/adminheader.jsp" />
	<div class="inner">
		<h2>会員管理</h2>
		<form action="/ProjectJava/AccountManagementServlet?action=usersearch"
			method="post">
			<br> 会員IDで検索する: <input type="number" name="id" required>
			<input type="submit" value="検索">
		</form>

		<h2>検索結果</h2>
		<table border="1">
			<tr>
				<th style="width: 100px">会員ID</th>
				<th style="width: 280px">会員名</th>
				<th style="width: 60px"></th>
			</tr>
			<c:forEach items="${users }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td><button
							onclick="location.href='/ProjectJava/AccountManagementServlet?action=edit&id=${user.id}'" class="back_btn">編集</button></td>
				</tr>


			</c:forEach>
		</table>
	</div>
</body>
</html>