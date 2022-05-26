<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/buttonstyle.css">
<title>adminlogin</title>
</head>
<body>
<jsp:include page="/indexheader.jsp"/>

	<h2 style="text-align: center">管理者ログイン</h2>
	<br>
	<br>
	<br>
	<form action="/ProjectJava/AccountServlet" method="post">
		メールアドレス<br> <input type="email" name="email" required><br> <br> 
		パスワード<br> <input type="password" name="pass" required>
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<br> <br> <br> <input type="hidden" name="action"
			value="adminlogin"> <input type="submit" value="ログイン" class="login_btn"><br>
	</form>
	<button onclick="location.href='index.jsp'" class="back_btn">戻る</button>

</body>
</html>