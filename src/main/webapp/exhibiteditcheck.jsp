<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibiteditcheck</title>
</head>
<body>
	<form action="/ProjectJava/RegistServlet" method="post">
		以下の情報で登録します。よろしいですか？
		<br>
		
			
			ISBM番号	${lchangecheck.book.isbm}<br>
			値段		${lchangecheck.price}<br>
			状態		${lchangecheck.state}<br>
			備考		${lchangecheck.remarks}<br>
				
		<input type="hidden" name="action" value="changelist">
		<input type="submit" value="更新する">
		<br>
	</form>
	<button onclick="location.href='exhibitloglist.jsp'">戻る</button>
</body>
</html>