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
				<form role="form" method="post" action="jmodifyPage">
				<input type="hidden" name="jbno" value="${JboardVO.jbno }">
				<input type="hidden" name="page" value="${cri.page}">
					<div class="box-body">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="jtitle" class="form-control"
								placeholder="Enter Title" value="${JboardVO.jtitle}">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control"
							name="jcontent" placeholder="Enter Content" >${JboardVO.jcontent}</textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${JboardVO.userid}" readonly="readonly"> 
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