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
<jsp:include page="/userheader.jsp"/>
	<h2>教科書検索</h2>
	カテゴリー検索:
	<c:forEach items="${categories}" var="category">
	<a href="/ProjectJava/StockSerchServlet?action=category&categoryid=${category.id }">${category.name }</a>
	</c:forEach>
	<br>
	
	<form action="/ProjectJava/StockSerchServlet?action=title" method="post">
		タイトル検索:
		<input type="text"  name="name" >
		<input type="submit" value="検索">
	</form>
	
	
	
	<form action="/ProjectJava/StockSerchServlet?action=isbn" method="post">
		ISBN番号検索:
		<input type="text"  name="id" required>
		<input type="submit" value="検索">
	</form>
	
	金額
	<a href="/ProjectJava/StockSerchServlet?action=price&pricerange=0">0～1000</a>
	<a href="/ProjectJava/StockSerchServlet?action=price&pricerange=1">1001～5000</a>
	<a href="/ProjectJava/StockSerchServlet?action=price&pricerange=2">5001～10000</a>
	<a href="/ProjectJava/StockSerchServlet?action=price&pricerange=3">10001以上</a>
	
	
	<h2>検索結果</h2>
	
	<c:if test="${empty stocks }">
		<p style="color: red;">教科書が見つかりませんでした</p>
	</c:if>
	
	<c:forEach items="${stocks }" var="stock">
	<div class="items" style="border: 1px solid; margin: 10px auto; width">
		${stock.book.title }
		${stock.price }円<br>
		${stock.book.author }
		${stock.book.categoryname }
		
		<button onclick="location.href='/ProjectJava/BuyServlet?action=buycheck&stockid=${stock.id}'">購入</button>
	</div>
	</c:forEach>
	<button onclick="location.href='usertop.jsp'">戻る</button>
</body>
</html>