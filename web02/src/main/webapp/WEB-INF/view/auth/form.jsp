<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="login.do" method="post">
이메일 <input type="text" name="email" value="${userEmail}"><br>
암호 <input type="password" name="password"><br>
<input type="checkbox" name="saveId" 
<c:if test="${not empty userEmail}">checked</c:if>
>ID 저장<br>
<input type="submit" value="로그인">
</body>
</html>








