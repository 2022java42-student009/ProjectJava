<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usermanagementcheck</title>
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

.intxt {
	margin-bottom: 15px;
	width: 250px;
	height: 25px;
}

h2 {
	text-align: center;
}

.back_btn {
	margin-left: auto;
}

.login_btn {
	margin: 20px auto 0;
}
</style>
</head>
<body>
	<jsp:include page="/adminheader.jsp" />
	<div class="inner">
		<h3>以下の内容で変更します。よろしいですか？</h3>
		<br>

		<form
			action="/ProjectJava/AccountManagementServlet?action=editcheckend"
			method="post">
			会員ID<br>${editmember.id }<br>
			<br> 名前<br>${editmember.name }<br>
			<br> パスワード<br>${editmember.password }
			<br> <input type="submit" value="確定" class="login_btn">

		</form>


		<button onclick="location.href='usermanagement.jsp'" class="back_btn">修正</button>

	<div>
</body>
</html>