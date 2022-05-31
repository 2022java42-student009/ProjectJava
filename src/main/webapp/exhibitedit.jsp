<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitedit</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
		<div class="inner"
		style="width: 600px; text-align: left; margin: 0 auto;">
		<h2 style="text-align: center">出品情報編集画面</h2><br>
	<c:forEach items="${singlelist}" var="list">
	
	<form action="/ProjectJava/RegistServlet" method="post">
		ISBN番号<br><input type="text" name="number" value="${list.book}"><br><br> 
		値段<br><input type="text" name="price" value="${list.price}"><br><br>
		状態<br><select name="example">
			<option value="新品">新品</option>
			<option value="未使用">未使用</option>
			<option value="中古">中古</option>
		</select> <br><br>
		備考<br><input type="text" name="remarks" value="${list.remarks}"><br><br> 
		<div align="center" class="example-r">
		<input type="hidden" name="action" value=changellistcheck>
		<input	type="submit" class=login_btn value="確認">
		</div>
	</form>
	<div align="right" class="example-r">
	<button onclick="location.href='exhibitloglist.jsp'"class=back_btn>戻る</button></div>
	</c:forEach>
	</div>
</body>
</html>