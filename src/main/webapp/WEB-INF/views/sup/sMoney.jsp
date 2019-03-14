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
 	 <c:if test="${login.admin == true}">
 	 	<h2>후원 조회</h2>
 	 </c:if>
 	 <c:if test="${login.admin == false }">
 	 	<h3>My 후원</h3>
 	 </c:if>
    <div class="box-body">
		<c:if test="${login.admin == true }">
		<select name="searchType">
			<option value="n">---</option>
			<option value="u" ${cri.searchType == 'u' ? 'selected':''}>아이디</option>
			<option value="dg" ${cri.searchType == 'dg' ? 'selected':''}>후원형태</option>
			<option value="vt" ${cri.searchType == 'vt' ? 'selected':''}>후원날짜</option>			
		</select>
		<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }">		
			<button id="btnSearch">찾기</button>
			<button id="btnNew">초기화</button>
		</c:if>		
	</div>	
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>후원형태</th>
        <th>금액</th>
        <th>은행명</th>
        <th>후원날짜</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
      	<c:forEach var="mVol" items="${list }" >
      	<tr>
      		<c:if test="${mVol.vgroup == true }">
      		<td>${mVol.userid }</td>
      		<td>${mVol.dgroup }</td>
      		<td>${mVol.dmoney }</td>
      		<td>${mVol.dmode }</td>
      		<td>${mVol.vtime }</td>
      		<td>${mVol.tel }</td>
      		</c:if>
      	</tr>
      	</c:forEach>               
    </tbody>
  </table>
  <div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
					<li><a href="${pageContext.request.contextPath }/sup/sMoney?page=${pageMaker.startPage-1}">&laquo;</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li ${pageMaker.cri.page == idx ? 'class="active"':''  }>
						<a href="${pageContext.request.contextPath }/sup/sMoney?page=${idx}&searchType=${cri.searchType}&keyword=${cri.keyword}">${idx}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next}">
					<li><a href="${pageContext.request.contextPath }/sup/sMoney?page=${pageMaker.endPage+1}">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
</div>
<script>
$("#btnSearch").click(function(){
	var searchType = $("select[name='searchType']").val();
	var keyword = $("#keywordInput").val();
	location.href="${pageContext.request.contextPath}/sup/sMoney?searchType="
			+searchType+"&keyword="+keyword;
	})
$("#btnNew").click(function(){
	location.href="${pageContext.request.contextPath}/sup/sMoney"
})	
</script>
<%@ include file="../include/footer.jsp" %>
</body>
</html>