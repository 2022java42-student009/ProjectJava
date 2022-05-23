<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr>
				<td>ISBM番号</td>
				<td>タイトル名</td>
				<td>著者</td>
				<td>分類名</td>
				<td>登録日</td>
				<td>登録値段</td>
				<td>備考</td>
			</tr>
			
		<c:forEach items="${Regist}" var="regist">
			<tr>
				<td align="center">${regist.book}</td>
				<td align="center">${regist.title}</td>
				<td align="right">${regist.author}</td>
				<td align="right">${regist.categoryname}</td>
				<td align="right">${regist.registday}</td>
				<td align="right">${regist.price}</td>
				<td align="right">${regist.remarks}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>