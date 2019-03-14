<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>	    
<!DOCTYPE html>
<html>
<head>
<title>회원정보</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
  <h2>회원정보</h2>
  	<div class="box-body">
		<select name="searchType">
			<option value="n">---</option>
			<option value="u" ${cri.searchType == 'u' ? 'selected':''}>아이디</option>
			<option value="v" ${cri.searchType == 'v' ? 'selected':''}>이름</option>				
		</select>
		<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }">
		<button id="btnSearch">찾기</button>
		<button id="btnNew">새로고침</button>
	</div>  
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="userVO" items="${list }">
      	<tr>
      		<td>${userVO.userid }</td>
      		<td><a href="${pageContext.request.contextPath}/member/mRead?userid=${userVO.userid}">${userVO.username }</a></td>
      		<td>${userVO.email }</td>
      		<td>${userVO.tel }</td>
      	</tr>
      </c:forEach>                 
    </tbody>
  </table>
  <div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
					<li><a href="${pageContext.request.contextPath }/member/mListAll?page=${pageMaker.startPage-1}">&laquo;</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li ${pageMaker.cri.page == idx ? 'class="active"':''  }>
						<a href="${pageContext.request.contextPath }/member/mListAll?page=${idx}&searchType=${cri.searchType}&keyword=${cri.keyword}">${idx}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next}">
					<li><a href="${pageContext.request.contextPath }/member/mListAll?page=${pageMaker.endPage+1}">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
</div>
<script>
$("#btnSearch").click(function(){
	var searchType = $("select[name='searchType']").val();
	var keyword = $("#keywordInput").val();
	location.href="${pageContext.request.contextPath}/member/mListAll?searchType="
			+searchType+"&keyword="+keyword;
	})
$("#btnNew").click(function(){
	location.href="${pageContext.request.contextPath}/member/mListAll"
})	
</script>
<%@ include file="../include/footer.jsp" %>	
</body>
</html>