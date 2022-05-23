<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminbookserch</title>
</head>
<body>
	<h2>#教科書管理</h2>
	
	
	<form action="/ProjectJava/BookSerchServlet?action=isbn" method="post">
		ISBN番号検索:
		<input type="text"  name="id" >
		<input type="submit" value="検索">
	</form>
	
	
	
	
	<h2>検索結果</h2>
	<c:forEach items="${books }" var="book">
	<div class="items" style="border: 1px solid; margin: 10px auto; width">
		${book.isbm }
		${book.title }
		${book.author }
		
		<button onclick="location.href='bookmanagementcheck.jsp'">編集</button>
	</div>
	</c:forEach>
	
</body>
</html>