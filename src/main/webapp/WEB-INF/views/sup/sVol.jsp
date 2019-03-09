<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
  <h2>봉사지원자 조회</h2>
  <div class="box-body">
		<select name="searchType">
			<option value="n">---</option>
			<option value="t" ${cri.searchType == 't' ? 'selected':''}>봉사시간</option>				
		</select>
		<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }">
		<button id="btnSearch">찾기</button>
		<button id="btnNewBoard">New Board</button>
	</div>  
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>봉사명</th>
        <th>시간</th>
        <th>동기</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
      	<c:forEach var="Volun" items="${list }" >
      	<tr>
      		<c:if test="${Volun.vgroup == false}">
      		<td>${Volun.userid }</td>
      		<td>${Volun.vname }</td>
      		<td>${Volun.vtime }</td>
      		<td>${Volun.vreason }</td>
      		<td>${Volun.tel }</td>
      		</c:if>
      	</tr>
      	</c:forEach>               
    </tbody>
  </table>
  <div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
					<li><a href="${pageContext.request.contextPath }/sup/sVol?page=${pageMaker.startPage-1}">&laquo;</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li ${pageMaker.cri.page == idx ? 'class="active"':''  }>
						<a href="${pageContext.request.contextPath }/sup/sVol?page=${idx}&searchType=${cri.searchType}&keyword=${cri.keyword}">${idx}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next}">
					<li><a href="${pageContext.request.contextPath }/sup/sVol?page=${pageMaker.endPage+1}">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
<script>
$("#btnSearch").click(function(){
	var searchType = $("select[name='searchType']").val();
	var keyword = $("#keywordInput").val();
	location.href="${pageContext.request.contextPath}/sup/sVol?searchType="
			+searchType+"&keyword="+keyword;
	})
</script>  
</div>
</body>
</html>