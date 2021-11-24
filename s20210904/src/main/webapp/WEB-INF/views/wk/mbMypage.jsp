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
<h1>mbMypage</h1>
mbid : ${mbid }<p>

지원완료 : ${countapply[0].applying}<p>
서류통과 : ${countapply[0].passdoc}<p>
최종합격 : ${countapply[0].failed}<p>
불합격 : ${countapply[0].pass}<br>

${mbid }의 이력서
<c:forEach var="resumelist" items="${resumelist}">
	${status.count} &nbsp;&nbsp; ${resumelist.res_title} &nbsp;&nbsp; ${resumelist.res_date} &nbsp;&nbsp; ${resumelist.res_sts}
	&nbsp;&nbsp; ${resumelist.rep_res}<p>
</c:forEach>
</body>
</html>