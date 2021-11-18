<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%
	String context=request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보</h2>
<a href="mailTransport">Mail Test</a>

<table>
	<tr>
		<th>사번</th><th>이름</th><th>업무</th><th>부서</th><th>근무지</th>
	</tr>
	<c:forEach var="empDept" items="${listEmpDept }">
		<tr>
			<td>왜안돼 ${empDept.empno }</td><td>${empDept.ename }</td>
			<td>${empDept.job }</td><td>${empDept.deptno }</td>
			<td>${empDept.loc }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>


















