<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibit</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	教科書登録
	<form action="/ProjectJava/RegistServlet" method="post">
		ISBN番号<input type="text" name="number" required><br> 
		値段<input type="number" name="price" required><br>
		<%--状態もプルダウンの方がいいのか（新品、未使用、使用済み等）--%>
		状態<select name="example">
			<option value="新品">新品</option>
			<option value="未使用">未使用</option>
			<option value="中古">中古</option>
		</select> <br>
		備考<input type="text" name="remarks"><br>
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<input type="submit" class="login_btn" value="登録確認">
		<input type="hidden" name="action" value=listingcheck> <br>
	</form>
	<button onclick="location.href='usertop.jsp'"class="back_btn">戻る</button>
</body>
</html>