<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = "";
	String name = "";
	String nick = "";
	String tel = "";
	String region = "";
	 
	 Class.forName("org.mariadb.jdbc.Driver");
	 String url = "jdbc:mariadb://localhost:3306/jspstudy";
	 String usr = "root";
	 String pwd = "12345";
	 String sql = "select * from member where id = '" + id + "'";
	 
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 
	 try {
		 conn = DriverManager.getConnection(url, usr, pwd);
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery(sql);
		 
		while(rs.next()) { 
		
		password = rs.getString("password");
		name = rs.getString("name");
		nick = rs.getString("nick");
		tel = rs.getString("tel");
		region = rs.getString("region");
 
		}
		 		
		 
		 
	 } catch (Exception e) {
		 out.println("DB연결 실패");
		 e.printStackTrace();
	 } finally {
		 try {
			 if(rs != null) rs.close();
			 if(stmt != null) stmt.close();
			 if(conn != null) conn.close();
		 } catch (Exception e){
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
	<h1 style="height:100px">회원수정</h1>
		<form action="updateMember2.jsp" method="post">
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault01">아이디</label>
      <input type="text" class="form-control" id="validationDefault01" disabled name="id" value="<%= id %>">
    </div>
    <div class="col-md-6 mb-3">
      <label for="validationDefault01">비밀번호</label>
      <input type="password" class="form-control" id="validationDefault01" name="password" value="<%= password %>" required>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault02">이름</label>
      <input type="text" class="form-control" id="validationDefault02" name="name" value="<%= name %>" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="validationDefault03">닉네임</label>
      <input type="text" class="form-control" id="validationDefault03" name="nick" value="<%= nick %>" required>
    </div>
    </div>
    <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault05">연락처</label>
      <input type="text" class="form-control" id="validationDefault05" name="tel" value="<%= tel %>" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="validationDefault04">지역</label>
      <select class="custom-select" id="validationDefault04" name="region" value=<%= region %> required>
        <option selected disabled value="<%= region %>"><%= region %></option>
        <option name="region" value="경기">경기</option>
        <option name="region" value="서울">서울</option>
        <option name="region" value="부산">부산</option>
        <option name="region" value="제주">제주</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
      <label class="form-check-label" for="invalidCheck2">
        회원을 수정합니다
      </label>
    </div>
  </div>
  <input type="hidden" name="id" value="<%= id %>"/>
  <a href="updateMember2.jsp"><button class="btn btn-warning" type="submit">회원수정</button></a>
  <a href="listMember.jsp" class="btn btn-success" type="submit">회원목록</a>
</form>
	</div>
</body>
</html>