<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="xxx" tagdir="/WEB-INF/tags" %>
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
	<h1>Tag파일로 제목태그 출력하기</h1>
	<hr />
	<xxx:header title="제목속성입니다 : level=null" />
	<xxx:header title="제목속성입니다 : level=1" level="1"/>
	<xxx:header title="제목속성입니다 : level=2" level="2"/>
	<xxx:header title="제목속성입니다 : level=3" level="3"/>
</body>
</html>