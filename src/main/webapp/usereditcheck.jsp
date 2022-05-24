<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usereditcheck</title>
</head>
<body>
	<%--画面レイアウト設計書には以下の文の記載はないですが、追加したほうが良いかと思います。 --%>
	変更してよろしいですか？
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		名前:${member.name}<br> 
		住所:${member.address}<br>
		電話番号:${member.tel}<br> 
		メールアドレス:${member.mail}<br>
		パスワード:${member.password}<br> 
		<input type="hidden" name="action" value="register"> 
		<input type="submit" value="変更する">
	</form>
	<button onclick="location.href=''">キャンセル</button>
</body>
</html>