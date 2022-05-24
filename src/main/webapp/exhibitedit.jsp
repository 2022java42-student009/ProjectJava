<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitedit</title>
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	出品情報編集画面<br>
	<c:forEach items="${singlelist}" var="list">
	
	<form action="/ProjectJava/RegistServlet" method="post">
		ISBN番号<input type="text" name="number" value="${list.book}"><br> 
		値段<input type="text" name="price" value="${list.price}"><br>
		状態<select name="example">
			<option value="新品">新品</option>
			<option value="未使用">未使用</option>
			<option value="中古">中古</option>
		</select> <br>
		備考<input type="text" name="remarks" value="${list.remarks}"><br> 
		
		<input type="hidden" name="action" value=changellistcheck>
		<input	type="submit" value="確認">
	</form>
	<button onclick="location.href='exhibitloglist.jsp'">戻る</button>
	
	</c:forEach>
</body>
</html>