<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmanagement</title>
</head>
<body>
<jsp:include page="/adminheader.jsp"/>
	<h1>教科書更新画面</h1>
	<form action="?" method="post">
		ISBN <input type="text" name="number" value="${book.isbm }"> <br>
		分類

		<select name="category">
		<c:forEach items="${categories}" var="category">
			<option value="${category.id },${category.name }">${category.name }</option>
			
		</c:forEach>
		</select> <br>タイトル <input type="text" name="title" value="${book.title }">
		<br> 著者名 <input type="text" name="author" value="${book.author }">
		<br> <input type="submit" value="確認" formaction="/ProjectJava/BookManagementServlet?action=editcheck">
		<br> <input type="submit" value="削除" formaction="/ProjectJava/BookManagementServlet?action=deletecheck">
		
	</form>
	
	<button onclick="location.href='adminbooksearch.jsp'">キャンセル</button>
</body>
</html>