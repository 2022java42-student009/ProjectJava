<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
<jsp:include page="/indexheader.jsp"/>
	<div class="inner"  style="width: 600px; text-align: left; margin: 0 auto;">
	<form action="/ProjectJava/AccountServlet" method="post">
		<h2  style="text-align: center">会員登録画面</h2>
		<div><p class="text">
		名前<br><input type="text" name="username" required><br><br>住所<br><input
			type="text" name="address" required><br><br>電話番号<font color="coral">（ハイフンなし)</font><br><input type="tel"
			name="tel" required><br><br>メールアドレス<br><font color="coral">(半角英数字,
他の会員が登録済みのメールアドレスは登録できません)</font><br><input type="email" name="mail" required><br><br>
		生年月日<br><input type="date" name="birthday" max="9999-12-31" required><br><br>パスワード<br><font color="coral">(半角英数字6文字以上,記号は使えません)</font><br><input
			type="password" name="password" required minlength="6" maxlength="15"pattern="^[0-9a-zA-Z]+$"><br><br><input
			type="hidden" name="action" value="registercheck"><div align="center" class="example-r"><input
			type="submit" value="確認"></div></div>
	</form>
	<div align="right" class="example-r"><button onclick="location.href='index.jsp'">戻る</button></div>
	</div>
</body>
</html>