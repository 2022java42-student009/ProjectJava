<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ProjectJava/AccountServlet" method="post">
		<h2>ログイン</h2>
		メールアドレス <input type="email" name="email"> <br> パスワード <input
			type="password" name="pass">
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<br>
		<br>
		<br>
		<input type="submit" value="ログイン"> 
		<input type="hidden" name="action" value="memberlogin">
	</form>
	<button onclick="location.href='index.jsp'">戻る</button>
</body>
</html>