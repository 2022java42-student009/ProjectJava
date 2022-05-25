<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usermanagement</title>
</head>
<body>
<jsp:include page="/adminheader.jsp"/>
	<form action="?" method="post">
		会員ID<input type ="text" name ="userid" value="${user.id }" required><br>
		名前<input type ="text" name ="username" value="${user.name }" required><br>
		パスワード<input type="text" name = "userpass" value="${user.password }" required><br>
		
		<input type = "submit" value ="確認" formaction="/ProjectJava/AccountManagementServlet?action=editcheck">
		<input type = "submit" value ="削除" formaction="/ProjectJava/AccountManagementServlet?action=deletecheck">
		
	</form>
	<button onclick="location.href='/ProjectJava/AccountManagementServlet'">キャンセル</button>
</body>
</html>