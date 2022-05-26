<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usertop</title>
<link href="css/button.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	<button class="change" id="search" onclick="location.href='/ProjectJava/StockSerchServlet'">教科書検索</button>
	
	<button class="change" id="exhibit" onclick="location.href='exhibit.jsp'">出品</button>
	
	<button class="change" id="regist" onclick="location.href='/ProjectJava/RegistServlet?action=registlist'">出品履歴一覧</button>
	<br>
	<button class="change" id="buy" onclick="location.href='/ProjectJava/BuyServlet?action=buylist'">購入履歴一覧</button>
	
	<button class="change" id="edit" onclick="location.href='useredit.jsp'">アカウント情報編集</button>
	
	<button class="change" id="logout" onclick="location.href='/ProjectJava/AccountServlet?action=logout'">ログアウト</button>

</body>
</html>