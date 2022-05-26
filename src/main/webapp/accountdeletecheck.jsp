<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accountdeletecheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	<div class="inner"
		style="width: 400px; text-align: left; margin: 0 auto;">
		<div align="center" class="example-r">
	退会しますがよろしいですか？
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		<input type="hidden" name="action" value="end"> 
		<input	type="submit" class=delete_btn value="退会">
	</form>
	</div>
	<div align="right" class="example-r">
	<button onclick="location.href='useredit.jsp'" class=back_btn>キャンセル</button></div>
	</div>
</body>
</html>