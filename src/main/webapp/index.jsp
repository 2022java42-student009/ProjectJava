<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>

<jsp:include page="/indexheader.jsp"/>

<h2 style="text-align:center">教科書販売システム</h2>
<div style="text-align:center">
<button onclick="location.href='adminlogin.jsp'">管理者ログイン</button><br>
<button onclick="location.href='userlogin.jsp'">会員ログイン</button><br>
<button onclick="location.href='register.jsp'">新規会員登録</button>
</div>


</body>
</html>