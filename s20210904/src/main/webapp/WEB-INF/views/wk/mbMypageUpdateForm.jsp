<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="temp01.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마이페이지수정페이지</h1>
<form action="mbMypageUpdatePro" method="post">
	아이디 <input type="hidden" value="${member.user_id }" name="user_id">${member.user_id }<br>
	비밀번호 <input type="password" value="${member.user_pw}" name="user_pw"><br>
	이름 <input type="text" value="${member.user_name }" name="user_name"><br>
	생년월일 <input type="text" value="${member.user_brh }" name="user_brh"><br>
	성별 
	<c:if test="${member.user_sex eq 'F' }">
		<label><input type="radio" value="F" name="user_sex" checked="checked">남성</label>
		<label><input type="radio" value="M" name="user_sex">여성</label>
	</c:if>
	<c:if test="${member.user_sex eq 'M' }">
		<label><input type="radio" value="F" name="user_sex" >남성</label>
		<label><input type="radio" value="M" name="user_sex" checked="checked">여성</label>
	</c:if>
	<br>
	학력 <input type="text" value="${member.user_edu }" name="user_edu"><br>
	전화번호 <input type="text" value="${member.user_tel }" name="user_tel"><br>
	이메일 <input type="text" value="${member.user_email }" name="user_email"><br>
	주소 <input type="text" value="${member.user_addr }" name="user_addr"><br>
	<input type="submit" value="확인"> <input type="button" value="취소"><br>

</form>

</body>
</html>