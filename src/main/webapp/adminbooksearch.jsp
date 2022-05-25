<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminbookserch</title>
 <style type="text/css">
.err{
	color: red;
}
 
 </style>
</head>
<body>
<jsp:include page="/adminheader.jsp"/>
	<h2>#教科書管理</h2>


	<form action="/ProjectJava/BookManagementServlet?action=isbn" method="post">
		ISBN番号検索: <input type="number" name="id"> <input type="submit"
			value="検索">
	</form>




	<h2>検索結果</h2>
	<c:if test="${not empty book }">
		<div class="items" style="border: 1px solid; margin: 10px auto;">
			${book.isbm } ${book.title } ${book.author }
			<button onclick="location.href='/ProjectJava/BookManagementServlet?action=edit&id=${book.isbm}'">編集</button>
		</div>
	</c:if>
	<c:if test="${empty books && empty book }">
		<p class="err">該当する教科書が見つかりませんでした</p>
	</c:if>

	<c:forEach items="${books }" var="book">
		<div class="items" style="border: 1px solid; margin: 10px auto;">
			${book.isbm } ${book.title } ${book.author }

			<button onclick="location.href='/ProjectJava/BookManagementServlet?action=edit&id=${book.isbm}'">編集</button>
		</div>
	</c:forEach>

</body>
</html>