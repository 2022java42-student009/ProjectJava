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
<jsp:include page="/indexheader.jsp"/>
	<form action="/ProjectJava/AccountServlet" method="post">
		<h3>ログイン</h3>
		メールアドレス <input type="email" name="email" required> <br> パスワード <input
			type="password" name="pass" required>
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<br> <br> <br> <input type="submit" value="ログイン">
		<input type="hidden" name="action" value=memberlogin> <br>


	</form>
	<button onclick="location.href='index.jsp'">戻る</button>
</body>
</html>