<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitcheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<div class="inner"
		style="width: 400px; text-align: left; margin: 0 auto;">
	
		<h3 style="text-align: center">以下の情報で登録します。よろしいですか？</h3>
		<br>
		<form action="/ProjectJava/RegistServlet" method="post">
			ISBM番号<br>${listingdata.book.isbm}<br><br>値段<br>${listingdata.price}<br><br>
			状態<br>${listingdata.state}<br><br>備考<br>${listingdata.remarks}<br><br><div align="center" class="example-r"><input
				type="hidden" name="action" value="listing"> <input
				type="submit" class="login_btn" value="出品する"> <br></div>
		</form>
	<div align="right" class="example-r">
		<button onclick="location.href='exhibit.jsp'" class="back_btn">修正</button>
	</div>
	</div>

</body>
</html>