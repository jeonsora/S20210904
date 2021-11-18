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
<h2>직원정보</h2>
<table>
	<tr><th>사번</th><td>${emp.empno }</td></tr>
	<tr><th>이름</th><td>${emp.ename }</td></tr>
	<tr><th>업무</th><td>${emp.job }</td></tr>
	<tr><th>급여</th><td>${emp.sal }</td></tr>
	<tr><th>입사일</th><td>${emp.hiredate }</td></tr>
	<tr><th>보너스</th><td>${emp.comm }</td></tr>
	<tr><th>관리자사번</th><td>${emp.mgr }</td></tr>
	<tr><th>부서코드</th><td>${emp.deptno }</td></tr>
	<tr>
		<td colspan="2">
			<input type="button" value="목록" onclick="location.href='empList'">
			<input type="button" value="수정" onclick="location.href='updateForm?empno=${emp.empno}'">
			<input type="button" value="삭제" onclick="location.href='delete?empno=${emp.empno}'" formmethod="post">
		</td>
	</tr>
</table>
</body>
</html>


















