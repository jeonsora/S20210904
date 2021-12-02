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
<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
		function memberDelete(Vuser_id){
			 console.log(Vuser_id);
			$.ajax({
				url:"memberDel",  
				data:{user_id : Vuser_id},
				dataType:'Json',
				success:function(data){     
					location.reload();
				}
			});

		}
</script>
</head>
<body>
	<div class="body">

		<div class="nav">
			<div class="alram">
				<span class="alram_btn"> <img src="#"><a href="boardMenu">미답변</a>&nbsp;&nbsp;
										 <img src="#"><a href="companyMenu">미승인</a>
				</span>
			</div>
			<div class=navBtn>
				<a href="#" class="logo"><img src="img/ds/logo.png" width="100%" height="50px"></a>
				<hr class="line"> 
				<a href="AdminMain"><span>대시보드</span></a>
				<hr class="line">
				<a href="memberMenu"><span>회원관리</span></a>
				<hr class="line">
				<a href="companyMenu"><span>기업관리</span></a>
				<hr class="line">
			 	<a href="tagMenu"><span>태그관리</span></a>
			 	<hr class="line">
			 	<a href="boardMenu"><span>게시판관리</span></a>
			 </div>
		</div>
		<div id="memberListbox" class="memberListbox" >
				<span class="subject">회원관리</span>
				<form action="memberSearch">
					<span class="search"><input type="text" class="searchTxt"><input type="submit" value="검색" class="searchBtn"></span>
				</form>
				<table class="memberList">
					<tr class="title">
						<th >아이디</th><th>이름</th><th></th>
					</tr>
					<c:if test="${mtotCnt==0 }">
						<tr><td>회원목록이 비어있어욤</td></tr>
					</c:if>
					<c:if test="${mtotCnt > 0 }">
						<c:forEach var="usList" items="${userList}">
							<tr>
								<td>${usList.user_id}</td><td>${usList.user_name}</td><td><input type="button" value="삭제" onclick="memberDelete('${usList.user_id}')"></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<ul class="pageBtn">
					<li><c:if test="${pg.startPage > pg.pageBlock }">
						<a href="memberMenu?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a></c:if>
					</li>
					<li><c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
						<a href="memberMenu?currentPage=${i}">[${i}]</a></c:forEach>
					</li>
					<li><c:if test="${pg.endPage < pg.totalPage }">
						<a href="memberMenu?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a></c:if>
					</li>
				</ul>

		</div>
	</div>
</body>
</html>