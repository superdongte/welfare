<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
	.content{
		width:60%;
		margin:0 auto;	
	}

</style>
<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header with-border">
				<h3 class="box-title">현장게시판</h3>
			</div>
			<div class="box-body">
				<select name="searchType">
					<option value="n">---</option>
					<option value="t" ${cri.searchType == 't' ? 'selected':''}>제목</option>
					<option value="c" ${cri.searchType == 'c' ? 'selected':''}>내용</option>
					<option value="w" ${cri.searchType == 'w' ? 'selected':''}>작성자</option>
					<option value="tc" ${cri.searchType == 'tc' ? 'selected':''}>제목 또는 내용</option>
					<option value="cw" ${cri.searchType == 'cw' ? 'selected':''}>내용 및 작성자</option>
					<option value="tcw" ${cri.searchType == 'tcw' ? 'selected':''}>제목 또는 내용 또는 작성자</option>				
				</select>
				<input type="text" name="keyword" id="keywordInput" value="${cri.keyword }">
				<button id="btnSearch">Search</button>
				<button id="btnNewBoard">New Board</button>
			</div>
		</div>					  
		<div class="box">
		<div class="box-body">
		<table class="table">
    <thead>
      <tr>
        <th style="width:10px;">BNO</th>
        <th>TITLE</th>
        <th>WRITER</th>
        <th>REGDATE</th>
        <th style="width:40px;">VIEWCNT</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="SboardVO" items="${list }">
      	<tr>
      		<td>${SboardVO.sbno }</td>
      		<td><a href="${pageContext.request.contextPath }/sboard/sreadPage?sbno=${SboardVO.sbno }&page=${pageMaker.cri.page}">${SboardVO.stitle }</a>
      		</td>
      		<td>${SboardVO.userid }</td>
      		<td><fmt:formatDate value="${SboardVO.sregdate }" pattern="yyyy-MM-dd" type="date" dateStyle="short"></fmt:formatDate></td>
      		<td>${SboardVO.sviewcnt }</td>
      	</tr>
      </c:forEach>
    </tbody>
  	</table>
	</div>
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
					<li><a href="${pageContext.request.contextPath }/sboard/slist?page=${pageMaker.startPage-1}">&laquo;</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li ${pageMaker.cri.page == idx ? 'class="active"':''  }>
						<a href="${pageContext.request.contextPath }/sboard/slist?page=${idx}&searchType=${cri.searchType}&keyword=${cri.keyword}">${idx}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next}">
					<li><a href="${pageContext.request.contextPath }/sboard/slist?page=${pageMaker.endPage+1}">&raquo;</a></li>
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
			location.href="${pageContext.request.contextPath}/sboard/slist?searchType="
					+searchType+"&keyword="+keyword;
		})
		$("#btnNewBoard").click(function(){
			location.href ="${pageContext.request.contextPath}/sboard/sregister";
		})
	})

</script>