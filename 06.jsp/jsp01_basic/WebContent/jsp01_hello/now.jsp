<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// < % % > : 스크립트릿, java 소스를 작성하는 곳
	Date now = new Date();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>http://localhost:8088/jsp01_basic/now.jsp</h1>
	<h1>안녕하세용? 반갑습니당</h1>
	<!-- < %= % > : 표현식, java변수 or 계산식 등을 정의하는 곳 -->
	<h1>현재시간은? : <%= now %></h1>
	<h1>현재시간은? : <%= new java.util.Date() %></h1>
</body>
</html>