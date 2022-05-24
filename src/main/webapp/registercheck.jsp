<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registercheck</title>
</head>
<body>
<jsp:include page="/indexheader.jsp"/>
以下の内容で登録してよいか確認してください<br>


 <form action="/ProjectJava/AccountServlet" method="post">
    名前:${member.name}<br>
    住所:${member.address}<br>
    電話番号:${member.tel}<br>
    メールアドレス:${member.mail}<br>
    生年月日:${member.birthday}<br>
    パスワード:${member.password}<br>
 <input type="hidden" name="action" value="register">
<input type = "submit" value ="登録する">
</form>

<button onclick="location.href='register.jsp'">修正</button>
</body>
</html>