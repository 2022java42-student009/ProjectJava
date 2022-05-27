<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/buttonstyle.css">
<title>index</title>
</head>
<body>

<jsp:include page="/indexheader.jsp"/>

<h2 style="text-align:center">教科書販売システム</h2>
<div style="text-align:center">
<button onclick="location.href='adminlogin.jsp'" class="top_btn">管理者ログイン</button><br>
<button onclick="location.href='userlogin.jsp'" class="top_btn">会員ログイン</button><br>
<button onclick="location.href='register.jsp'" class="top_btn">新規会員登録</button>
</div>


</body>
</html>