<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String context = request.getContextPath();
%>
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
		function companyDetail(Vcom_id){
			 console.log(Vcom_id);
			$.ajax({
				url:"<%=context%>/comDetail",  
				data:{com_id : Vcom_id},
				dataType:'Json',
				success:function(data){     
					$(".comId").html(data.com_id);
					$(".comAddr").html(data.com_addr);
					$(".comEmail").html(data.com_email);
					$(".comHome").html(data.com_web);
					$(".comNum").html(data.com_tel);
					$(".comPhone").html(data.com_mgr_tel);
				}
			});

		}
</script>
<script type="text/javascript">
		function joinConfirm(com_id){
			 console.log(com_id);
			$.ajax({
				url:"<%=context%>/joinConfirm",  
				data:{comId : com_id},
				dataType:'text',
				success:function(data){     
					location.reload();
				}
			});

		}
</script>
<script type="text/javascript">
		function joinRefuse(com_id){
			 console.log(com_id);
			$.ajax({
				url:"<%=context%>/joinRefuse",  
				data:{comId : com_id},
				dataType:'text',
				success:function(data){     
					location.reload();
				}
			});

		}
</script>
<script type="text/javascript">
		function companyDel(com_id){
			 console.log(com_id);
			$.ajax({
				url:"<%=context%>/companyDel",  
				data:{comId : com_id},
				dataType:'text',
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
		<div id="companyListbox" class="companyListbox" >
			<div class="companyList">
				<span class="subject">기업관리</span>
				<span class="search"><input type="text" class="searchTxt"><input type="button" value="검색" class="searchBtn"></span>
				<table class="memberList">
					<tr class="title">
						<th >아이디</th><th>기업명</th><th></th>
					</tr>
					<c:if test="${ctotCnt==0 }">
						<tr><td colspan="3">기업목록이 비어있어욤</td></tr>
					</c:if>
					<c:if test="${ctotCnt > 0 }">
						<c:forEach var="comList" items="${companyList}">
							<tr>
								<td onmouseover="companyDetail('${comList.com_id}')">${comList.com_id}</td><td>${comList.com_name}</td><td><input type="button" value="삭제" onclick="companyDel('${comList.com_id}')"></td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<ul class="pageBtn">
					<li><c:if test="${pg.startPage > pg.pageBlock }">
						<a href="companyMenu?currentPage=${pg.startPage-pg.pageBlock}&currentPage2=${pg2.currentPage}">[이전]</a></c:if>
					</li>
					<li><c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
						<a href="companyMenu?currentPage=${i}&currentPage2=${pg2.currentPage}">[${i}]</a></c:forEach>
					</li>
					<li><c:if test="${pg.endPage < pg.totalPage }">
						<a href="companyMenu?currentPage=${pg.startPage+pg.pageBlock}&currentPage2=${pg2.currentPage}">[다음]</a></c:if>
					</li>
				</ul>
			</div>
			<div class="companyConfirmList">
					<span class="subject">가입승인</span>
					<span class="search"><input type="text" class="searchTxt" ><input type="button" value="검색" class="searchBtn"></span>
					<table class="memberList">
						<tr class="title">
							<th >아이디</th><th>기업명</th><th></th>
						</tr>
						<c:if test="${cctotCnt==0 }">
							<tr><td colspan="3">기업목록이 비어있어욤</td></tr>
						</c:if>
						<c:if test="${cctotCnt > 0 }">
							<c:forEach var="comConfirmList" items="${companyConfirmList}">
								<tr>
									<td onmouseover="companyDetail('${comConfirmList.com_id}')">${comConfirmList.com_id}</td><td>${comConfirmList.com_name}</td>
									<td><input type="button" value="승인" onclick="joinConfirm('${comConfirmList.com_id}')"><input type="button" value="거절" onclick="joinRefuse('${comConfirmList.com_id}')"></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					<ul class="pageBtn">
						<li><c:if test="${pg2.startPage > pg2.pageBlock }">
							<a href="companyMenu?currentPage2=${pg2.startPage-pg2.pageBlock}&currentPage=${pg.currentPage}">[이전]</a></c:if>
						</li>
						<li><c:forEach var="i" begin="${pg2.startPage}" end="${pg2.endPage}">
							<a href="companyMenu?currentPage2=${i}&currentPage=${pg.currentPage}">[${i}]</a></c:forEach>
						</li>
						<li><c:if test="${pg2.endPage < pg2.totalPage }">
							<a href="companyMenu?currentPage2=${pg2.startPage+pg2.pageBlock}&currentPage=${pg.currentPage}">[다음]</a></c:if>
						</li>
					</ul>
				</div>
				<div class="companyDetail">
					<span class="subject">기업정보</span>
					<div class="content">
						<span class="contentdetail">기업명 :</span><span class="comId"></span><br>
						<span class="contentdetail">주소 :</span><span class="comAddr"></span><br>
						<span class="contentdetail">이메일 :</span><span class="comEmail"></span><br>
						<span class="contentdetail">홈페이지 :</span><span class="comHome"></span><br>
						<span class="contentdetail">회사전화번호 :</span><span class="comNum"></span><br>
						<span class="contentdetail">담담자번호 :</span><span class="comPhone"></span><br>
					</div>
					
				</div>

		</div>
	</div>
</body>
</html>