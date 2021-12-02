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

지원완료 : ${countapply[0].applying}<br>
서류통과 : ${countapply[0].passdoc}<br>
최종합격 : ${countapply[0].failed}<br>
불합격 : ${countapply[0].pass}<p>

<table>
	<tr>
		<th>지원회사</th><th>지원포지션</th><th>이력서제목</th><th>작성시간</th><th>상태</th>
		<c:forEach var="applyList" items="${applyList }">
			<tr>
				<td>${applyList.com_name}</td><td>${applyList.comm_ctx}</td>
				<td>${applyList.res_title}</td><td>${applyList.app_regdate}</td>
				<td>${applyList.com_app_sts}</td>
			</tr>
		</c:forEach>
	</tr>
</table>
</body>
</html>