<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메일결과</h2>
<c:if test="${check eq 1 }">전송 성공</c:if>
<c:if test="${check eq 2 }">전송 실패</c:if>
</body>
</html>