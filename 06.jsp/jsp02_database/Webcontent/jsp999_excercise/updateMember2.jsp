<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String nick = request.getParameter("nick");
	String tel = request.getParameter("tel");
	String region = request.getParameter("region");

	Class.forName("org.mariadb.jdbc.Driver");
	String url = "jdbc:mariadb://localhost:3306/jspstudy";
	String usr = "root";
	String pwd = "12345";
	String sql = "update member set password=?, name=?, nick=?, tel=?, region=? where id=?";
	int row = 0;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = DriverManager.getConnection(url, usr, pwd);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, password);
		pstmt.setString(2, name);
		pstmt.setString(3, nick);
		pstmt.setString(4, tel);
		pstmt.setString(5, region);
		pstmt.setString(6, id);
		
		row = pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		out.println("DB연결실패");
		e.printStackTrace();
	} finally {
		try{
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
	<%= row %> 건이 수정되었습니다 <br />
	<a href="listMember.jsp" class="btn btn-success">회원목록</a>
	
</body>
</html>