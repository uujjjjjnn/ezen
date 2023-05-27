<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/* 	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String nick = request.getParameter("nick");
	String tel = request.getParameter("tel");
	String region = request.getParameter("region"); */
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	Class.forName("org.mariadb.jdbc.Driver");
	String url = "jdbc:mariadb://localhost:3306/jspstudy";
	String usr = "root";
	String pwd = "12345";
	String sql = "select * from member";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">   
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
	<h1 style="height:100px">회원목록</h1>
	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">아이디</th>
      <th scope="col">비밀번호</th>
      <th scope="col">이름</th>
      <th scope="col">닉네임</th>
      <th scope="col">연락처</th>
      <th scope="col">지역</th>
      <th scope="col">조회</th>
      <th scope="col">수정</th>
      <th scope="col">삭제</th>
    </tr>
  </thead>
  <tbody>
  
  <% 	
	try {
		conn = DriverManager.getConnection(url, usr, pwd);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String nick = rs.getString("nick");
			String tel = rs.getString("tel");
			String region = rs.getString("region");
%>			
	    <tr>
	      <th scope="row"><%= id %></th>
	      <td><%= password %></td>
	      <td><%= name %></td>
	      <td><%= nick %></td>
	      <td><%= tel %></td>
	      <td><%= region %></td>
	      <td><a href="selectMember.jsp?id=<%= id %>" class="btn btn-info" value="조회"/>조회</td>
	      <td><a href="updateMember.jsp?id=<%= id %>" class="btn btn-warning" value="수정"/>수정</td>
	      <td><a href="deleteMember.jsp?id=<%= id %>" class="btn btn-danger" value="삭제"/>삭제</td>
	    </tr>
	  </tbody>
<% 			
		}
		
		
	} catch (Exception e) {
		out.println("DB접속 실패");
		e.printStackTrace();
	} finally {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
%>
  
</table>

	</div>
</body>
</html>