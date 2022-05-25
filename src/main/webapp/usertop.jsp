<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usertop</title>
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	<button onclick="location.href='/ProjectJava/StockSerchServlet'">教科書検索</button>
	<br>
	<button onclick="location.href='exhibit.jsp'">出品</button>
	<br>
	<form action="/ProjectJava/RegistServlet" method="post">
	<button>出品履歴一覧</button>
	<input type="hidden" name="action" value=registlist>
	</form>
	<button onclick="location.href='/ProjectJava/BuyServlet?action=buylist'">購入履歴一覧</button>
	<br>
	<button onclick="location.href='useredit.jsp'">アカウント情報編集</button>
	<br>
	<br>
	<button onclick="location.href='/ProjectJava/AccountServlet?action=logout'">ログアウト</button>

</body>
</html>