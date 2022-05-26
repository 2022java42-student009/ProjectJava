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
<div class="inner"
		style="width: 400px; text-align: left; margin: 0 auto;">
	<h2 style="text-align: center">教科書登録</h2>
	<form action="/ProjectJava/RegistServlet" method="post">
		ISBN番号<br><input type="text" name="number" required><br><br> 
		値段<br><input type="number" name="price" required><br><br>
		<%--状態もプルダウンの方がいいのか（新品、未使用、使用済み等）--%>
		状態<br><select name="example">
			<option value="新品">新品</option>
			<option value="未使用">未使用</option>
			<option value="中古">中古</option>
		</select> <br><br>
		備考<br><input type="text" name="remarks">
		<c:if test="${not empty errmsg }">
			<p style="color: red;">${errmsg }</p>
		</c:if>
		<br><br><div align="center" class="example-r">
		<input type="submit" class="login_btn" value="登録確認">
		<input type="hidden" name="action" value=listingcheck>
		</div> <br>
	</form>

	<div align="right" class="example-r"><button onclick="location.href='usertop.jsp'" class="back_btn">戻る</button></div>	</div>
</body>
</html>