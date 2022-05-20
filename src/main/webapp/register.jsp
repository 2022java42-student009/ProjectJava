<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<form action="/ProjectJava/AccountServlet" method="post">
		<h3>会員登録画面</h3>
		名前<input type="text" name="username"><br> 
		住所<input type="text" name="address"><br>
		電話番号<input type="tel" name="tel"><br> 
		メールアドレス<input type="email" name="mail"><br> 
		生年月日<input type="text" name="birthday"><br> 
		パスワード<input type="password" name="password"><br>
		<input type="hidden" name="action" value="registercheck">
		<input type="submit" value="確認">
	</form>
		<button onclick="location.href='index.jsp'">戻る</button>
</body>
</html>