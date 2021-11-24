<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="CompanyMypageContainer">
	<div class="CompanyMypageMenu">
		<a href="#" id="ComMylogo"><img src="${compInfo.com_img}"></a> 
		<a href="#"><span>기업정보</span></a>
		<a href="#"><span>지원현황</span></a> 
		<a href="#"><span>채용공고</span></a> 
		<a href="#"><span>북마크회원</span></a>
		<a href="#"><span>검색</span></a> 
	</div>
</div>
</body>
</html>