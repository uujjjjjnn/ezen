<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1 style="height:100px">회원가입</h1>
		<form action="insertMember2.jsp" method="post">
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault01">아이디</label>
      <input type="text" class="form-control" id="validationDefault01" name="id" value="" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="validationDefault01">비밀번호</label>
      <input type="password" class="form-control" id="validationDefault01" name="password" value="" required>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault02">이름</label>
      <input type="text" class="form-control" id="validationDefault02" name="name" value="" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="validationDefault03">닉네임</label>
      <input type="text" class="form-control" id="validationDefault03" name="nick" required>
    </div>
    </div>
    <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault05">연락처</label>
      <input type="text" class="form-control" id="validationDefault05" name="tel" required placeholder="(예) 01012345678">
    </div>
    <div class="col-md-6 mb-3">
      <label for="validationDefault04">지역</label>
      <select class="custom-select" id="validationDefault04" name="region" required>
        <option selected disabled value="">현재 살고있는 지역을 고르세요</option>
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
        회원가입에 동의하시나요
      </label>
    </div>
  </div>
  <button class="btn btn-success" type="submit">회원가입</button>
</form>
	</div>
</body>
</html>