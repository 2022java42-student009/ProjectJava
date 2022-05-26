<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品取り消し</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/buttonstyle.css">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
<div class="inner"
		style="width: 400px; text-align: left; margin: 0 auto;">
<h3 style="text-align: center">本当に削除してよろしいですか？</h3><br>
	
	<div align="center" class="example-r"><button class="delete_btn" onclick="location.href='/ProjectJava/RegistServlet?action=deletelist'">削除する</button></div>
	<br>
	<div align="right" class="example-r"><button class="back_btn" onclick="location.href='exhibitloglist.jsp'">キャンセル</button></div>
	</div>
</body>
</html>