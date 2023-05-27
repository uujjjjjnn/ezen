<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<form class="row g-3" action="listBoard_result.jsp" method="post">
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
	  <input type="submit" class="btn btn-success mt-sm-2" value="게시글등록"/>
		<a href="listBoard.jsp" class="btn btn-info mt-sm-2" >게시글목록</a>
	  </div>
	</form>
	</div>
</body>
</html>