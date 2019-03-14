<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.content{
		width:70%;
		margin:0 auto;	
	}

</style>
<body>
<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header with-border">
				<h3 class="box-title">자유게시판</h3>
			</div>
			<div class="box-body">
				<select name="searchType">
					<option value="n">---</option>
					<option value="t" ${cri.searchType == 't' ? 'selected':''}>제목</option>
					<option value="c" ${cri.searchType == 'c' ? 'selected':''}>내용</option>
					<option value="w" ${cri.searchType == 'w' ? 'selected':''}>작성자</option>
					<option value="tc" ${cri.searchType == 'tc' ? 'selected':''}>제목 + 내용</option>
					<option value="cw" ${cri.searchType == 'cw' ? 'selected':''}>제목 + 작성자</option>
					<option value="tcw" ${cri.searchType == 'tcw' ? 'selected':''}>제목 + 내용 + 작성자</option>				
				</select>
				<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }">
				<button id="btnSearch">찾기</button>
				<button id="btnNewBoard">게시글쓰기</button>
			</div>
		</div>					  
		<div class="box">
		<div class="box-body">
		<table class="table">
    <thead>
      <tr>
        <th>번호</th>
        <th>종류</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="fboardVO" items="${list }">
      	<tr>
      		<td>${fboardVO.fbno }</td>
      		<c:if test="${fboardVO.fgroup == true }">
      			<td><b>[공지]</b></td>
      		</c:if>
      		<c:if test="${fboardVO.fgroup == false }">
      			<td>[자유]</td>
      		</c:if>
      		<td><a href="${pageContext.request.contextPath }/fboard/freadPage?fbno=${fboardVO.fbno }&page=${pageMaker.cri.page}">${fboardVO.ftitle }</a>
      			<strong>[${fboardVO.freplycnt }]</strong>
      		</td>
      		<td>${fboardVO.userid }</td>
      		<td><fmt:formatDate value="${fboardVO.fregdate }" pattern="yyyy-MM-dd" type="date" dateStyle="short"></fmt:formatDate></td>
      		<td>${fboardVO.fviewcnt }</td>
      	</tr>
      </c:forEach>
    </tbody>
  	</table>
	</div>
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
					<li><a href="${pageContext.request.contextPath }/fboard/flist?page=${pageMaker.startPage-1}">&laquo;</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li ${pageMaker.cri.page == idx ? 'class="active"':''  }>
						<a href="${pageContext.request.contextPath }/fboard/flist?page=${idx}&searchType=${cri.searchType}&keyword=${cri.keyword}">${idx}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next}">
					<li><a href="${pageContext.request.contextPath }/fboard/flist?page=${pageMaker.endPage+1}">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		</div>
		</div>
	</div>
</section>
<script>
	$(function(){
		$("#btnSearch").click(function(){
			var searchType = $("select[name='searchType']").val();
			var keyword = $("#keywordInput").val();
			location.href="${pageContext.request.contextPath}/fboard/flist?searchType="
					+searchType+"&keyword="+keyword;
		})
		$("#btnNewBoard").click(function(){
			location.href ="${pageContext.request.contextPath}/fboard/fregister";
		})
	})

</script>
<%@ include file="../include/footer.jsp" %>
</body>
</html>