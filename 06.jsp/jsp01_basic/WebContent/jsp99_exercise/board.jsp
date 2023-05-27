<%@page import="java.sql.SQLException"%>
<%@page import="com.lec.board.BoardVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.lec.board.ConnectionFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.board.Board"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">   
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> -->
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<BoardVO> boardList = new ArrayList<>();
	
 	ConnectionFactory cf = new ConnectionFactory();
	Connection conn = cf.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql= cf.getSelect(); 

%>
<%
	try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			BoardVO board = new BoardVO();
			board.setBno(rs.getInt("bno"));
			board.setSubject(rs.getString("subject"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setReadcnt(rs.getInt("readcnt"));
			board.setCrtdate(rs.getString("crtdate"));
			boardList.add(board);
			
		}
			request.setAttribute("boards", boardList);
	} catch (SQLException e) {
		out.print("조회 목록 실패");
		e.printStackTrace();
	} finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
%>	
	
	<table border="1">
		<tr>	
			<th>bno</th><th>subject</th><th>writer</th><th>content</th><th>readcnt</th><th>crtdate</th>
		</tr>
		
	<c:forEach var="a" items="${boards}">
		<tr>
			<td>${ a.getBno() }</td>
			<td>${ a.getSubject() }</td>
			<td>${ a.getWriter() }</td>
			<td>${ a.getContent() }</td>
			<td>${ a.getReadcnt() }</td>
			<td>${ a.getCrtdate() }</td>

		</tr>
	</c:forEach>	 
	</table>
	
</body>
</html>