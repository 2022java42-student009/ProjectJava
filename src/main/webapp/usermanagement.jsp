<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usermanagement</title>
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

.formbtn {
	margin-top: 30px;
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>
	<jsp:include page="/adminheader.jsp" />
	<div class="inner">
		<h2 style="text-align: center">会員情報管理</h2>
		<form action="?" method="post">
			会員ID<br> <input type="text" name="userid" value="${user.id }"
				class="intxt" required><br> 名前<br> <input
				type="text" name="username" value="${user.name }" class="intxt"
				required><br> パスワード<br> <input type="text"
				name="userpass" value="${user.password }" class="intxt" required><br>

			<div class="formbtn">
				<input type="submit" value="変更" class="login_btn"
					formaction="/ProjectJava/AccountManagementServlet?action=editcheck">
				<input type="submit" value="削除" class="delete_btn"
					formaction="/ProjectJava/AccountManagementServlet?action=deletecheck">
			</div>
		</form>


		<button
			onclick="location.href='/ProjectJava/AccountManagementServlet'"
			class="back_btn">キャンセル</button>

	</div>
</body>
</html>