<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usermanagement</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/adminheader.jsp" />
	<div class="inner"
		style="width: 600px; text-align: left; margin: 0 auto;">
		<h2 style="text-align: center">会員情報管理</h2>
		<form action="?" method="post">
			会員ID<br><input type="text" name="userid" value="${user.id }" required><br>
			名前<br><input type="text" name="username" value="${user.name }" required><br>
			パスワード<br><input type="text" name="userpass" value="${user.password }"
				required><br>
				 <div align="center" class="example-r"><input type="submit" value="変更"class="login_btn"formaction="/ProjectJava/AccountManagementServlet?action=editcheck"></div>
			<div align="right" class="example-r"><input type="submit" value="削除" class="delete_btn"formaction="/ProjectJava/AccountManagementServlet?action=deletecheck">
			</div>
		</form>
		<div align="right" class="example-r">
			<br><br><button
				onclick="location.href='/ProjectJava/AccountManagementServlet'"
				class="back_btn">キャンセル</button>
		</div>
	</div>
</body>
</html>