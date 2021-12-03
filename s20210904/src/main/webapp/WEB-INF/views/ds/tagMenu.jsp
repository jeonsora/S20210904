<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<%
	String context = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ds/admin.css" type="text/css">
<link rel="stylesheet" href="css/reset.css" type="text/css">
<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<script type="text/javascript">
	function modalOn() {
		document.querySelector(".modalBack").style.display="flex";
	}
	function modalOff() {
		document.querySelector(".modalBack").style.display="none";
	}
	
	function maxSubCate(VmainCate){
		$.ajax({
			url:"<%=context%>/maxSubCate",
			data:{mainCate : VmainCate},
			dataType:'text',
			success:function(data){
				alert(data+"성공");
				$('.subCate').val(data);
				$(".subCate").attr("readonly",true);
			}
		});
	}
</script>
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
				<span class="subject">태그관리</span>
				<span class="search"><input type="text" class="searchTxt"><input type="button" value="검색" class="searchBtn"></span>
				<span class="addTag"><input type="button" value="태그추가" onclick="modalOn()"></span>
				<table class="tagList">
					<tr class="title">
						<th >태그명</th><th>번호</th><th>분류</th><th></th>
					</tr>
					<c:if test="${ttotCnt==0 }">
						<tr><td>회원목록이 비어있어욤</td></tr>
					</c:if>
					<c:if test="${ttotCnt > 0 }">
						<c:forEach var="tagList" items="${dsCommList}">
							<tr>
								<td>${tagList.comm_ctx}</td><td>${tagList.sub_cat}</td><td>${tagList.comm_ctx2}</td><td><input type="button" value="삭제"></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<ul class="pageBtn">
					<li><c:if test="${pg.startPage > pg.pageBlock }">
						<a href="tagMenu?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a></c:if>
					</li>
					<li><c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
						<a href="tagMenu?currentPage=${i}">[${i}]</a></c:forEach>
					</li>
					<li><c:if test="${pg.endPage < pg.totalPage }">
						<a href="tagMenu?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a></c:if>
					</li>
				</ul>

		</div>
	</div>
	<div class="modalBack">

			<form action="tagInsert">
				<div class="modal">

					<span>대번호 					
						<select onchange="maxSubCate(this.value)">
							<c:forEach var="mainCate" items="${mainCate }">
								<option value="${mainCate.main_cat}">${mainCate.comm_ctx}</option>
							</c:forEach>
						</select>
					</span>
					<span>중번호 <input type="text" class="subCate" name="subCate" required="required"></span>
					<span>태그명 <input type="text" class="tagName" name="tagName" required="required"></span>
					<div class="modalBtn"><input type="submit" value="추가하기"><input type="button" value="취소" onclick="modalOff()"></div>
				</div>
			</form>

	</div>
</body>
</html>