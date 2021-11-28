<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
 	
<!DOCTYPE html>
<html>
<head>
<link href="css/dj/annoWriteForm.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/reset.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>공고작성</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function buttontoggle(){
		
		var t = document.getElementById("pay_info")
		
		if(parseInt(t.value) >= 0){
			t.value = '-1'
				pay_info.disabled = true;
	
		}else if(parseInt(t.value) < 0){
			t.value = '0'
			
				pay_info.disabled = false;
		}
	}
	
	function addMonth(){
/* 		var anno_regdate =  $('#anno_regdate').val();
		var anno_regdate3 = new Date(anno_regdate);
		var anno_c_regdate = new Date(anno_regdate3.setMonth(anno_regdate3.getMonth() + 1));	// 한달 후

		alert('anno_c_regdate->'+anno_c_regdate);
		$('[name="anno_c_regdate"]').val(anno_c_regdate);
 */
		 var regdate = document.getElementById("regdate").value;
		  console.log(regdate);
		  var c = new Date(regdate);
		  console.log(c);
		  var c_regdate = new Date(c.setMonth(c.getMonth() + 1));
		  console.log(c_regdate);
		  document.getElementById("c_regdate").valueAsDate = c_regdate;	
 
		 var regdateValidate = document.getElementById("c_regdate").value;
			alert('regdateValidate->'+regdateValidate);

 
 
	}

