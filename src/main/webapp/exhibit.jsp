<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibit</title>
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	教科書登録
	<form action="/ProjectJava/RegistServlet" method="post">
		ISBN番号<input type="text" name="number"><br> 
		値段<input type="text" name="price"><br>
		<%--状態もプルダウンの方がいいのか（新品、未使用、使用済み等）--%>
		状態<select name="example">
			<option value="新品">新品</option>
			<option value="未使用">未使用</option>
			<option value="中古">中古</option>
		</select> <br>
		備考<input type="text" name="remarks"><br>
		
		<input type="submit" value="登録確認">
		<input type="hidden" name="action" value=listingcheck> <br>
	</form>
	<button onclick="location.href='usertop.jsp'">戻る</button>
</body>
</html>