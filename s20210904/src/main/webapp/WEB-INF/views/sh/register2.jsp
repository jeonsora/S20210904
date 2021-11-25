<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<form action="createSave">
		<h2>기업회원가입</h2>
			회사명: <input type="text" name="name" placeholder="이름을 입력하시오"><p>
			회사주소 : <input type="text" name="addr" placeholder="주소를 입력하시오"><p>
			사업자등록번호 : <input type="text" id="id" name="id" placeholder="사업자등록번호입력"><p>
			기업형태 : <input type="password" name="psw" placeholder="기업형태입력"><p>
			<hr class="two"><p><h3>인사담당자정보</h3>
			아이디 : <input type="text" name="id" placeholder="아이디를 입력하시오"><p>
			비밀번호 : <input type="text" name="email" placeholder="비밀번호입력"><p>
			가입자명 : <input type="text" name="name" placeholder="이름을 입력하시오"><p>
		 	전화번호 : <input type="text" name="tel" placeholder="tel입력"><p>
		 	이메일 : <input type="text" name="" placeholder="emial입력"><p>
		 <input type="submit" value="가입하기">
			
		</form>
	
	</div>
</body>
</html>