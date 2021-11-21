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
<c:forEach var="listScrap" items="${listScrap }">
	${listScrap.anno_code } || ${listScrap.user_id } || ${listScrap.scr_date } <p>
</c:forEach>
</body>
</html>