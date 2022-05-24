<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmanagementcheck</title>
</head>
<body>
	以下の内容で変更してよいか確認してください。
	<br>

	<form action="/ProjectJava/BookManagementServlet?action=editcheckend" method="post">
		ISBN ${book.isbm }<br>
		分類 ${book.categoryname }<br>
		タイトル ${book.title }<br>
		著者名 ${book.author}
		
		<input type="submit" value="確定">
	</form>
	<button onclick="location.href='bookmanagement.jsp'">修正</button>
	
</body>
</html>