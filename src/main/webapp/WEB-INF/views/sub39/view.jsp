<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="jakarta.tags.core" %><!-- 태그이용을 위한 링크 -->
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> <!-- spring security 라이브러리를 사용하기위한 태그 -->
    <%@ taglib prefix="t" tagdir="/WEB-INF/tags"%><!-- 내가 만든 태그 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"><!-- 부트 스트랩 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" /><!--fontawsome-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous"><!-- 부트 스트랩 -->
<title>Insert title here</title>
</head>
<body>

<h1>jquery ajax, 응답 후 실행되는 함수들 연습</h1>
<button id="btn1">btn1 실행</button>
<br/>

<button id="btn2">btn2 실패되는 버튼 실행</button>
<br/>

<button id="btn3">btn3 성공 응답(200)</button>
<br/>

<button id="btn4">btn4 실패 응답(500)</button>
<br/>

<button id="btn6">btn6 done,fail,always</button>
<br/>

<button id="btn7">btn7 done,fail,always</button>
<br/>

<button id="btn8">btn8 done,fail,always</button>
<br/>

<button id="mybutton">mybutton</button>
<br/>

<button id="btn9">btn9 본문이 있는 성공 응답</button>
<br/>

<button id="btn10">btn10 본문이 있는 성공 응답</button>
<br/>

<button id="btn11">btn11</button>
<div id="res11"></div>
<br/>


<button id="btn12">btn12</button>
<div id="res12"></div>
<br/>

<button id="btn13">btn13</button>
<div id="res13"><ul></ul></div>
<br/>
	<div>
		<input type="text" id="categoryIdInput" value="1" />
		<button id="btn14">객체 응답</button>
		<div>
			<div id="res14"></div>
		</div>
	</div>
	<div>
		<button id="btn15">btn15객체 응답, 테이블로 보여주기</button>
		<div>
			<div id="res15"></div>
		</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script><!-- 부트 스트랩 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script><!--jquery-->

<script src="/js/sub39/ajax.js"></script>
</body>
</html>