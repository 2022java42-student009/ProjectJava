<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
form{
	background: rgb(250, 250, 250);
	border-radius: 15px;
	padding: 30px;
	box-shadow: 3px 3px 3px rgb(240, 240, 240);
	margin-bottom: 30px;
}
</style>
<title>buycheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/><div class="inner"
		style="width: 400px; text-align: left; margin: 0 auto;">
<h3>この教科書を購入します。よろしいですか？</h3><br>
<form action="/ProjectJava/BuyServlet?action=buyend" method="post">
	ISBN<br>${stock.book.isbm }<br><br>
	カテゴリー<br>${stock.book.categoryname }<br><br>
	タイトル<br>${stock.book.title }<br><br>
	著者名<br>${stock.book.author }<br><br>
	金額<br>${stock.price }<br><br>
	備考<br>${stock.remarks }<br><br>
 	<div align="center" class="example-r">
	<input type = "submit" value ="購入する" class="login_btn">
	</div>

</form>
<div align="right" class="example-r">
<button onclick="location.href='/ProjectJava/StockSerchServlet'"class="back_btn">いいえ</button>
</div>
</div>

</body>
</html>