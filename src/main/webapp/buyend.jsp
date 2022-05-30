<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<div align="center" class="example-r">
		<h3>購入が完了しました</h3>
	</div>
	<div align="center" class="example-r">
		<button class="top_btn"
			onclick="location.href='/ProjectJava/StockSerchServlet'">購入を続ける</button>
			<br>
		<button onclick="location.href='usertop.jsp'" class=top_btn>トップに戻る</button>
	</div>
</body>
</html>