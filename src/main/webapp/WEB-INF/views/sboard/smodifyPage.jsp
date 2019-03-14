<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
	.content{
		width:70%;
		margin:0 auto;	
	}

</style>
<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">REGISTER BOARD</h3>
			</div>			
				<form role="form" method="post" action="smodifyPage" enctype="multipart/form-data">
				<input type="hidden" name="sbno" value="${SboardVO.sbno }">
				<input type="hidden" name="page" value="${cri.page}">
					<div class="box-body">
						<div class="form-group">
							<label>Title</label>
							<input type="text" name="stitle" class="form-control"
								placeholder="Enter Title" value="${SboardVO.stitle}">
						</div>
						<div class="form-group">
							<label>Content</label>
							<textarea rows="5" class="form-control"
							name="scontent" placeholder="Enter Content" >${SboardVO.scontent}</textarea>
						</div>
						<%-- <div class="form-group">
							<label>Writer</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${SboardVO.userid}" readonly="readonly"> 
						</div> --%>
						<div class="form-group">
							<label>Image File</label>
							<input type="file" name="addFiles" class="form-control" multiple="multiple">
						</div>
						<div class="form-group">
							<c:forEach var="file" items="${SboardVO.files }">  
								<div class="item">
									<img src="displayFile?filename=${file }">
									<button type="button" class="btnDel" data-src="${file }">X</button>
								</div>
							</c:forEach>
						</div>
						<div id="delFileWrap">
						</div>
						<script>
							$(".item").each(function(i, obj){
								var img = new Image();
								img.onload = function(){
									$(obj).css("width",this.width);
								}
								img.src = $(obj).find("img").attr("src");
							})
							
							$(".btnDel").click(function(){
								var filename = $(this).attr("data-src");
								var $input = $("<input>").attr("type", "hidden")
														 .attr("name","delFiles")
														 .val(filename);
								$("#delFileWrap").append($input);
								$(this).parent().remove();
							
							})
						</script>
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>			
		</div>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>