<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buycheck</title>
</head>
<body>
<jsp:include page="/userheader.jsp"/>
この教科書を購入します。よろしいですか？<br>
<form action="/ProjectJava/BuyServlet?action=buyend" method="post">
	ISBN ${stock.book.isbm }<br>
	カテゴリー ${stock.book.categoryname }<br>
	タイトル ${stock.book.title }<br>
	著者名 ${stock.book.author }<br>
	金額 ${stock.price }<br>
	備考 ${stock.remarks }<br>

	<input type = "submit" value ="購入する">
	
</form>
<button onclick="location.href='booksearch.jsp'">いいえ</button>
</body>
</html>