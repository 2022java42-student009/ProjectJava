<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usermanagement</title>
</head>
<body>
	<form action="?" method="post">
		会員ID<input type ="text" name ="userid" value="${user.id }"><br>
		名前<input type ="text" name ="username" value="${user.name }"><br>
		パスワード<input type="text" name = "userpass" value="${user.password }"><br>
		<button onclick="location.href=''">削除</button>
		<input type = "submit" value ="確認" formaction="/ProjectJava/AccountManagementServlet?action=editcheck">
		<input type = "submit" value ="削除" formaction="/ProjectJava/AccountManagementServlet?action=deletecheck">
		
	</form>
	<button onclick="location.href=''">キャンセル</button>
</body>
</html>