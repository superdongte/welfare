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
				<h3 class="box-title">현장 게시판</h3>
			</div>
					<div class="box-body">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="title" class="form-control"
								placeholder="Enter Title" value="${SboardVO.stitle}"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control"
							name="content" placeholder="Enter Content" readonly="readonly">${SboardVO.scontent }</textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="writer" class="form-control"
								placeholder="Enter Writer" value="${SboardVO.userid }" readonly="readonly"> 
						</div>
						<div class="form-group">
							<p><b>현장사진들</b><p>
							<c:forEach var="file" items="${SboardVO.files }">
								<div class=item>
									<img src="displayFile?filename=${file }">
								</div>
							</c:forEach>
						</div>
					</div>
					<c:if test="${login.userid == SboardVO.userid}">
					<div class="box-footer">
						<button type="submit" class="btn btn-primary" id="btnList">GO LIST</button>
						<button type="submit" class="btn btn-warning" id="btnModify">Modify</button>
						<button type="submit" class="btn btn-danger" id="btnRemove">Remove</button>
					</div>
					</c:if>
					<form id="f1" action="" method="post">
						<input type="hidden" name="sbno" value="${SboardVO.sbno }">
						<input type="hidden" name="page" value="${cri.page }">
					</form>
					
					
			</div>
		</div>
	</div>
	<script>
		$(".item").each(function(i, obj){
			//image 의 사이즈 구하여 div.item 크기 조정[
			var img = new Image();
			img.onload = function(){
				$(obj).css("width",this.width);
			}
			img.src = $(obj).find("img").attr("src");
			// ]
		})	
	</script>		
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div> <!-- modal-header -->
				<div class="modal-body"> <!-- rno번호 넣음 -->
					<p><input type="text" id="replytext" class="form-control" value="${FreplyVO.frcontent }">비이임</p>
				</div> <!-- modal-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="btnReplyMod"  data-rno="">Modify</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div> <!-- modal-footer -->
			</div> <!-- modal-content -->
		</div>	<!-- modal-dialog -->
	</div>	<!-- modifyModal -->
</section>

	<script>
		$(function(){
			$("#btnList").click(function(){
				/* location.href = "${pageContext.request.contextPath}/board/listPage?"; */
				$("#f1").attr("action","list");
				$("#f1").attr("method","get");
				$("#f1").submit();
			})
			$("#btnRemove").click(function(){
				var result = confirm("삭제 하시겠습니까?")
				if(result){
					//#f1(form) attr은 속성값을 바꿀수있음
					$("#f1").attr("action","sremovePage");
					$("#f1").submit();
				}else{
					return false;
				}
			})
			$("#btnModify").click(function(){
				$("#f1").attr("action","smodifyPage");
				$("#f1").attr("method","get");
				$("#f1").submit();
			})
			
			
		})
	</script>
<%@ include file="../include/footer.jsp" %>	