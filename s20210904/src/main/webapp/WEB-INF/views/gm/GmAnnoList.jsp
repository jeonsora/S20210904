<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/gm/GmAnnoList.css" rel="stylesheet" type="text/css">
<title>코딩몬</title>
</head>
<body>

<%@ include file="header.jsp" %>

	<!-------------------------------------------------------------------------------------------------------->
<div id="container">
	<div class="anno">
		<div class="anno_title">
		  <h2> 공고 </h2>
			<table>
				<tr>
					<th>기업명</th>
					<th>제목</th>
					<th>지원자격</th>
					<th>등록일</th>
					<th>마감일</th>
				</tr>
				 <c:forEach var="comanno" items="${listAnno}">
					<tr>
					    <td>${comanno.com_name}</td>
						<td><a href="detail?anno_code=${comanno.anno_code}">${comanno.anno_title}</a></td>
						<td>${comanno.rec_edu}</td>
						<td>${comanno.anno_regdate} ~</td>
						<td>${comanno.anno_c_regdate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="page">
			<c:if test="${pg.startPage > pg.pageBlock }">
				<a href="GmAnnoList?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
				<a href="GmAnnoList?currentPage=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${pg.endPage < pg.totalPage}">
				<a href="GmAnnoList?currentPage=${pg.startPage + pg.pageBlock}">[다음]</a>
			</c:if>
		</div>
	</div>
</div>		
	
	<!-------------------------------------------------------------------------------------------------------->
	<br><br><br>
	<%@ include file="footer.jsp" %>
</body>
</html>