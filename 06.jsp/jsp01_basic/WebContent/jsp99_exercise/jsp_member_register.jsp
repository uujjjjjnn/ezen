<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="jsp_member_process.jsp">

	아이디   : <input type="text" name="id" size="10"/>	<br />
	비밀번호 : <input type="password" name="pw" size="10"/> <br />
	연락처   : <input type="text" name="tel" size="15"/> <br />
	성별 : <input type="radio" name="gender" value="여자">여자
			<input type="radio" name="gender" value="남자"/>남자<br />
	취미 : <input type="checkbox" name="hobbies" value="음악"/> 음악
		   <input type="checkbox" name="hobbies" value="운동"/> 운동
		   <input type="checkbox" name="hobbies" value="독서"/> 독서<br />
	가입인사 : <textarea name="hello" rows="3" cols="20"></textarea> <br /><br />
	
	<input type="submit" name="submit" value="가입하기"/><t> </t>
	<button type= "reset">새로고침</button>
	
	
	</form>


</body>
</html>