<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useredit</title>
</head>
<body>
<form>
	<h1 style="text-align: center">会員情報変更画面</h1>
	名前
	<input type="text" name="username">
	<br> 住所
	<input type="text" name="address">
	<br> 電話番号
	<input type="tel" name="tel">
	<br> メールアドレス
	<input type="email" name="mail">
	<br> パスワード
	<input type="password" name="pass">
	<br>
	<button onclick="location.href=''">退会</button>
	<input type="submit" value="確認">
	<button onclick="location.href=''">キャンセル</button>
</form>
</body>
</html>