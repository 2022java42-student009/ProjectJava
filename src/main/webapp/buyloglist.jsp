<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyloglist</title>
<link href="css/buttonstyle.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/registstyle.css">
<style>
.back_btn{
	margin-left:50px;
}
</style>
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	購入履歴一覧
	
		<table border="1">
			<tr>
				<td>購入日</td>
				<td>タイトル名</td>
				<td>ISBN番号</td>
				<td>分類名</td>
				<td>値段</td>
			</tr>
			
		<c:forEach items="${Buy}" var="buy">
			<tr>
				<td align="center"><fmt:formatDate value="${buy.selesday}" pattern="YYYY/MM/dd HH:MM" /></td>
				<td align="center">${buy.title}</td>
				<td align="center">${buy.book}</td>
				<td align="center">${buy.categoryname}</td>
				<td align="center">${buy.price}</td>
			</tr>

		</c:forEach>
	</table>
	
	<br>
	<button onclick="location.href='usertop.jsp'" class ="back_btn">戻る</button>

</body>
</html>