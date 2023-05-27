<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:mariadb://localhost:3306/jspstudy";
	String usr = "root";
	String pwd = "12345";
	String sql = "delete from member where id=?";
	int row=0;
	
	try {
		conn = DriverManager.getConnection(url, usr, pwd);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);

		row = pstmt.executeUpdate();
		
	} catch (Exception e) {
		out.println("<h3 class='bg-danger text-white'>DB접속 실패</h3><br />"
				+ e.getMessage());	
	} finally {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			// dummy
		}
	}
	
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
		<h1>회원삭제결과</h1>

		<%= id %> <br />

		<hr />
		
		<%
			if(row>0) {
		%>
				<h3 class="bg-info text-white"><%= id %>회원의 정보가 성공적으로 삭제되었습니다</h3>
		<% 
			} else {
		%>
				<h3 class="bg-danger text-white"><%= id %>회원정보삭제실패!</h3>
		<% 
			}
		%>
		
	</div>
	<a href="jsp05_listMember.jsp" class="btn btn-primary">회원목록</a>

</body>
</html>