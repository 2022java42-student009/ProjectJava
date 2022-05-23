<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usertop</title>
</head>
<body>
	<button onclick="location.href=''">教科書検索</button>
	<br>
	<button onclick="location.href=''">出品</button>
	<br>
	<form action="/ProjectJava/RegistServlet" method="post">
	<button onclick="location.href=''">出品履歴一覧</button>
	<input type="hidden" name="action" value=registlist>
	</form>
	<button onclick="location.href=''">購入履歴一覧</button>
	<br>
	<button onclick="location.href=''">アカウント情報編集</button>
	<br>

</body>
</html>