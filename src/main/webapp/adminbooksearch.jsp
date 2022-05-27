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
	width: 700px;
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

.err {
	color: red;
}
</style>

<title>adminbookserch</title>
</head>
<body>
	<jsp:include page="/adminheader.jsp" />
	<div class="inner">
		<h2>教科書管理</h2>


		<form action="/ProjectJava/BookManagementServlet?action=isbn"
			method="post">
			ISBN番号検索: <input type="number" name="id"> <input
				type="submit" value="検索" class="back_btn" style="display: inline">
		</form>




		<h2>検索結果</h2>
		<div class="result">

			<table border="1">
				<tr>
					<th style="width: 100px">ISBM番号</th>
					<th style="width: 270px">タイトル名</th>
					<th style="width: 230px">著者</th>
					<th style="width: 50px"></th>
				</tr>


				<c:if test="${not empty book }">
					<tr>
						<td>${book.isbm }</td>
						<td>${book.title }</td>
						<td>${book.author }</td>
						<td><button
								onclick="location.href='/ProjectJava/BookManagementServlet?action=edit&id=${book.isbm}'"
								class="back_btn">編集</button></td>
					</tr>


				</c:if>
				<c:if test="${empty books && empty book }">
					<p class="err">該当する教科書が見つかりませんでした</p>
				</c:if>

				<c:forEach items="${books }" var="book">

					<tr>
						<td>${book.isbm }</td>
						<td>${book.title }</td>
						<td>${book.author }</td>
						<td><button
								onclick="location.href='/ProjectJava/BookManagementServlet?action=edit&id=${book.isbm}'"
								class="back_btn">編集</button></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>