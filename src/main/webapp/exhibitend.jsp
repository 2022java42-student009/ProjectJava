<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitend</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<h3 style="text-align: center">出品が完了しました</h3>
	<br>
	<div align="center" class="example-r">
		<button onclick="location.href='usertop.jsp'" class=top_btn>トップに戻る</button>
	</div>
	<div align="center" class="example-r">
		<button class="top_btn"
			onclick="location.href='/ProjectJava/RegistServlet?action=registlist'">出品履歴一覧</button>
	</div>
</body>
</html>