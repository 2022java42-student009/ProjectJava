<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/buttonstyle.css">
<style type="text/css">
.search {
	width: 1000px;
	margin: 0 auto;
	margin-top: 30px;
}

.result {
	width: 940px;
	margin: 0 auto;
}

h2 {
	text-align: center;
}

table {
	margin: 0 auto;
	border-collapse: collapse;
	border: 1px solid #ccc;
	text-align: center;
	line-height: 1.5;
}

table th {
	padding: 8px;
	font-weight: bold;
	vertical-align: top;
	background: #60b4df;
	color: #ffffff;
}

table td {
	padding: 8px;
	vertical-align: top;
}

table tr:nth-child(even) {
	background: #eceff1;
}

.back_btn {
	padding: 2px 10px;
}

.back {
	margin: 30px 0;
}

.back .back_btn {
	margin-left: auto;
}

.err {
	color: red;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<div class="search">
		<h2>教科書検索</h2>
		カテゴリー検索:
		<c:forEach items="${categories}" var="category">
			<a
				href="/ProjectJava/StockSerchServlet?action=category&categoryid=${category.id }">${category.name }</a>
		</c:forEach>
		<br>

		<form action="/ProjectJava/StockSerchServlet?action=title"
			method="post">
			タイトル検索: <input type="text" name="name"> <input type="submit"
				value="検索" class="back_btn" style="display: inline">
		</form>



		<form action="/ProjectJava/StockSerchServlet?action=isbn"
			method="post">
			ISBN番号検索: <input type="text" name="id" required> <input
				type="submit" value="検索" class="back_btn" style="display: inline">
		</form>

		金額 <a href="/ProjectJava/StockSerchServlet?action=price&pricerange=0">0～1000</a>
		<a href="/ProjectJava/StockSerchServlet?action=price&pricerange=1">1001～5000</a>
		<a href="/ProjectJava/StockSerchServlet?action=price&pricerange=2">5001～10000</a>
		<a href="/ProjectJava/StockSerchServlet?action=price&pricerange=3">10001以上</a>
	</div>

	<h2>検索結果</h2>

	<div class="result">
	<c:if test="${empty stocks }">
		<p style="color: red;">教科書が見つかりませんでした</p>
	</c:if>
	<c:if test="${not empty stocks }">
		<table border="1">
			<tr>
				<th style="width: 270px">タイトル名</th>
				<th style="width: 150px">カテゴリー</th>
				<th style="width: 230px">著者</th>
				<th style="width: 150px">金額</th>
				<th></th>
			</tr>

			<c:forEach items="${stocks }" var="stock">
				<tr>
					<td>${stock.book.title }</td>
					<td>${stock.book.categoryname }</td>
					<td>${stock.book.author }</td>
					<td>${stock.price }円</td>
					<td><button
							onclick="location.href='/ProjectJava/BuyServlet?action=buycheck&stockid=${stock.id}'" class="back_btn">購入</button></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
		
		<div class="back">
			<button onclick="location.href='usertop.jsp'" class="back_btn">戻る</button>
		</div>
	</div>
</body>
</html>