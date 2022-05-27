<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/buttonstyle.css">
</head>
<body>
<jsp:include page="/indexheader.jsp"/>
	<form action="/ProjectJava/AccountServlet" method="post">
		<h2 style="text-align: center">ログイン</h2><br>
	<br>
	<br>
		メールアドレス<br><input type="email" name="email" required> <br><br>パスワード<br> <input
			type="password" name="pass" required>
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<br> <br> <br> <input type="submit" value="ログイン"class="login_btn">
		<input type="hidden" name="action" value=memberlogin> <br>


	</form>
	<button onclick="location.href='index.jsp'" class="back_btn">戻る</button>
</body>
</html>