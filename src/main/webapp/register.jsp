<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<form action="">
		<h1>会員登録画面</h1>
		名前
		<input type="text" name="username">
		<br> 住所
		<input type="text" name="address">
		<br> 電話番号
		<input type="tel" name="tel">
		<br> メールアドレス
		<input type="email" name="mail">
		<br> 生年月日
		<input type="text" name="birthday">
		<br> パスワード
		<input type="text" name="password">
		<br>
		<button onclick="location.href=''">戻る</button>
		<input type="submit" value="確認">
	</form>
</body>
</html>