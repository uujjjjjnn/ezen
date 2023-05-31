<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>회원 목록 보기</h1>
		<table border="2">
			<thead>
				<tr>
					<th bgcolor="green" style="color:white;" width="180">아이디</th>
					<th bgcolor="green" style="color:white;" width="100">이름</th>
					<th bgcolor="green" style="color:white;" width="120">직책</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="member" items="${ members }">
				<tr align="center">
					<td><a href="getMember?id=${ member.id }">${ member.id }</a></td>
					<td>${ member.name }</td>
					<td>${ member.role }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
				
		<br />
		<a href="insertMember">회원등록</a>
	</div>
</body>
</html>