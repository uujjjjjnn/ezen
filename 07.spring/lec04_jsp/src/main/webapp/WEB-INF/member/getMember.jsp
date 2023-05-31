<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>회원 상세보기</h3>
		<hr />
		<form action="updateMember" method="post">
			<table border="2">
				<tr>
					<td bgcolor="green" style="color:white;" width="80">아이디</td>
					<td align="left"><input type="text" name="id" value="${ member.getId() }" readonly/></td>
				</tr>
				<tr>
					<td bgcolor="green" style="color:white;">비밀번호</td>
					<td align="left"><input type="password" name="password" value="${ member.getPassword() }"/></td>
				</tr>
				<tr>
					<td bgcolor="green" style="color:white;">이름</td>
					<td align="left"><input type="text" name="name" value="${ member.getName() }"/></td>
				</tr>
				<tr>
					<td bgcolor="green" style="color:white;">직책</td>
					<td align="left"><input type="text" name="role" value="${ member.getRole() }"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원수정"/>
					</td>
				</tr>
			</table>
		</form>
		<a href="insertMember">회원등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteMember?id=${ member.getId() }">회원삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getMemberList">회원목록</a>
	</div>
</body>
</html>