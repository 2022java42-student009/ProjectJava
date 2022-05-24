<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admintop</title>
</head>
<body>
	<jsp:include page="/adminheader.jsp"/>
	<button onclick="location.href='/ProjectJava/BookManagementServlet'">教科書管理</button>
	<button onclick="location.href='/ProjectJava/AccountManagementServlet'">会員管理</button>

</body>
</html>