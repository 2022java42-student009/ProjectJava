<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usermanagementcheck</title>
</head>
<body>
	以下の内容で変更してよいか確認してください。
	<br>

	<form action="/ProjectJava/AccountManagementServlet?action=editcheckend" method="post">
		会員ID ${editmember.id }<br>
		名前 ${editmember.name }<br>
		パスワード ${editmember.password }<br>
		
		
		<input type="submit" value="確定">
	</form>
	<button onclick="location.href='usermanagement.jsp'">修正</button>
</body>
</html>