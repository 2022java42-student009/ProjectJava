<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registercheck</title>
<style>
.back_btn{
	margin-bottom:50px;
}
</style>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/indexheader.jsp" />
	<div class="inner"
		style="width: 600px; text-align: left; margin: 0 auto;">
		<h3>以下の内容で登録します。よろしいですか？</h3>
		<br>
		<div>
			<p class="text">
			<form action="/ProjectJava/AccountServlet" method="post">
				名前<br>${member.name}<br><br>住所<br>${member.address}<br><br>
				電話番号<br>${member.tel}<br><br>メールアドレス<br>${member.mail}<br><br>
				生年月日<br>${member.birthday}<br><br>パスワード<br>${member.password}<br> <input
					type="hidden" name="action" value="register">
				<div align="center" class="example-r">
					<input type="submit"  class="login_btn" value="登録する">
				</div>
			</form>
		</div>

		<div align="right" class="example-r">
			<button onclick="location.href='register.jsp'" class="back_btn">修正</button>
		</div>
	</div>
</body>
</html>