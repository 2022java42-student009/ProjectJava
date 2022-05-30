<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/buttonstyle.css">
<style type="text/css">
.inner {
	width: 1000px;
	margin: 0 auto;
	margin-top: 50px;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
	
}
.top_btn {
	margin-top: 50px;
}


#red {
	background-color: rgb(255,200,200);
}

</style>

</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<div class="inner">
		<button class="top_btn"
			onclick="location.href='/ProjectJava/StockSerchServlet'">教科書検索</button>

		<button class="top_btn rbtn" 
			onclick="location.href='/ProjectJava/BuyServlet?action=buylist'">購入履歴一覧</button>
		<br>
		<button class="top_btn rbtn" onclick="location.href='exhibit.jsp'">出品</button>
		<button class="top_btn"
			onclick="location.href='/ProjectJava/RegistServlet?action=registlist'">出品履歴一覧</button>
		<br>
		<button class="top_btn" onclick="location.href='useredit.jsp'">アカウント情報編集</button>

		<button class="top_btn rbtn" id="red" 
			onclick="location.href='/ProjectJava/AccountServlet?action=logout'">ログアウト</button>
	</div>
</body>
</html>