<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookdeletecheck</title>
</head>
<body>
<jsp:include page="/adminheader.jsp"/>
	本当に削除してよろしいですか？
	<br>
	<form action="/ProjectJava/BookManagementServlet?action=deletecheckend" method="post">
		<input type="submit" value="削除">
	</form>
	<button onclick="location.href='bookmanagement.jsp'">キャンセル</button>
</body>
</html>