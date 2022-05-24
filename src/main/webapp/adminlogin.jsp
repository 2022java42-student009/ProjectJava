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
<jsp:include page="/indexheader.jsp"/>

	<h2 style="text-align: center">管理者ログイン</h2>
	<br>
	<br>
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		メールアドレス<input type="email" name="email"><br> 
		パスワード<input type="password" name="pass">
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<br> <br> <br> <input type="hidden" name="action"
			value="adminlogin"> <input type="submit" value="ログイン"><br>
	</form>
	<button onclick="location.href='index.jsp'">戻る</button>

</body>
</html>