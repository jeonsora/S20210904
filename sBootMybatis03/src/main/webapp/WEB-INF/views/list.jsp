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
<h2>직원 목록</h2>
<c:if test="${msg!=null }">${msg }</c:if><p>
<a href="writeForm">입력</a>
회원수 : ${total }<br>
<p>kkk 수정시 전달 Message: ${kkk }<p>
<p>kk3 수정시 전달 Message: ${kk3 }<p>
<%-- <c:forEach items="${listEmp }" var="listEmp">
	이름 : ${listEmp.ename }<br>
</c:forEach> --%>
<p>
<c:set var="num" value="${pg.total-pg.start+1 }"></c:set>
<table>
	<tr>
		<th>번호</th><th>사번</th><th>이름</th><th>업무</th><th>급여</th>
		<c:forEach var="emp" items="${listEmp }">
			<tr>
				<td>${num}</td><td>${emp.empno}</td>
				<td><a href="detail?empno=${emp.empno }">${emp.ename }</a></td>
				<td>${emp.job }</td><td>${emp.sal }</td>
				<c:set var="num" value="${num-1 }"></c:set>
			</tr>
		</c:forEach>
	</tr>
</table>
<c:if test="${pg.startPage>pg.pageBlock }">
	<a href="empList?currentPage=${pg.startPage-pg.pageBlock }">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
	<a href="empList?currentPage=${i }">[${i }]</a>
</c:forEach>
<c:if test="${pg.endPage<pg.totalPage }">
	<a href="empList?currentPage=${pg.startPage+pg.pageBlock }">[다음]</a>
</c:if>
</body>
</html>




















