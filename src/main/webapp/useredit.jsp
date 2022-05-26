<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useredit</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<div class="inner"
		style="width: 600px; text-align: left; margin: 0 auto;">
		<h2 style="text-align: center">会員情報変更画面</h2>
		<form action="/ProjectJava/AccountServlet" method="post">
			名前<br><input type="text" name="name" value="${member.name }" required><br>
			住所<br><input type="text" name="address" value="${member.address}"
				required><br> 電話番号<br><input type="tel" name="tel" pattern="[\d\-]*" maxlength="11"
				value="${member.tel}" required><br> メールアドレス<br><input
				type="email" name="mail" value="${member.mail}" required><br>
			パスワード<br><input type="password" name="password"
				value="${member.password}" required><br><br>
			<div align="center" class="example-r">
				<input type="hidden" name="action" value="useredit"> <input
					type="submit" class=login_btn value="確認">
			</div>

		</form>
		<div align="right" class="example-r">
			<button onclick="location.href='usertop.jsp'" class=back_btn>キャンセル</button>
		</div>
		</div>
		<br>
		<br>
		<button onclick="location.href='accountdeletecheck.jsp'" class=delete_btn>退会</button>
	
</body>
</html>