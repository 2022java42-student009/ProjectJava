<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useredit</title>
</head>
<body>
<h1 style="text-align: center">会員情報変更画面</h1>
<form action="/ProjectJava/AccountServlet" method="post">
	名前<input type="text" name="name"><br>
  	住所<input type="text" name="address"><br> 
  	電話番号<input type="tel" name="tel"><br> 
  	メールアドレス<input type="email" name="mail"><br> 
  	パスワード<input type="password" name="password"><br>
  	<input type="hidden" name="action" value="useredit">
	<input type="submit" value="確認">
	
</form>
<button onclick="location.href='usertop.jsp'">キャンセル</button>
<br><br><button onclick="location.href='accountdeletecheck.jsp'">退会</button>
</body>
</html>