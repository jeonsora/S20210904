<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/login";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#userId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				if($("#userName").val()==""){
					alert("성명을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
			});
			
				
			
		})
	</script>
	<body>
	
	<div class="register">
		<form action="joinSave">
		<h2>개인회원가입</h2>
			아이디 : <input type="text" id="id" name="user_id" placeholder="아이디입력"><p>
			비밀번호 : <input type="password" name="user_pw" placeholder="비밀번호입력"><p>
			이름: <input type="text" name="user_name" placeholder="이름을 입력하시오"><p>
			성별 : <input type="radio" id="male" name="user_sex" value="m">
				 <label for="male">남성</label>
				 <input type="radio" id="female" name="user_sex" value="f">
				 <label for="female">여성</label><p>
			생년월일 : <input type="text"  name="user_brh" placeholder="생년월일을 입력"><p>
			학력 : <input type="text" name="user_edu" placeholder="학력을 입력"><p>
			주소 : <input type="text" name="user_addr" placeholder="주소를 입력하시오"><p>
			번호 : <input type="text" name="user_tel" placeholder="tel입력">	<p>
			이메일 : <input type="text" name="user_email" placeholder="email입력">
				   <input type="submit" value="이메일 인증"><p>
			 		
		 <input type="submit" value="회원가입">
			
		</form>
	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- 	<section id="container">
			<form action="/user/register" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="userId">아이디</label>
				<input class="form-control" type="text" id="userId" name="userId" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userPass">패스워드</label>
					<input class="form-control" type="password" id="userPass" name="userPass" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">성명</label>
					<input class="form-control" type="text" id="userName" name="userName" />
				</div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</section> -->
</body>
</html>