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
<h1>스크랩(${scarpcount })</h1>
<table>
	<tr><th>기업명</th><th>공고명</th><th>경력</th><th>학력</th><th>급여</th><th>마감일</th></tr>
	<c:forEach var="scarplist" items="${scarplist}">
		<tr><td>${scarplist.com_name }+링크달아야됨</td>
		    <td>${scarplist.anno_title }+링크달아야됨</td>
			<td>${scarplist.comm_ctx }</td>
			<td>${scarplist.rec_edu }</td>
			<td>${scarplist.pay_info }</td>
			<td>${scarplist.anno_c_regdate }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>