<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">
<title>코딩몬</title>
</head>
<body>
<div id="container">
	<div class="header">	
		<div class="nav">
			<!--Logo Section -->
			<div class="nav_logo">
				<a class="nav_txt" href="#">코딩몬</a>
			</div>
			<!-- Search Section -->
			<form action="#">
				<div class="search">
					<input type="text" class="search-content" name="searchContent" placeholder="검색어 입력" required="required">
				</div>
			</form>
			<!--Menu Section -->
			<ul class="nav_menu">						
				<li><a href="#">회원가입</a></li>																				
				<li><a href="#">로그인</a></li>													
			</ul>		
		</div>
		<div class="nav2">
			<ul class="nav_menu2">						
				<li><a href="#">채용정보</a>
					<!-- <ul class="nav_sub">
						<li><a href="#">드롭다운</a></li>
						<li><a href="#">드롭다운</a></li>
						<li><a href="#">드롭다운</a></li>
					</ul> -->
				</li>																				
				<li><a href="#">게시판</a>
					<!-- <ul class="nav_sub">
						<li><a href="#">드롭다운</a></li>
						<li><a href="#">드롭다운</a></li>
						<li><a href="#">드롭다운</a></li>
					</ul> -->
				</li>													
			</ul>	
		</div>
	</div>
	<!-------------------------------------------------------------------------------------------------------->
	<div class="anno">
	  <h2> 공고 </h2>
		<table>
			<tr>
				<th>기업명</th>
				<th>제목</th>
				<th>지원자격</th>
				<th>마감 등록일</th>
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
	
	
	
	<!-------------------------------------------------------------------------------------------------------->
	<div class="footer">
		<a href="#">회사 소개</a>
	    <a href="#">고객센터</a></br>
	    <span>@2021 codingmon 개인정보 취급방침 </span>
	</div>
</div>
</body>
</html>