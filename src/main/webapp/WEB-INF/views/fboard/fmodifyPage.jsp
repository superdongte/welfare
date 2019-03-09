<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script>
	$(function(){
		$("#confirm").click(function(){
			var result= confirm("수정하시겠습니까?")
		   
			if(result){
				alert("수정되었습니다.")
			}else{
				return false;
			}
		})
	})


</script>
<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">REGISTER BOARD</h3>
			</div>			
				<form role="form" method="post" action="fmodifyPage" enctype="multipart/form-data">
				<input type="hidden" name="fbno" value="${FboardVO.fbno }">
				<input type="hidden" name="page" value="${cri.page}">
					<div class="box-body">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="ftitle" class="form-control"
								placeholder="Enter Title" value="${FboardVO.ftitle}">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control"
							name="fcontent" placeholder="Enter Content" >${FboardVO.fcontent}</textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${FboardVO.userid}" readonly="readonly"> 
						</div>			
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary" id="confirm">Submit</button>
					</div>
				</form>			
		</div>
		</div>
	</div>
</section>