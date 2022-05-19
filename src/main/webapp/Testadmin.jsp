<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者テスト</title>
</head>
<body>
	<h1>管理者情報一覧</h1>
	${admin.id }<br>
	${admin.name }<br>
	${admin.address }<br>
	${admin.tel }<br>
	${admin.mail }<br>
	${admin.birthday }<br>
	${admin.admissionday }<br>
	${admin.leaveday }<br>
</body>
</html>