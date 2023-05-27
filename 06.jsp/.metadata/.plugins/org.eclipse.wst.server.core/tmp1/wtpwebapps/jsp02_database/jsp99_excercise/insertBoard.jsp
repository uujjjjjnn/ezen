<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
  	String writer = request.getParameter("writer");
	String crtdate = request.getParameter("crtdate");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");  

	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:mariadb://localhost:3306/jspstudy";
	String usr = "root";
	String pwd = "12345";
	String sql = "insert into board(writer,crtdate,subject,content) values (?, ?, ?, ?)";
	
	int row = 0;
	
	try {
		conn = DriverManager.getConnection(url, usr, pwd);
		pstmt = conn.prepareStatement(sql);
	
		pstmt.setString(1, writer);
		pstmt.setString(2, crtdate);
		pstmt.setString(3, subject);
		pstmt.setString(4, content);
		pstmt.executeUpdate();
		
		
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
	<div class="container" >
		<h1 align="center">게시글 등록</h1>
		<form class="row g-3" action="listBoard.jsp" method="post">
		  <div class="col-md-4">
		    <label for="writer" class="form-label">writer</label>
		    <input type="text" class="form-control" name="writer" value="">
		  </div>
		  <div class="col-12">
		    <label for="subject" class="form-label">subject</label>
		    <input style="height:50px" type="text" class="form-control" name="subject" value="">
		  </div>	
		  <div class="col-12">
		    <label for="content" class="form-label">content</label>
		    <input style="height:400px" "type="text" class="form-control" name="content" value="">
		  </div>

		  
	  <div class="col-12" >
		<a href="listBoard.jsp"><input type="submit" class="btn btn-success mt-sm-2" value="게시글등록"/></a>
	  </div>
	</form>
	</div>
</body>
</html>