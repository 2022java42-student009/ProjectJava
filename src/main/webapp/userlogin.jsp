<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/ProjectJava/AccountServlet" method="post">
	<h2>ログイン</h2>
	メールアドレス
	<input type="email" name="email">
	<br> パスワード
	<input type="password" name="pass"><br><br><br>
	<button onclick="history.back()">戻る</button>
	<input type="submit" value="ログイン">
	<input type="hidden" name="action" value=memberlogin>
	<br>
</form>
</body>
</html>