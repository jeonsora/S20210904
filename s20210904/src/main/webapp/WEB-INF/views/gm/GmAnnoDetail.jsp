<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%
	String context = request.getContextPath();
%>
<head>
<meta charset="UTF-8">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/gm/GmAnnoDetail.css" rel="stylesheet" type="text/css">
<title>코딩몬</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

	/* EmpController */
	function setScrap(){
		alert("setScrap Start..");  
		anno_code = $('#anno_code').val(),
		user_id = $('#user_id').val(),
		it_like = $('#it_like').val(),
		alert("setScrap anno_code->"+ anno_code);  
		alert("setScrap user_id->"+user_id);  
		alert("setScrap it_like->"+it_like);  
	
	 	$.ajax({
			url:"<%=context%>/scrap",
			data:{"anno_code" : anno_code,
			      "user_id"   : user_id,
			      "it_like"   : it_like
			    },	/*  */
			dataType:'text',			/* 서버에서 내려온 data 형식 */
			success:function(data){		/* 요청이 성공됬을때 실행되는 callback 함수 */
				alert("success data"+data);  
				if(data == 1){
					console.log("좋아요");
					$('#likecheck').val(0);
					$('#likebtn').attr()
				}		
			}	
			
		}); 
		
	}

</script>
</head>
<body>

<%@ include file="header.jsp" %>

	<!-------------------------------------------------------------------------------------->
	<div class="detail">
	  <div class="detail_title">
		<h2>공고 상세</h2>
		  <div class="com_name">
			<tr><td>${comanno.com_name}&nbsp;&nbsp;&nbsp;
			<td>
			  <c:choose>
			    <c:when test="${itlike == 0}">
			      <input type="button" class = "btn btn_light" id="likebtn" value="스크랩 " onclick="setScrap()">
					      <input type="hidden" id="likecheck" value="${itlike}">
			    </c:when>
			    
			<%--     <c:when test="${itlike == 1}"> 
			      <input type="button" class = "btn btn_danger" id="likebtn" value="★ "></button>
			      <input type="hidden" id="likecheck" value="${itlike}">
			    </c:when> --%>
			  </c:choose>
			  
			     <input type="button" class = "btn btn_danger" id="likebtn" value="스크랩 " onclick="setScrap()">
				 <input type="button" value="관심기업등록 ♥" >
				 <input type="button" value="지원하기" onclick="location.href='GmApplyList'">
				    anno_code : <input type="text" id="anno_code"    value="1"          ><p>
				    user_id :   <input type="text" id="user_id"      value="dmdtla054"  ><p>
				    it_like :   <input type="text" id="it_like"      value="1"         ><p>
				 
			
			</td></tr>
		  </div>
			<hr>
		  <div class="com_title">
			<tr><td>${comanno.anno_title}</td></tr>
		  </div>
	 </div>	
		<table class="anno_content">
			<h3><모집 내용></h3>
			<tr><th>모집 직종</th><td>${recjob.comm_ctx}</td></tr>
			<tr><th>고용형태</th><td>${emptype.comm_ctx}</td></tr>
			<tr><th>모집인원</th><td>${comanno.rec_vol}</td></tr>
			<tr><th>기술스택1</th><td>${Techtag1.comm_ctx}</td></tr>
			<tr><th>기술스택2</th><td>${Techtag2.comm_ctx}</td></tr>
			<tr><th>학력</th><td>${comanno.rec_edu}</td></tr>
			<tr><th>경력</th><td>${career.comm_ctx}</td></tr>
			<tr><th>모집상세</th><td>${comanno.rec_dtl}</td></tr>
		</table>
	<!----------------------------------------------------------------------------------->
		<table class="anno_condition">
			<h3><근무조건></h3>
			<tr><th>급여정보</th><td>${comanno.pay_info}원</td></tr>
			<tr><th>상세근무조건</th><td>${comanno.work_cdt}</td></tr>
			<tr><th>복리후생</th><td>${comanno.etc_cdt}</td></tr>
		</table>	
	<!----------------------------------------------------------------------------------->
			
		<table class="com_info">
			<h3><기업 정보></h3>
			<tr><th>기업명</th><td>${comanno.com_name}</td></tr>
			<tr><th>기업 E-mail</th><td>${comanno.com_email}</td></tr>
			<tr><th>기업 전화번호</th><td>${comanno.com_tel}</td></tr>
			<tr><th>담당자 이름</th><td>${comanno.com_user}</td></tr>
			<tr><th>담당자 전화번호</th><td>${comanno.com_mgr_tel}</td></tr>
			<tr><th>기업 주소</th><td>${comanno.com_addr}</td></tr>
			<tr><th>업종</th><td>${comanno.com_sec}</td></tr> 
			<tr><th>사업 내용</th><td>${comanno.com_bus}</td></tr>
			<tr><th>기업 홈페이지</th><td>${comanno.com_web}</td></tr>
		</table>	
	<!----------------------------------------------------------------------------------->
		
		<table class="anno_date">
			<h3><공고 기간></h3>
			<tr><th>공고 등록일 : </th><td>${comanno.anno_regdate}</td></tr>
			<tr><th>공고 마감일 : </th><td>${comanno.anno_c_regdate}</td></tr>
		</table>	
			
			
	
	
		<!-- </table> -->
	</div>
	<!-------------------------------------------------------------------------------------->
	<br><br><br>
	<%@ include file="footer.jsp" %>
</body>
</html>