</script>
</head>
<body>
<div class="Container">
	<div class="MyContainer">
		<%@ include file ="header.jsp" %>
		<br><br>
		
		<div class="annoWrite_title">공고 작성하기</div><p>
		
		<form action="DjAnnoWriting" method="post">
				<div class="titleContainer">
					<input type="text" class="anno_title_insert" name="anno_title" placeholder="공고 제목을 입력하세요." required="required">
				</div>
		
				<hr size="5px">
		
				<div class="compInfoContainer">
					<div class="bigTitle_anno">회사 정보</div>
		<!--  
					<div class="middleTitle_anno"> <label for="compname1">회사명</label></div>  
					 -->
					<input type="hidden" name="com_id" value="${compInfo.com_id}">
					<input type="hidden" name="com_name" value="${compInfo.com_name}">
					<input type="hidden" name="com_bus" value="${compInfo.com_bus}">
				<!--	<input class="textsquare1"
						type="text" name="com_name" id="compname1" value="${compInfo.com_name}"><p>
		
						<div class="middleTitle_anno"><label for="compcont2">주요사업내용</label></div>
						<input class="textsquare1"
							type="text" name="com_bus" id="compcont2" value="${compInfo.com_bus}"><p>
				 -->
		
		
		
						<div>
						<div class="middleTitle_anno">회사명 </div><div class="anno1_ctx">${compInfo.com_name}</div>
						</div> <p>
						<div>
						<div class="middleTitle_anno">주요 사업 내용</div> <div class="combus_ctx" >${compInfo.com_bus}</div>
						</div><p>
		
		
						<%-- <label for="complogo1" >회사 로고</label>
						<input class="textsquare1" id ="complogo1" value="${}"> <p> --%>
		
						<div>
						<div class="middleTitle_anno_text"><label for="compimg3">회사 이미지</label></div>
						<input class="imagesquare1" name="com_img" type="image" src="${compInfo.com_img}" alt="이미지 없음" 
						onerror="this.src='/img/dj/no_Image.gif'" id="compimg3" value="${compInfo.com_img}">
						</div><p>
		
						<div>
						<div class="middleTitle_anno">회사 주소</div> 
						<input class="textsquare1" type="text" name="com_addr" id="compaddr1" value="${compInfo.com_addr}">
						</div><p>
				</div>
				
				<hr size="5px">
			
				<div class="annoWriteContainer">
					<div class="bigTitle_anno">모집 내용</div>
					<div>
						<div class="middleTitle_anno"><label for="annoJob1">모집 직종</label></div> 
						<select name="job_tag" id="annoJob1">
							<c:forEach var="jobTech1" items="${jobTech1}">
										<option value="${jobTech1.sub_cat}">${jobTech1.comm_ctx}</option>				
							</c:forEach>
						</select> <p>
						
						
						<div>
						<div class="middleTitle_anno"> 고용 형태</div>
							<input type="radio" id="one" name="emp_type" value="1" checked="checked"> 정규직
							<input type="radio" id="two" name="emp_type" value="2" > 계약직
							<input type="radio" id="three" name="emp_type" value="3" > 파견직
							<p>
						
						</div>
				
						<div class="middleTitle_anno"><label for="recVol1">모집 인원</label></div> 
						<input type="text" name="rec_vol" required="required">명 <p>
						
						<div class="middleTitle_anno">기술 스택1</div> 
						<select name="tech_tag1">
							<c:forEach var="jobTech2" items="${jobTech2}" >
									
										<option value="${jobTech2.sub_cat}">${jobTech2.comm_ctx}</option>
												
							</c:forEach>
						</select> <p>
						
						<div class="middleTitle_anno">기술 스택2</div> 
						<select name="tech_tag2">
							<c:forEach var="jobTech2" items="${jobTech2}" >
									
										<option value="${jobTech2.sub_cat}">${jobTech2.comm_ctx}</option>
												
							</c:forEach>
						</select> <p>
						
						<div class="middleTitle_anno"><label for="annoteck1">학력 사항</label></div> 
						<select name="rec_edu">
							<c:forEach var="recEdu" items="${recEdu}" >
									
										<option value="rec_edu">${recEdu.comm_ctx}</option>
												
							</c:forEach>
						</select> <p>
						
						<div>
							<div class="middleTitle_anno">경력 </div>
							<input type="radio" id="one11" name="career" value="1" checked="checked"> 신입
							<input type="radio" id="two22" name="career" value="2" > 경력직(연차무관)
							<input type="radio" id="three33" name="career" value="3" > 경력무관
							<input type="radio" id="four44" name="career" value="4" > 3년 이상
							<input type="radio" id="five55" name="career" value="5" > 5년 이상
							<input type="radio" id="six66" name="career" value="6" > 10년 이상
							<p>
						</div>
						
						<div>
							<div class="middleTitle_anno_text">모집 상세 </div>
							<textarea name = "rec_dtl" rows="40" cols="50" ></textarea>
						</div><p>
					
					</div>	
				</div>
				
				<hr size="5px">
				
				<div class="annoCondContainer">
					<div class="bigTitle_anno">근무 조건</div>
						<div>
							<div class="middleTitle_anno"> 급여정보 </div>
							<input type="number" name="pay_info" id="pay_info"  value='0' > 원			
							<button type="button" id="salButton" onclick="buttontoggle();" >급여협의</button>
							
						</div><p>
					
					<div>
							<div class="middleTitle_anno_text">상세 근무 조건 </div>
							<textarea name = "work_cdt" rows="30" cols="50" required="required"></textarea>
					</div><p>
					
					<div>
							<div class="middleTitle_anno_text">기타 입력 사항 </div>
							<textarea name = "etc_cdt" rows="40" cols="50" ></textarea>
					</div><p>
					
				</div>
				
				<hr size="5px">
				
				<div class="annoOptContainer">
					<div class="bigTitle_anno">공고 설정</div>
						<div class="middleTitle_anno">공고 시작일</div>
						
						<input type="date" id="regdate" value="anno_regdate" name="anno_regdate" required="required" onchange="addMonth();">
						
 						<input type="date" class="input_anno_c_regdate"  name="anno_c_regdate" id="c_regdate" >
 				
					
				</div>
				
				<hr size="5px">
				
				<button type="submit" name="gobut" class="gobut"> 공고 작성 완료하기 </button>
				
		</form>			
		
		<br><br>
		<%@ include file ="footer.jsp" %>		
		<br><br>
	</div>
</div>	
</body>
</html>