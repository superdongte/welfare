<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	div.item{
		width:100px;
		float:left;
		margin:5px;
	}
	.content{
		width:70%;
		margin:0 auto;
		
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">Home Page</h3>
			</div>
					<div class="box-body">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="jtitle" class="form-control"
								placeholder="Enter Title" value="${JboardVO.jtitle}"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control"
							name="fcontent" placeholder="Enter Content" readonly="readonly">${JboardVO.jcontent }</textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${JboardVO.userid }" readonly="readonly"> 
						</div>
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary" id="btnList">GO LIST</button>
						<button type="submit" class="btn btn-warning" id="btnModify">Modify</button>
						<button type="submit" class="btn btn-danger" id="btnRemove">Remove</button>
					</div>
					
					<form id="f1" action="" method="post">
						<input type="hidden" name="jbno" value="${JboardVO.jbno }">
						<input type="hidden" name="page" value="${cri.page }">
					</form>
					
					
			</div>
		</div>
	</div>
	
</section>
	<script>
		$(function(){
			$("#btnList").click(function(){
				/* location.href = "${pageContext.request.contextPath}/board/listPage?"; */
				$("#f1").attr("action","jlist");
				$("#f1").attr("method","get");
				$("#f1").submit();
			})
			$("#btnRemove").click(function(){
				//#f1(form) attr은 속성값을 바꿀수있음
				var result = confirm("삭제 하시겠습니까?")
				if(result){
					$("#f1").attr("action","jremovePage");
					$("#f1").submit();
					alert("삭제 되었습니다.");
				}else{
					return false;
					
				}
				
			})
			 $("#btnModify").click(function(){
				$("#f1").attr("action","jmodifyPage");
				$("#f1").attr("method","get");
				$("#f1").submit();
			})
									
		})					
	</script>