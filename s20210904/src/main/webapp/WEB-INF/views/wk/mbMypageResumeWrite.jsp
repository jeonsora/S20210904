<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="temp01.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<script type="text/javascript">
	var car_code_num=0;
	var addResAppend="";
	$(document).ready( function() {
    	$(document).on("click", "#addResumeDetail", function() {
      		
      		addResAppend="회사명 <input type='text' name='com_name_ar[]' placeholder ='회사명을 입력해주세요'><br>"
						+"근무기간  <input type='date' name='emp_date1_ar[]'> - <input type='date' name='emp_date2_ar[]'><br>"
						+"근무부서 <input type='text' name='emp_dept_ar[]' placeholder ='부서명을 입력해주세요'><br>"
						+"담당업무 <input type='text' name='task_ar[]' placeholder ='담당한 업무를 입력해주세요'><p>"
						+"<input type='hidden' name='car_code_ar[]' value='"+car_code_num+"'><p>";
      		$("#resumeDetail").append(addResAppend);
      		car_code_num+=1;
    	});
  	});
	
</script>

</head>
<body>
<h1>이력서작성</h1>
<form action="mbMypageResumeWritePro" method="post">
	<input type="hidden" value="${mbid }" name="user_id">

	이력서 제목 <input type="text" name="res_title" placeholder ="이력서제목을 입력해주세요" required="required"><p>
	이름 : ${memberdetail.user_name }<br>
	전화번호 : ${memberdetail.user_tel }<br>
	주소 : ${memberdetail.user_addr }<p>

	이메일 : <input type="text" name="res_email" value="${memberdetail.user_email }"><p>
	
	자기소개<br>
	<textarea rows="10" cols="40" name="cov_let"></textarea><p>
	
	학력사항<br>
	<c:if test="${memberdetail.user_edu >= 2 }">
		&nbsp;&nbsp;고등학교<br>
		학교명 <input type="text" name="hs_name" placeholder ="고등학교명을 입력해주세요"><br>
		전공계열 
		<select name="hs_mjr">
			<c:forEach var="commlist" items="${commlist }">
				<option value="${commlist.sub_cat }">${commlist.comm_ctx }</option>
			</c:forEach>
		</select> 
		<p>
	</c:if>
	<c:if test="${memberdetail.user_edu >= 3 }">
		&nbsp;&nbsp;대학교, 대학원<br>
		학교명 <input type="text" name="univ_name" placeholder ="대학교명을 입력해주세요"><br>
		재학기간 <br>
		전공 <input type="text" name="univ_mjr" placeholder ="전공명을 입력해주세요"><p>
	</c:if>
	
	<p>
	경력사항 
	<div id="resumeDetail"></div>
	<input type="button" value="+추가 생성" id="addResumeDetail" onclick="addResumeDetail"><br>
	
	
	<input type="submit" value="작성완료">
</form>

</body>
</html>