<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdateOutput</title>
</head>
<body>
<h3>수정결과</h3>
	<p>${member.id }/ ${member.name }/ ${member.mail }</p>
	<a href ="index.jsp">첫페이지</a>
</body>
</html>