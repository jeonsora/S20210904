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
<c:if test="${not empty mypageupdatemsg }">
	${mypageupdatemsg} <p>
	<script type="text/javascript">
		alert("1");
	</script>
</c:if>

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

<a href="mbMypageApply">입사지원현황</a><br>
<a href="mbMypageResume">이력서관리</a><br>
<a href="mbMypageResumeWrite">이력서작성</a><br>
<a href="mbMypageScrap">스크랩</a><br>
<a href="mbMypageUpdate">마이페이지수정</a><br>
</body>
</html>