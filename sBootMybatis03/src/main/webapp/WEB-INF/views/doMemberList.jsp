<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 정보</h2>
조회자 ID : ${ID}
<table>
	<tr><th>ID</th><th>이름</th><th>비밀번호</th><th>등록일</th></tr>
	<c:forEach var="listMem" items="${listMem}">
		<tr><td>${listMem.id }</td>
		    <td>${listMem.name }</td>
			<td>${listMem.password }</td>
			<td>${listMem.reg_date }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>