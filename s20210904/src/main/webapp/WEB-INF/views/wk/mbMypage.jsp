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

지원완료 : ${countapply[0].applying}<br>
서류통과 : ${countapply[0].passdoc}<br>
최종합격 : ${countapply[0].failed}<br>
불합격 : ${countapply[0].pass}<p>

${mbid }의 이력서<br>
<c:forEach var="resumelist" items="${resumelist}" varStatus="status">
	${status.count} &nbsp;&nbsp; ${resumelist.res_title} &nbsp;&nbsp; ${resumelist.res_date} &nbsp;&nbsp; ${resumelist.rep_res}
	&nbsp;&nbsp; ${resumelist.comm_ctx}<br>
</c:forEach><p>

<a href="mbMypageApply">입사지원현황</a>
<a href="mbMypageResume">이력서관리</a>
</body>
</html>