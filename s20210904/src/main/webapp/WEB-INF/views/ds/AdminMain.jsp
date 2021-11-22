<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/ds/admin.css" type="text/css">
<link rel="stylesheet" href="css/reset.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<div id="body">

		<div id="nav">
			<div id="alram">
				<span id="alram_btn">
					<img src="#"><a href="#">미답변</a>&nbsp;&nbsp;
					<img src="#"><a href="#">미승인</a>
				</span>
			</div>
			<a href="#" id="logo"><img src="images/logo.png" width="100%" height="50px"></a> 
			<a href="#"><span>대시보드</span></a>
			<a href="#"><span>회원관리</span></a> 
			<a href="#"><span>기업관리</span></a> 
			<a href="#"><span>태그관리</span></a>
			<a href="#"><span>게시판관리</span></a> 
		</div>
		<div id="adminBoard">
			<div id="box1" class="QnA">
				<ul>
					<li>QnA</li>
					<li><a href="#">>더보기</a></li>
				</ul>
				<table id="QnAlist">
					<tr>
						<th id="title">QnA</th>
					</tr>
					<tr>
						<td>호호호</td>
					</tr>
					<tr>
						<td>호호호</td>
					</tr>
					<tr>
						<td>호호호</td>
					</tr>
					<c:forEach var="QnAList" items="${QnAList}" varStatus="status">
						<c:if test="${stauts.index < 5 }">
							<tr>
								<td>${QnAList.title}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			<div id="box1" class="board">
				<ul>
					<li>QnA</li>
					<li><a href="#">>더보기</a></li>
				</ul>
				<table id="QnAlist">
					<tr>
						<th id="title">QnA</th>
					</tr>
					<tr>
						<td>호호호</td>
					</tr>
					<tr>
						<td>호호호</td>
					</tr>
					<tr>
						<td>호호호</td>
					</tr>
					<c:forEach var="QnAList" items="${QnAList}" varStatus="status">
						<c:if test="${stauts.index < 5 }">
							<tr>
								<td>${QnAList.title}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			<div id="box1" class="comConfirm">
							<ul>
					<li>기업승인현황</li>
					<li><a href="#">>더보기</a></li>
				</ul>
				<table id="QnAlist">
					<tr>
						<th id="title">기업명</th>
					</tr>
					
					<c:forEach var="i" begin="0" end="4">
					<tr>
						<td>중앙테크 <input type="button" value="확인" id="confirm">
								  <input type="button" value="취소"></td>
					</tr>
					</c:forEach>

					
					<c:forEach var="QnAList" items="${QnAList}" varStatus="status">
						<c:if test="${stauts.index < 5 }">
							<tr>
								<td>${QnAList.title}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
			<div id="box1">
							<ul>
					<li>공고현황</li>
					<li><a href="#">>더보기</a></li>
				</ul>
				<table id="QnAlist">
					<tr>
						<th id="title">공고명</th>
					</tr>
					<c:forEach var="i" begin="0" end="4">
					<tr>
						<td>중앙테크로오세요</td>
					</tr>
					</c:forEach>
					<c:forEach var="QnAList" items="${QnAList}" varStatus="status">
						<c:if test="${stauts.index < 5 }">
							<tr>
								<td>${QnAList.title}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>