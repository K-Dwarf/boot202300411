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
<h1>ajax 응답 연습</h1>
<div>
<button id = "btn1">button</button>
<br/>
</div>
<div>
<button id = "btn2">button</button>
<br/>
</div>

<div>
<button id = "btn3">button</button>
<br/>
</div>


<div>
<button id = "btn4">button</button>
<br/>
</div>

<div>
<button id = "btn5">button</button>
<br/>
</div>
<div>
<button id = "btn6">button</button>
<br/>
</div>

<div>
<button id = "btn7">button</button>
<br/>
</div>

<div>
<button id = "btn8">button</button>
<br/>
</div>

<div>
<button id = "btn9">button</button>
<br/>
</div>

<div>
<button id = "btn10">button</button>
<br/>
</div>
<div>
<button id = "btn11">button</button>
<br/>
</div>
<div>
<button id = "btn12">button</button>
<br/>
</div>

<div>
<button id = "btn13">응답 본문 json{"adress":"seoul","price":3.14}</button>
<br/>
</div>

<button id = "btn14">button14</button>
<br/>

<button id = "btn15">button15</button>
<br/>

<button id = "btn16">button16</button>
<br/>
<button id = "btn17">button17</button>
<br/>
<button id = "btn18">button18</button>
<br/>

<button id = "btn19">button19</button>
<br/>

<button id = "btn20">button20</button>
<br/>

	<div>
		<button id="btn21">응답 본문 json from db</button>
	</div>
	
	<hr />
		<input type="number" id="categoryIdInput" value="1" />
		<button id="btn22">응답 본문 json from db</button>
		<ul id="productList">
		
		</ul>
	<hr />




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script><!-- 부트 스트랩 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script><!--jquery-->
<script src="/js/sub37/response1.js"></script>
</body>
</html>