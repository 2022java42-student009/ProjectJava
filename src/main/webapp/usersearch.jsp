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
<jsp:include page="/adminheader.jsp"/>
	<h2>#ユーザ管理</h2>
	<form action="/ProjectJava/AccountManagementServlet?action=usersearch" method="post">
	<br>
		会員IDで検索する:
		<br>
		<input type="number"  name="id" required>
		<input type="submit" value="検索">
	</form>
	
	<h2>検索結果</h2>
	<c:forEach items="${users }" var="user">
	<div class="items" style="border: 1px solid; margin: 10px auto; width">
		${user.id }
		${user.name }
		
		<button onclick="location.href='/ProjectJava/AccountManagementServlet?action=edit&id=${user.id}'">編集</button>
	</div>
	</c:forEach>
	
</body>
</html>