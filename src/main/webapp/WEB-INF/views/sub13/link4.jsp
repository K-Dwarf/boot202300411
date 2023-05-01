<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="jakarta.tags.core" %><!-- 태그이용을 위한 링크 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"><!-- 부트 스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous"><!-- 부트 스트랩 -->
<title>Insert title here</title>
</head>
<body>

      						<!-- 직원 리스트 테이블 -->

<div class="container">
  <div class="row">
    <div class="col-sm-12">
      <h1 class="display-4 text-center">직원 목록</h1>
      <ul class="list-group text-center">
        <h1>(List Of Slave)</h1>
      </ul>
    </div>
  </div>
</div>


	<div>
		<!-- table.table>thead>tr>th*3^^tbody -->
	<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${customerList}" var="em">
            <tr>
                <td><li>${em.customerId}</li></td>
                <td>${em.customerName }</td>
                <td>${em.address }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
 								<!-- 직원 테이블 끝 -->
		</div>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
			crossorigin="anonymous"></script>
		<!-- 부트 스트랩 -->
		
		
		<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
					
				
					
			
						
							<!-- 이전 페이지  -->
				<c:if test="${prevPageNumber >= 1 }">	
				
					<li class="page-item">
				<c:url value="/sub26/link1" var="pageLink">
				<c:param name="page" value="${firstPage }"></c:param>
				</c:url>
				<a href="${pageLink }" class="page-link">첫페이지</a>
				</li>
				
				<li class="page-item">
				<c:url value="/sub26/link1" var="pageLink">
				<c:param name="page" value="${prevPageNumber }"></c:param>
				</c:url>
				<a href="${pageLink }" class="page-link">이전</a>
				</li>
				</c:if>
				
					<!-- 페이지 리스트 -->
				
				<c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="pageNumber">
					
					<!-- li.page-item>a.page-link -->
					<c:url value="/sub26/link1" var="pageLink">
						<c:param name="page" value="${pageNumber }"></c:param>
					</c:url>
					<li class="page-item">
						<a href="${pageLink }" class="page-link">${pageNumber }</a>
					</li>
				</c:forEach>
				
							<!-- Next page  -->
				<c:if test="${nextPageNumber le lastPageNumber }">			
					<li class="page-item">
				<c:url value="/sub26/link1" var="pageLink">
				<c:param name="page" value="${nextPageNumber }"></c:param>
				</c:url>
				<a href="${pageLink }" class="page-link">다음</a>
				</li>
					<li class="page-item">
				<c:url value="/sub26/link1" var="pageLink">
				<c:param name="page" value="${lastPageNumber }"></c:param>
				</c:url>
				<a href="${pageLink }" class="page-link">마지막페이지</a>
				</li>
					
				</c:if>
				
			</ul>
		</nav>
	</div>

</html>