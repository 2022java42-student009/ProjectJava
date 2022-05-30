<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerend</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/indexheader.jsp"/>

	<h3 style="text-align: center">会員登録が完了しました</h3>
	<br>
	<div align="center" class="example-r"><button onclick="location.href='userlogin.jsp'" class="login_btn">ログイン</button></div><br>
	<div align="center" class="example-r"><button onclick="location.href='index.jsp'" class="top_btn">TOPに戻る</button></div>
	
</body>
</html>