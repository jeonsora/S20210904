<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<!-------------------------------------------------------------------------------------->
	<div class="detail">
		<h2>공고 상세</h2>
		<table>
			<tr><td>${comanno.com_name}&nbsp;&nbsp;&nbsp;<input type="button" value="관심기업등록 ♥">
														 <input type="button" value="스크랩">
														 <input type="button" value="지원하기" onclick="location.href=">
			</td></tr>
			<hr>
			<tr><td>${comanno.anno_title}</td></tr>
			<tr><td>----------------------------------------------</td></tr>
			
			<td><h3>모집 내용</h3></td>
			<tr><th>모집 직종</th><td>${recjob.comm_ctx}</td></tr>
			<tr><th>고용형태</th><td>${emptype.comm_ctx}</td></tr>
			<tr><th>모집인원</th><td>${comanno.rec_vol}</td></tr>
			<%-- <tr><th>기술스택</th><td>${comanno.tech_tag1}</td></tr> --%>
			<%-- <tr><th>기술스택</th><td>${comanno.tech_tag2}</td></tr> --%>
			<tr><th>학력</th><td>${comanno.rec_edu}</td></tr>
			<%-- <tr><th>경력</th><td>${comanno.career}</td></tr> --%>
			<tr><th>모집상세</th><td>${comanno.rec_dtl}</td></tr>
			<tr><td>----------------------------------------------</td></tr>
	
			<td><h3>근무조건</h3></td>
			<tr><th>급여정보</th><td>${comanno.pay_info}원</td></tr>
			<tr><th>상세근무조건</th><td>${comanno.work_cdt}</td></tr>
			<tr><th>복리후생</th><td>${comanno.etc_cdt}</td></tr>
			<tr><td>----------------------------------------------</td></tr>
			
			<td><h3>기업 정보</h3></td>
			<tr><th>기업명</th><td>${comanno.com_name}</td></tr>
			<tr><th>기업 E-mail</th><td>${comanno.com_email}</td></tr>
			<tr><th>기업 전화번호</th><td>${comanno.com_tel}</td></tr>
			<tr><th>담당자 전화번호</th><td>${comanno.com_mgr_tel}</td></tr>
			<tr><th>기업 주소</th><td>${comanno.com_addr}</td></tr>
			<%-- <tr><th>업종</th><td>${comanno.com_sec}</td></tr> --%>
			<tr><th>사업 내용</th><td>${comanno.com_bus}</td></tr>
			<tr><th>기업 홈페이지</th><td>${comanno.com_web}</td></tr>
			<tr><td>----------------------------------------------</td></tr>
			
			<td><h3>공고 기간</h3></td>
			<tr><th>공고 등록일 : </th><td>${comanno.anno_regdate}</td></tr>
			<tr><th>공고 마감일 : </th><td>${comanno.anno_c_regdate}</td></tr>
			
			
			
	
	
		</table>
	</div>
	<!-------------------------------------------------------------------------------------->
	<br><br><br>
	<div class="footer">
		<a href="#">회사 소개</a>
	    <a href="#">고객센터</a></br>
	    <span>@2021 codingmon 개인정보 취급방침 </span>
	</div>
</div>
</body>
</html>