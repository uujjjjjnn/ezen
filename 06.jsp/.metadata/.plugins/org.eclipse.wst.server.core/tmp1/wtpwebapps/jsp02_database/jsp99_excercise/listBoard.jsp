<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/* 	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String crtdate = request.getParameter("crtdate");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content"); */
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
		<h1 align="center">게시글 목록</h1>
			<div class="row">
			<table class="table table-bordered table-striped">
				<tr>
					<th>작성자</th>
					<th>제목</th>
					<th>내용</th>
					<th>등록날짜</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			<% 
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;					
			
			String url = "jdbc:mariadb://localhost:3306/jspstudy";
			String usr = "root";
			String pwd = "12345";
			String sql = "select * from board order by writer";
			
			try {
				conn = DriverManager.getConnection(url, usr, pwd);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

 				while(rs.next()) {
					
					String writer = rs.getString("writer");
				    String subject = rs.getString("subject");
				    String content = rs.getString("content");
				    String crtdate = rs.getString("crtdate");
			%>
				<tr>
					<td><a href="selectBoard.jsp"><%= writer %></a></td>
					<td><%= subject %></td>
					<td><%= content %></td>
					<td><%= crtdate %></td>
					<td><a href="updateBoard.jsp?writer=<%= writer %>" class="btn btn-warning">수정</a></td>
					<td><a href="deleteBoard.jsp?writer=<%= writer %>" class="btn btn-danger">삭제</a></td>
				</tr>
			<% 
				}
				
			} catch (Exception e) {
				out.println("<h3 class='bg-danger text-white'>DB접속 실패</h3><br />"
						+ e.getMessage());
				
			} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					// dummy
				}
			}
			%>
		</table>
		<a href="insertBoard.jsp" class="btn btn-success mt-sm-2">게시글등록</a>
	</div>
	</div>
</body>
</html>