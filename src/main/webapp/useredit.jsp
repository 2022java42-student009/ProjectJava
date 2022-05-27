<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useredit</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/buttonstyle.css">
<style type="text/css">
.inner {
	width: 400px;
	margin: 0 auto;
	margin-top: 30px;
}

form {
	background: rgb(250, 250, 250);
	border-radius: 15px;
	padding: 30px;
	box-shadow: 3px 3px 3px rgb(240, 240, 240);
	margin-bottom: 30px;
}

h2 {
	text-align: center;
}

.back_btn {
	margin-left: auto;
}

.formbtn {
	margin-top: 30px;
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<h2>会員情報変更画面</h2>
	<div class="inner">

		<form action="?" method="post">
			名前<br>
			<input type="text" name="name" value="${member.name }" required><br>
			住所<br>
			<input type="text" name="address" value="${member.address}" required><br>
			電話番号<br>
			<input type="tel" name="tel" pattern="[\d\-]*" maxlength="11"
				value="${member.tel}" required><br> メールアドレス<br>
			<input type="email" name="mail" value="${member.mail}" required><br>
			パスワード<br>
			<input type="password" name="password" value="${member.password}"
				required><br>
			<br> <input type="hidden" name="action" value="useredit">
			<div class="formbtn">
				<input type="submit" class="login_btn" value="確認"
					formaction="/ProjectJava/AccountServlet"> <input
					type="submit" class=back_btn value="キャンセル"
					formaction="usertop.jsp">
			</div>

		</form>
		<div align="right" class="example-r">
			<button onclick="location.href='accountdeletecheck.jsp'" class=delete_btn>退会</button>
		</div>
	</div>
	<br>
	<br>


</body>
</html>