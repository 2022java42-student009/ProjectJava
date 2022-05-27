<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibiteditcheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
<div class="inner"
		style="width: 400px; text-align: left; margin: 0 auto;">
	<form action="/ProjectJava/RegistServlet" method="post">
		<h3>以下の情報で登録します。よろしいですか？</h3>
		<br>
		
			
			ISBM番号<br>${lchangecheck.book.isbm}<br><br>
			値段<br>${lchangecheck.price}<br><br>
			状態<br>${lchangecheck.state}<br><br>
			備考<br>${lchangecheck.remarks}<br><br>
				
		<div align="center" class="example-r">		
		<input type="hidden" name="action" value="changelist">
		<input type="submit" class="login_btn" value="更新する">
		</div>
		<br>
	</form>
	<div align="right" class="example-r">
	<button onclick="location.href='exhibitloglist.jsp'"class="back_btn">戻る</button></div></div>
</body>
</html>