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
form{
	background: rgb(250, 250, 250);
	border-radius: 15px;
	padding: 30px;
	box-shadow: 3px 3px 3px rgb(240, 240, 240);
	margin-bottom: 30px;
}
input,select{
	margin-bottom: 15px;
}
h2{
	text-align: center;
}

.back_btn{
	margin-left: auto;
}
.formbtn{
	display: flex;
	justify-content: space-between;
}


</style>
<title>bookmanagement</title>
</head>
<body>
<jsp:include page="/adminheader.jsp"/>
	<div class="inner">
	
	<h2>教科書更新画面</h2>
	<form action="?" method="post">
		ISBN<br> <input type="text" name="number" value="${book.isbm }" required> <br>
		分類<br>

		<select name="category">
		<c:forEach items="${categories}" var="category">
			<option value="${category.id },${category.name }">${category.name }</option>
			
		</c:forEach>
		</select> <br>
		タイトル<br> <input type="text" name="title" value="${book.title }" required><br>
		著者名<br> <input type="text" name="author" value="${book.author }" required><br>
		<div class="formbtn">
		<input type="submit" value="確認" formaction="/ProjectJava/BookManagementServlet?action=editcheck" class="login_btn">
		<input type="submit" value="削除" formaction="/ProjectJava/BookManagementServlet?action=deletecheck" class="delete_btn">
		</div>
	</form>
	
	<button onclick="location.href='/ProjectJava/BookManagementServlet'" class="back_btn">キャンセル</button>
	</div>
</body>
</html>