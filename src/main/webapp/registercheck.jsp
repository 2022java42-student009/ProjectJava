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

<c:forEach var="member" items="${members}">
 
    ${member.id }
    ${member.name}
    ${member.age }
  
</c:forEach>



<input type = "submit" value ="登録する">
<button onclick="location.href='register.jsp'">修正</button>
</body>
</html>