<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitdeletecheck</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/buttonstyle.css">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
本当に削除してよろしいですか？<br>
	
	<button class="delete_btn" onclick="location.href='/ProjectJava/RegistServlet?action=deletelist'">削除する</button>
	<br>
	<button class="back_btn" onclick="location.href='exhibitloglist.jsp'">キャンセル</button>
</body>
</html>