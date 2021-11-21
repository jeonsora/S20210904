<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<span id="alram_btn"><img src="#"><a>미답변</a>&nbsp;&nbsp;<img
					src="#"><a>미승인</a></span>
			</div>
			<img src="#"> <span>대시보드</span> <span>회원관리</span> <span>기업관리</span>
			<span>태그관리</span> <span>게시판관리</span>
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
						<td>중앙테크 <input type="button" value="확인">
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