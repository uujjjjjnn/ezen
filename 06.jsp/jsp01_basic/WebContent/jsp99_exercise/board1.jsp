<%@page import="com.lec.board.Board1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.board.BoardList1"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
BoardList1 bl = new BoardList1();
ArrayList<Board1> boards = bl.getBoardList1();

String bd = "<table class='table table-dark' border='1'>";
	for(Board1 board : boards) {
		bd += "<tr><td>"
		   + board.getBno() + "</td><td>"
		   + board.getSubject() + "</td><td>"
		   + board.getWriter() + "</td><td>"
		   + board.getContent() + "</td></tr>";
	}
	bd += "</table>";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">   
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%= bd %>
</body>
</html>