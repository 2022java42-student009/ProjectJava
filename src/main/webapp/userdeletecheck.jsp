<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	本当に削除してよろしいですか？
	<br>
	<form action="/ProjectJava/AccountManagementServlet?action=deletecheckend" method="post">
		<input type="submit" value="削除">
	</form>
	<button onclick="location.href=''">キャンセル</button>
</body>
</html>