<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitcheck</title>
</head>
<body>
		以下の情報で登録します。よろしいですか？ <br>
	<form action="/ProjectJava/RegistServlet" method="post">
		ISBM番号:${listingdata.book.isbm}<br>
		値段:${listingdata.price}<br>
		状態:${listingdata.state}<br>
		備考:${listingdata.remarks}<br>
		<input type="hidden" name="action" value="listing">
		<input type="submit" value="出品する"> <br>
	</form>
	<button onclick="location.href='exhibit.jsp'">修正</button>

</body>
</html>