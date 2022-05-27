<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookdeletecheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/adminheader.jsp"/>
	<div class="inner"
		style="width: 600px; text-align: left; margin: 0 auto;">
<h1 style="text-align: center; margin-top: 50px;">本当に削除してよろしいですか？</h1><br>
	<br>
	<div align="center" class="example-r">
	<form action="/ProjectJava/BookManagementServlet?action=deletecheckend" method="post">
		<input type="submit" value="削除"class="delete_btn">
	</form></div>
	<div align="right" class="example-r"><button onclick="location.href='bookmanagement.jsp'"class="back_btn">キャンセル</button>
	</div></div>
</body>
</html>