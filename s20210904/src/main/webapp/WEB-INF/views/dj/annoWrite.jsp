<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고작성</title>
<script type="text/javascript">


</script>
</head>
<body>
<h1>(웰)공고작성페이지(컴)</h1>

		<div class="compInfoContainer">
			<div class="compInfoTitle">회사 정보</div>

			<label for="compname1">회사명</label> <input class="textsquare1"
				type="text" id="compname1" value="${compInfo.com_name}"><p>

				<label for="compcont1">주요사업내용</label> <input class="textsquare1"
					type="text" id="compcont1" value="${compInfo.com_bus}"><p>

				<%-- <label for="complogo1" >회사 로고</label>
				<input class="textsquare1" id ="complogo1" value="${}"> <p> --%>

				<label for="compimg1">회사 이미지</label> 
				<input class="textsquare1" type="image" src="${compInfo.com_img}" alt="이미지 없음" 
				onerror="this.src='\img\dj\no_Image.gif'" id="compimg1" value="${compInfo.com_img}"><p>

				<label for="compaddr1">회사 주소</label> 
				<input class="textsquare1" type="text" id="compaddr1" value="${compInfo.com_addr}"><p>
		</div>
	
	
		<div class="annoWriteContainer">
			<div class="annoCont1">모집 내용</div>
			<div>
				<label for="annoJob1">모집 직종</label> 
				<select name="jobselect1">
					<c:forEach var="jobTech1" items="${jobTech1}">
							
								<option value="job_tag">${jobTech1.comm_ctx}</option>
										
					</c:forEach>
				</select> <p>
				
				<label for="annoteck1">기술 스택1</label> 
				<select name="teckselect1">
					<c:forEach var="jobTech2" items="${jobTech2}" >
							
								<option value="teck_tag1">${jobTech2.comm_ctx}</option>
										
					</c:forEach>
				</select> <p>
				
				<label for="annoteck2">기술 스택2</label> 
				<select name="teckselect2">
					<c:forEach var="jobTech2" items="${jobTech2}" >
							
								<option value="teck_tag2">${jobTech2.comm_ctx}</option>
										
					</c:forEach>
				</select> <p>
			
			</div>
		</div>
		
		<div class="annoOptContainer">
		
		</div>	
		
	
</body>
</html>