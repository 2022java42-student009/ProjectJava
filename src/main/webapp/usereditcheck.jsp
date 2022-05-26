<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usereditcheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	<div class="inner"
		style="width: 400px; text-align: left; margin: 0 auto;">
	<%--画面レイアウト設計書には以下の文の記載はないですが、追加したほうが良いかと思います。 --%>
	<h3>変更してよろしいですか？</h3>
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		名前<br>${editmember.name}<br><br> 
		住所<br>${editmember.address}<br><br>
		電話番号<br>${editmember.tel}<br><br>
		メールアドレス<br>${editmember.mail}<br><br>
		パスワード<br>${editmember.password}<br><br> 
		<div align="center" class="example-r">
		<input type="hidden" name="action" value="edit"> 
		<input type="submit" class="login_btn" value="変更する">
		</div>
	</form>
	<div align="right" class="example-r">
	<button onclick="location.href='useredit.jsp'"class="back_btn">キャンセル</button></div>
	</div>
</body>
</html>