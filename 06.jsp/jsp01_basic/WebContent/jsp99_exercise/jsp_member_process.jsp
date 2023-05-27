<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String hello = request.getParameter("hello");
	%>
	
	<table border="1">
	<tr><th>아이디</th> <th>아이디입력값</th></tr>
	
	<tr><td>아이디</td> <td> <%= id %></td></tr>
	<tr><td>비밀번호</td> <td><%= pw %></td></tr>
	<tr><td>연락처</td> <td><%= tel %></td></tr>
	<tr><td>성별</td> <td><%= gender %></td></tr>
	<tr><td>취미</td> <td>
	<% 
		for(String hobby:hobbies) {
			out.println(hobby);
		}
	%>
	</td></tr>
	<tr><td>가입인사</td> <td><%= hello %></td></tr>
	
	
	</table>


</body>
</html>