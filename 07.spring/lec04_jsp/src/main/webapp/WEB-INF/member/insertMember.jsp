<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>회원 등록하기</h3>
		<hr />
		<form action="insertMember" method="post">
			<table border="2">
				<tr>
					<td bgcolor="green" style="color:white;" width="80">아이디</td>
					<td align="left"><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td bgcolor="green" style="color:white;" >비밀번호</td>
					<td align="left"><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td bgcolor="green" style="color:white;" >이름</td>
					<td align="left"><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td bgcolor="green" style="color:white;" >직책</td>
					<td align="left"><input type="text" name="role"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원등록" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>