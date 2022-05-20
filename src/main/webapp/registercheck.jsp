<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registercheck</title>
</head>
<body>
以下の内容で登録してよいか確認してください<br>


 <form action="" method="post">
    ${member.name}
    ${member.address}
    ${member.tel}
    ${member.mail}
    ${member.birthday}
    ${member.password}
 <input type="hidden" name="action" value="memberlogin">
<input type = "submit" value ="登録する">
</form>

<button onclick="location.href='register.jsp'">修正</button>
</body>
</html>