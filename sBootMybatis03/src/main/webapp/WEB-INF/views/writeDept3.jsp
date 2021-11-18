<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {
/* 		if (!frm.empno.value) {
			alert("사번을 입력한 후에 확인하세요");
			frm.empno.focus();
			return false;
		} else location.href="confirm.do?empno="+frm.empno.value; */
	}
</script>
</head>
<body>

<h2>부서정보 입력</h2>
<c:if test="${msg!=null}">${msg}</c:if>
<form action="writeDept" method="post" name="frm">
	<table>
		<tr><th>부서번호</th><td><input type="number" name="deptno" 
			required="required" maxlength="2" >
			<input type="button" value="중복확인:미구현" 
			onclick="chk()"> </td></tr>
		<tr><th>부서이름</th><td><input type="text" name="dname" 
			required="required"> </td></tr>
		<tr><th>부서위치</th><td><input type="text" name="loc" 
			required="required"></td></tr>
		
		<tr><td colspan="2">
		<input type="submit" value="확인"></td></tr>
			
	</table>
	입력된 부서번호 :<c:if test="${dept.odeptno!=null}">${dept.odeptno}</c:if><p>
	입력된 부서명   :<c:if test="${dept.odname!=null}">${dept.odname}</c:if><p> 
	입력된 부서위치 :<c:if test="${dept.oloc!=null}">${dept.oloc}</c:if><p> 
	<%-- ${deptVO.Oloc} --%>
	        
	<h2>부서 정보 List</h2>
	<table>
		<tr><th>부서명</th><th>부서이름</th><th>근무지</th></tr>
		<c:forEach var="listDept" items="${listDept}">
			<tr><td>${listDept.odeptno }</td>
			    <td>${listDept.odname }</td>
				<td>${listDept.oloc }</td>
			</tr>
		</c:forEach>
	</table>     
	        
</form>   
	
</body>
</html>