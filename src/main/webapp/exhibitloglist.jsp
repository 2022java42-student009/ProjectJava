<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>exhibitloglist</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/registstyle.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/buttonstyle.css">
<style>
.back_btn{
	margin-left:50px;
}
</style>
</head>
<body>
<jsp:include page="/userheader.jsp"/>
	出品履歴一覧
	
		<table border="1">
			<tr>
				<td>ISBM番号</td>
				<td>タイトル名</td>
				<td>著者</td>
				<td>分類名</td>
				<td>登録日</td>
				<td>登録値段</td>
				<td>備考</td>
				<td>情報編集</td>
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
				<td align="right">
				<button class="green_btn" onclick="location.href='/ProjectJava/RegistServlet?action=changenextlist&listnumber=${regist.stock_id}'">編集</button>
				<button class="delete_btn" onclick="location.href='/ProjectJava/RegistServlet?action=deletecheck&listnumber=${regist.stock_id}'">削除</button></td>
				
			</tr>

		</c:forEach>
	</table>
	
	<br>
	<button class="back_btn" onclick="location.href='usertop.jsp'">戻る</button>

</body>
</html>