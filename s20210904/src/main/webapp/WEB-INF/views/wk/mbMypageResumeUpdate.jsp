<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="temp01.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>mbMypageResumeUpdate</h1><p>
<c:if test="${res_select_msg eq false }">
 없는 이력서 입니다
</c:if>

<c:if test="${res_select_msg eq true }">
	<form action="mbMypageResumeUpdatePro" method="post">
		<input type="hidden" value="${mbid }" name="user_id">
	
		이력서 제목 <input type="text" name="res_title" value="${resumedetail.res_title }" required="required"><p>
		이름 : ${memberdetail.user_name }<br>
		전화번호 : ${memberdetail.user_tel }<br>
		주소 : ${memberdetail.user_addr }<p>
	
		이메일 : <input type="text" name="res_email" value="${resumedetail.res_title }"><p>
		
		자기소개<br>
		<textarea rows="10" cols="40" name="cov_let" >${resumedetail.cov_let }</textarea><p>
		
		학력사항<br>
		<c:if test="${memberdetail.user_edu >= 2 }">
			&nbsp;&nbsp;고등학교<br>
			학교명 <input type="text" name="hs_name" value="${resumedetail.hs_name }"><br>
			전공계열 
			<select name="hs_mjr">
				<c:forEach var="commlist" items="${commlist }">
					<c:if test="${resumedetail.hs_mjr eq commlist.sub_cat }">
						<option value="${commlist.sub_cat }" selected="selected">${commlist.comm_ctx }</option>
					</c:if>
					<c:if test="${resumedetail.hs_mjr ne commlist.sub_cat }">
						<option value="${commlist.sub_cat }">${commlist.comm_ctx }</option>
					</c:if>
				</c:forEach>
			</select> 
			<p>
		</c:if>
		<c:if test="${memberdetail.user_edu >= 3 }">
			&nbsp;&nbsp;대학교, 대학원<br>
			학교명 <input type="text" name="univ_name" value="${resumedetail.univ_name }"><br>
			재학기간 <br>
			전공 <input type="text" name="univ_mjr" value="${resumedetail.univ_mjr }"><p>
		</c:if>
		
		<p>
		경력사항 
		<div id="resumeDetail"></div>
		<input type="button" value="+추가 생성" id="addResumeDetail" onclick="addResumeDetail"><br>
		
		
		<input type="submit" value="작성완료">
	</form>
</c:if>
</body>
</html>