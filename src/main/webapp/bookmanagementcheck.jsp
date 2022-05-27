<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


h2 {
	text-align: center;
}
.login_btn{
	margin: 35px auto 0;
}

.back_btn {
	margin-left: auto;
}
</style>
<title>bookmanagementcheck</title>
</head>
<body>
	<jsp:include page="/adminheader.jsp" />
	<div class="title">
	<h2>以下の内容で変更してよいか確認してください。</h2>
	</div>
	<div class="inner">
		<form action="/ProjectJava/BookManagementServlet?action=editcheckend"
			method="post">
			ISBN： ${editbook.isbm }<br> 分類： ${editbook.categoryname }<br>
			タイトル： ${editbook.title }<br> 著者名： ${editbook.author} <br><input
				type="submit" value="確定" class="login_btn">
		</form>
		<button onclick="location.href='bookmanagement.jsp'" class="back_btn">修正</button>
	</div>
</body>
</html>