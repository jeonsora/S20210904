<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ds/admin.css" type="text/css">
<link rel="stylesheet" href="css/reset.css" type="text/css">
</head>
<body>
	<div class="body">

		<div class="nav">
			<div class="alram">
				<span class="alram_btn"> <img src="#"><a href="#">미답변</a>&nbsp;&nbsp;
					<img src="#"><a href="#">미승인</a>
				</span>
			</div>
			<a href="#" class="logo"><img src="img/ds/logo.png" width="100%" height="50px"></a> 
				<a href="AdminMain"><span>대시보드</span></a>
				<a href="memberMenu"><span>회원관리</span></a>
				<a href="companyMenu"><span>기업관리</span></a>
			 	<a href="tagMenu"><span>태그관리</span></a> 
			 	<a href="boardMenu"><span>게시판관리</span></a>
		</div>
		<div id="memberListbox" class="memberListbox" >
				<table class="memberList">
					<tr>
						<th>아이디</th><th>이름</th><th></th>
					</tr>
					<c:if test="${mtotCnt==0 }">
						<tr><td>회원목록이 비어있어욤</td></tr>
					</c:if>
					<c:if test="${mtotCnt > 0 }">
						<c:forEach var="userList" items="userList">
							<tr>
								<td>${userList.user_id }</td><td>${userList.user_name }</td><td><input type="button" value="삭제"></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
		</div>
	</div>
</body>
</html>