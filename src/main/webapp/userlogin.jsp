<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userlogin</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/buttonstyle.css">
<style type="text/css">
.inner {
	width: 400px;
	margin: 0 auto;
	margin-top: 30px;
	
}
form{
	background: rgb(250, 250, 250);
	border-radius: 15px;
	padding: 30px;
	box-shadow: 3px 3px 3px rgb(240, 240, 240);
	margin-bottom: 30px;
}

.intxt{
	margin-bottom: 15px;
	width: 300px;
	height: 23px;
	
}
h2{
	text-align: center;
}

.back_btn{
	margin-left: auto;
}

.login_btn{
	margin: 0 auto;
}


</style>
</head>
<body>
	<jsp:include page="/indexheader.jsp" />
	<h2>ログイン</h2>
	<div class="inner">
		<form action="/ProjectJava/AccountServlet" method="post">
			メールアドレス<br> <input type="email" name="email" class="intxt"
				placeholder="(例)hogehoge@example.com" required><br> <br>
			パスワード<br> <input type="password" name="pass" class="intxt"
				required>
			<c:if test="${not empty errmsg }">
				<p style="color: red;">${errmsg }</p>
			</c:if>
			<br> <br> <br>
			<input type="hidden" name="action" value=memberlogin> <input
				type="submit" value="ログイン" class="login_btn"> <br>
		</form>
		<button onclick="location.href='index.jsp'" class="back_btn">戻る</button>
	</div>
</body>
</html>