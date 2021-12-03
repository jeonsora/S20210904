<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="temp01.jsp" %>        
<!DOCTYPE html>
<%
	String context = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function resume_delete(res_code){
		if(confirm("이력서를 삭제하시겠습니까 ?") == true){
			$.ajax({
				url:"<%=context%>/mbMypageResumeDelete",
				data:{res_code : res_code},
				dataType:'text',
				success:function(data){
					if(data>0){
						alert("삭제되었습니다");
						location.replace("mbMypageResume");
					}else{
						alert("삭제 실패"+data);
					}
				},
				error:function(){
					alert("삭제에 실패하였습니다"+data);
				}
			});
		}else{
			return ;
		}
	}

/* 	function resume_update(res_code){	
		alert("11");
		var form=document.paging; 				//폼 name
	    form.res_code.value = res_code; 		//POST방식으로 넘기고 싶은 값
	    
	    form.action = "mbMypageResumeUpdate";
        form.method = "post"; 
        form.submit();
	} */




</script>

 </head>
<body>
<h1>mbMypageResume</h1><p><p>

${mbid }의 이력서<br>
<c:forEach var="resumelist" items="${resumelist}" varStatus="status">
	${status.count} &nbsp;&nbsp; ${resumelist.res_title} &nbsp;&nbsp; ${resumelist.res_date} &nbsp;&nbsp; ${resumelist.rep_res}
	&nbsp;&nbsp; ${resumelist.comm_ctx} &nbsp;&nbsp; &nbsp;&nbsp; <input type="button" value="대표이력서">
	&nbsp;&nbsp; &nbsp;&nbsp; <input type="submit" onclick="location.href='mbMypageResumeUpdate?res_code=${resumelist.res_code}'" value="수정">
	&nbsp;&nbsp; &nbsp;&nbsp; <input type="button" onclick="resume_delete(${resumelist.res_code})" value="삭제"><br>
</c:forEach><p>


</body>
</html>