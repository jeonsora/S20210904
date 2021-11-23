<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/ds/admin.css" type="text/css">
<link rel="stylesheet" href="css/reset.css" type="text/css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>

<!-- 기업 승인 ajax  -->
<script type="text/javascript">
		function joinConfirm(com_id){
			 console.log(com_id);
			$.ajax({
				url:"<%=context%>/joinConfirm",  
				data:{comId : com_id},
				dataType:'text',
				success:function(data){     
					$(".comConfirm").load(window.location.href+" .confirmContext"); 
				}
			});

		}
</script>
</head>
<body>
	<div class="body">

		<div class="nav">
			<div class="alram">
				<span class="alram_btn"> <img src="#"><a href="#">미답변</a>&nbsp;&nbsp;
					<img src="#"><a href="#">미승인</a>
				</span>
			</div>
			<a href="#" class="logo"><img src="img/ds/logo.png" width="100%"
				height="50px"></a> <a href="#"><span>대시보드</span></a> <a href="#"><span>회원관리</span></a>
			<a href="#"><span>기업관리</span></a> <a href="#"><span>태그관리</span></a> <a
				href="#"><span>게시판관리</span></a>
		</div>
		<div class="adminBoard">
			<div id="box1">
				<div class="QnA">
					<ul>
						<li>QnA</li>
						<li><a href="#">>더보기</a></li>
					</ul>
					<table class="QnAlist">
						<tr>
							<th class="title">QnA</th>
						</tr>
						<c:if test="${qtotCnt == 0 }">
							<tr>
								<td>대기중인 질문이 없어요</td>
							</tr>
						</c:if>
						<c:if test="${qtotCnt > 0 }">
							<c:forEach var="qnaList" items="${qnaList}"
								varStatus="status">
								<c:if test="${status.index < 5 }">
									<tr>
										<td class="waitItem">${qnaList.post_title}<input
											type="button" value="답변하기" class="answerBtn" name="answerBtn"
											onclick="answerWrite('${qnaList.post_code}')">
										</td>
									</tr>
								</c:if>
							</c:forEach>
					</c:if>
					</table>
				</div>
			</div>
			<div id="box1" class="board">
				<ul>
					<li>기술별 공고갯수</li>
					<li><a href="#">>더보기</a></li>
				</ul>
				<canvas class="myChart" style="height: 20vh; width: 50vw;"></canvas>
			</div>
			<div id="box1" class="comConfirm">
				<div class="confirmContext">
				<ul>
					<li>기업승인현황</li>
					<li><a href="#">>더보기</a></li>
				</ul>
				<table class="QnAlist">
					<tr>
						<th class="title">기업명</th>
					</tr>
					<c:if test="${totCnt == 0 }">
						<tr>
							<td>대기중인 기업이 없어요</td>
						</tr>
					</c:if>
					<c:if test="${totCnt > 0 }">
						<c:forEach var="waitComList" items="${waitComList}"
							varStatus="status">
							<c:if test="${status.index < 5 }">
								<tr>
									<td class="waitItem">${waitComList.com_name}<input
										type="button" value="확인" class="confirmBtn" name="confirmBtn"
										onclick="joinConfirm('${waitComList.com_id}')"> <input
										type="button" value="취소" name="joinCancle">
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:if>
				</table>
				</div>
			</div>
			<div id="box1">
				<ul>
					<li>공고현황</li>
					<li><a href="#">>더보기</a></li>
				</ul>
				<table class="QnAlist">
					<tr>
						<th class="title">공고명</th>
					</tr>
					<c:forEach var="i" begin="0" end="4">
						<tr>
							<td>중앙테크로오세요</td>
						</tr>
					</c:forEach>
					<c:forEach var="QnAList" items="${QnAList}" varStatus="status">
						<c:if test="${stauts.index < 5 }">
							<tr>
								<td>${QnAList.title}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

	<!-- 	<script type="text/javascript">
            var context = document
                .getElementById('myChart')
                .getContext('2d');
            var myChart = new Chart(context, {
                type: 'bar', // 차트의 형태
                data: { // 차트에 들어갈 데이터
                    labels: [
                        //x 축
                        '1','2','3','4','5','6','7'
                    ],
                    datasets: [
                        { //데이터
                            label: '공고갯수', //차트 제목
                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                            data: [
                                21,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
                            ],
                            backgroundColor: [
                                //색상
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                //경계선 색상
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1 //경계선 굵기
                        }/* ,
                        {
                            label: 'test2',
                            fill: false,
                            data: [
                                8, 34, 12, 24
                            ],
                            backgroundColor: 'rgb(157, 109, 12)',
                            borderColor: 'rgb(157, 109, 12)'
                        } */
                    ]
                },
                responsive: false,
                options: {
                    scales: {
                        yAxes: [
                            {
                                ticks: {
                                    beginAtZero: true
                                }
                            }
                        ]
                    }
                }
            });
        </script> -->
</body>
</html>