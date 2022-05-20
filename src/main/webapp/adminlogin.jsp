<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminlogin</title>
</head>
<body>

<<<<<<< HEAD
<h2 style="text-align:center">管理者ログイン</h2><br><br><br>
<form action="" method="post">
メールアドレス<input type="email" name="email"><br>
パスワード<input type="password" name="pass"><br><br><br>
	<button name="action" value="return" onclick="location.href=''">戻る</button>
	<button name="action" value="login" onclick="location.href=''">ログイン</button>
</form>
=======
	<h2 style="text-align: center">管理者ログイン</h2>
	<br>
	<br>
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		メールアドレス<input type="email" name="email"><br> パスワード<input
			type="password" name="pass">
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<br>
		<br>
		<br> <input type="hidden" name="action" value="adminlogin">
		<input type="submit" value="ログイン"><br>
	</form>
	<button onclick="location.href='index.jsp'">戻る</button>
>>>>>>> 81cbe8d1c62817f1b61273286f20da5eca236114
</body>
</html>