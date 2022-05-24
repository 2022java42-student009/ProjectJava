<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accountdeletecheck</title>
</head>
<body>
	退会しますがよろしいですか？
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		<input type="hidden" name="action" value="end"> 
		<input	type="submit" value="退会機能">
		<button onclick="location.href='useredit.jsp'">キャンセル</button>
	</form>
</body>
</html>