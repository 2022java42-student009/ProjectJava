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
		名前:${editmember.name}<br> 
		住所:${editmember.address}<br>
		電話番号:${editmember.tel}<br> 
		メールアドレス:${editmember.mail}<br>
		パスワード:${editmember.password}<br> 
		<input type="hidden" name="action" value="end"> 
		<input type="submit" value="変更する">
	</form>
	<button onclick="location.href=''">キャンセル</button>
</body>
</html>