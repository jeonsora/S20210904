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
<h1>마이페이지수정</h1><p>
<form action="mbMypageUpdateForm" method="post">
	비밀번호를 입력하세요<br>
	<input type="password" name="user_pw"><br>
	<c:if test="${not empty msg }">${msg }<p></c:if>
	<input type="submit" value="확인"> 
</form>

</body>
</html>