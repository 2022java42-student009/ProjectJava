<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitdeleteend</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/userheader.jsp" />
	<h3 style="text-align: center">
		削除を完了しました<br>
	</h3>
	<%--トップに戻るボタンが画面レイアウト設計書には記載がありません--%>
	<div align="center" class="example-r">
		<button onclick="location.href='usertop.jsp'" class=top_btn>トップページに戻る</button>
	</div>
	<div align="center" class="example-r">
		<button class="top_btn"
			onclick="location.href='/ProjectJava/RegistServlet?action=registlist'">出品履歴一覧</button>
	</div>
</body>
</html>