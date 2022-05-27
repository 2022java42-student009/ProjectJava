<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usermanagementcheck</title>
<link href="css/buttonstyle.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/adminheader.jsp"/>
<div class="inner"
		style="width: 600px; text-align: left; margin: 0 auto;">
	<h3>以下の内容で変更します。よろしいですか？</h3>
	<br>
<div>
	<form action="/ProjectJava/AccountManagementServlet?action=editcheckend" method="post">
		会員ID<br>${editmember.id }<br><br>
		名前<br>${editmember.name }<br><br>
		パスワード<br>${editmember.password }<br><br>
		
		<div align="center" class="example-r">
		<input type="submit" value="確定" class="login_btn">
		</div>
	</form>
		</div>
			<div align="right" class="example-r">
	<button onclick="location.href='usermanagement.jsp'"class="back_btn">修正</button></div>
		</div>
</body>
</html>