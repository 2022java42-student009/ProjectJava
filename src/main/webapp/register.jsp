<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<link href="css/buttonstyle.css" rel="stylesheet">
<style>
.back_btn{
margin-bottom:50px;
}
</style>
</head>
<body>
	<jsp:include page="/indexheader.jsp" />
	<div class="inner"
		style="width: 600px; text-align: left; margin: 0 auto;">
		<form action="/ProjectJava/AccountServlet" method="post">
			<h2 style="text-align: center">新規会員登録</h2>
			<div>
				<p class="text">
					名前<br>
					<input type="text" name="username" placeholder="(例)教科書　太郎" required><br>
					<br>住所<br>
					<input type="text" name="address" required><br>
					<br>電話番号<font color="coral">（ハイフンなし半角数字)</font><br>
					<input type="tel" name="tel" pattern="[\d\-]*" maxlength="11" placeholder="09011112222" required><br>
					<br>メールアドレス<br>
					<font color="coral">(半角英数字, 他の会員が登録済みのメールアドレスは登録できません)</font><br>
					<input type="email" name="mail" required><br>
					<br> 生年月日<br>
					<input type="date" name="birthday" max="9999-12-31" required><br>
					<br>パスワード<br>
					<font color="coral">(半角英数字6文字以上,記号は使えません)</font><br>
					<input type="password" name="password" required minlength="6"
						maxlength="15" pattern="^[0-9a-zA-Z]+$"><br>
					<br>
					<input type="hidden" name="action" value="registercheck">
				<div align="center" class="example-r">
					<input type="submit" value="確認" class="login_btn">
				</div>
			</div>
		</form>
		<div align="right" class="example-r">
			<button onclick="location.href='index.jsp'" class="back_btn">戻る</button>
		</div>
	</div>
</body>
</html>