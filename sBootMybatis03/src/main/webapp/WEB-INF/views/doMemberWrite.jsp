<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>doMemberWrite</title>
</head>
<body>

 <h2>직원정보 입력</h2>
<form action="" method="post" name="frm">
<table>
	<tr><th>사번</th><td><input type="text" name="id" 
		required="required" maxlength="4" value="${id}">
		<input type="button" value="중복확인" 
		onclick="chk()"> </td></tr>
	<tr><th>비밀번호</th><td><input type="text" name="password" 
		required="required"> </td></tr>
	<tr><th>이름</th><td><input type="text" name="name" 
		required="required"></td></tr>

	<tr><td colspan="2"><input type="submit" value="확인"></td></tr>
</table>
</form>

</body>
</html>