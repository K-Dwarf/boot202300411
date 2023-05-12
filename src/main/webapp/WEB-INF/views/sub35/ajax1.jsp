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

<h5>ajax 요청 연습 post</h5>



<div>
<button id="button1">post 요청</button>
</div>

<div>
<button id="button2">post 요청</button>
</div>


<div>
<button id="button3">post 요청</button>
</div>

<div>
<button id="button4">post 요청</button>
</div>

<div>
<button id="button5">post 요청</button>
</div>

<div>
<button id="button6">post 요청</button>
</div>


<div>
<button id="button7">7번 json 형식데이터 보냄</button>
</div>


<div>
<button id="button8">8번 json 형식데이터 연습</button>
</div>


<div>
<button id="button9">9번 json 형식데이터 연습</button>
</div>

<div>
		<button id="button10">null 값의 json 데이터 전송</button>
	</div>
	<div>
		<button id="button11">객체 값을 가진 json 데이터 전송</button>
	</div>
	<div>
		<button id="button12">배열 값을 가진 json 데이터 전송</button>
	</div>
	<div>
		<button id="button13">배열 값을 가진 json 데이터 전송</button>
	</div>
		<div>
		<button id="button14">배열 값을 가진 json 데이터 전송</button>
	</div>
	
	


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script><!-- 부트 스트랩 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script><!--jquery-->

<script src="/js/sub35/ajax.js"></script>

</body>
</html>