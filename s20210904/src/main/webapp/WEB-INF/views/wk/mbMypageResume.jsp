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
<h1>mbMypageResume</h1><p><p>

${mbid }의 이력서<br>
<c:forEach var="resumelist" items="${resumelist}" varStatus="status">
	${status.count} &nbsp;&nbsp; ${resumelist.res_title} &nbsp;&nbsp; ${resumelist.res_date} &nbsp;&nbsp; ${resumelist.rep_res}
	&nbsp;&nbsp; ${resumelist.comm_ctx} &nbsp;&nbsp; &nbsp;&nbsp; <input type="button" value="대표이력서">
	&nbsp;&nbsp; &nbsp;&nbsp; <input type="button" value="수정">
	&nbsp;&nbsp; &nbsp;&nbsp; <input type="button" value="삭제"><br>
</c:forEach><p>


</body>
</html>