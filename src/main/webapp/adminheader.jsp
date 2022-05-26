<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <style type="text/css">
 body{
 	margin: 0;
 	padding: 0;
 }
 
 header{
    display: flex;
    justify-content: space-between;
    height: 50px;
    padding: 15px;
    background: #f0f8ff;
    align-items: center;
    
}

header a{
	color: #000;
	text-decoration: none;
}
 
 </style>
 <header>
 
<a href="admintop.jsp"><h1 class="logo">TEXT-OFF</h1></a>
<c:if test="${loginstate}">
	<p>${admin.name }さんでログインしています。<button onclick="location.href='/ProjectJava/AccountServlet?action=logout'">ログアウト</button></p>
</c:if>

</header>
