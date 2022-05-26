<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accountdeletecheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	退会しますがよろしいですか？
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		<input type="hidden" name="action" value="end"> 
		<input	type="submit" value="退会">
	</form>
	<button onclick="location.href='useredit.jsp'">キャンセル</button>
</body>
</html>