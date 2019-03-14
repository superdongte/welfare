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
				<h3 class="box-title">자유 게시판</h3>
			</div>
					<div class="box-body">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="ftitle" class="form-control"
								placeholder="Enter Title" value="${FboardVO.ftitle}"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control"
							name="fcontent" placeholder="Enter Content" readonly="readonly">${FboardVO.fcontent }</textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${FboardVO.userid }" readonly="readonly"> 
						</div>
					</div>
					<div class="box-footer">
						<c:if test="${login.userid == FboardVO.userid}">
						<button type="submit" class="btn btn-primary" id="btnList">목록</button>
						<button type="submit" class="btn btn-warning" id="btnModify">수정</button>
						<button type="submit" class="btn btn-danger" id="btnRemove">삭제</button>
						</c:if>					
					</div>
					
					<form id="f1" action="" method="post">
						<input type="hidden" name="fbno" value="${FboardVO.fbno }">
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
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">댓글 달기</h3>		
				</div> <!-- box-header -->
				<div class="box-body">
					<label>작성자</label>
					<input type="text" class="form-control" placeholder="회원 가입을 해야 입력할수 있습니다." id="newReplyWriter" value="${login.userid}" readonly="readonly">
					<label>댓글내용</label>
					<input type="text" class="form-control" placeholder="글 써주세요" id="newReplyText">
				</div><!-- box-body -->
				<div class="box-footer">
					<button class="btn btn-primary" id="btnReplyAdd">댓글 추가</button>
				</div> <!-- box-footer -->
			</div><!-- box box-success -->
			<ul class="timeline">
				<li class="time-label" id="reliesDiv">
					<span class="bg-green">총 댓글수[${FboardVO.freplycnt}]</span>
				</li>								
			</ul>
			<div class="text-center">
				<ul id="pagination" class="pagination pagination-sm no-margin">
				</ul>
			</div>
		</div> <!-- col-xs-12 -->
	</div> <!-- end-0f-row -->
	
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div> <!-- modal-header -->
				<div class="modal-body"> <!-- rno번호 넣음 -->
					<input type="text" id="frcontent" class="form-control" name="frcontent">
				</div> <!-- modal-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="btnReplyMod"  data-dismiss="modal">수정</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div> <!-- modal-footer -->
			</div> <!-- modal-content -->
		</div>	<!-- modal-dialog -->
	</div>	<!-- modifyModal -->
</section>
<script id="template1" type="text/x-handlebars-template">
{{#each.}}
<li class="replyLi" data-frno="{{frno}}">
<i class="fa fa-comments bg-blue"></i>
<div class="timeline-item">
	<span class='item'>
		<i class="fa fa-clock-o"></i>{{tempDate frregdate}}
	</span>
	<h3 class="timeline-header">
		<strong>{{frno}}</strong> -{{frwriter}}
	</h3>
	<div class="timeline-body">{{frcontent}}</div>
	<div class="timeline-footer">
		<a class="btn btn-primary btn-xs btnModify" data-toggle="modal" data-target="#modifyModal">수정</a>
		<a class="btn btn-danger btn-xs btnDelete">삭제</a>
	</div>
</div>
</li>
{{/each}}
</script>
<script>
	Handlebars.registerHelper("tempDate", function(value){
		var date = new Date(value);
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		
		return year +"/" + month + "/" +day;
		
	})

	var fbno = ${FboardVO.fbno}
	
	function getPageList(page){
		$.ajax({
			url: "${pageContext.request.contextPath}/freplies/"+fbno+"/"+page, //변수값이 감
			type:"get",
			dateType:"json",
			success:function(json){
				console.log(json)
				$(".replyLi").remove();
				
				var source = $("#template1").html();
				var f = Handlebars.compile(source);
				var result = f(json.list);
				$(".timeline").append(result);
					//pagination
				 	 $("#pagination").empty();
					for(var i= json.pageMaker.startPage; i <= json.pageMaker.endPage; i++){
					var liTag = $("<li>"); //li태그 만들기
					var aTag = $("<a>").append(i).attr("href","#"); //a태그 만들기
					liTag.append(aTag);
					if(i == json.pageMaker.cri.page){
						liTag.addClass("active");
					}
					$("#pagination").append(liTag);
				}		 	
			}
		})
	}
	$(function(){
		getPageList(1);
		
		$("#btnReplyAdd").click(function(){
			//bno,replyer/replyAdd
				
			var frwriter = $("#newReplyWriter").val();
			var frcontent = $("#newReplyText").val();
			var jsonBody = {fbno:fbno, frwriter:frwriter, frcontent:frcontent } //옆에 있는것이 key값 오른쪽은 변수값
			if(frwriter == ""){
				alert("회원가입해주세요")
				return false;
			}else{
			//@RequestBody, header, JSON.stringify
			$.ajax({
				url:"${pageContext.request.contextPath}/freplies/",
				type:"post",
				headers:{
					"Content-Type":"application/json","X-HTTP-Method-Override":"POST"},
				data:JSON.stringify(jsonBody),//"{bno:bno, replyer:replyer, replytext:replytext }"형식으로 바꿔줌
				dataType:"text",
				success:function(json){
					console.log(json)
					if(json == "success"){
						alert("등록되었습니다.")
						getPageList(1);
						$("#newReplyWriter").val(""); //input 태그는 ""로사용
						$("#newReplyText").val("");
					}
				}
			})
			}
		}) //end of btnReplyAdd
		
		$(document).on("click",".btnDelete",function(){
			var frno = $(this).parents(".replyLi").attr("data-frno");
			var result = confirm("정말로 삭제하시겠습니까?")
			if(result){
			$.ajax({
				url:"${pageContext.request.contextPath}/freplies/"+frno,
				type:"delete",
				success:function(json){
					console.log(json);
					if(json == "success"){
						alert("삭제되었습니다.");
					}
					getPageList(1);
				}
			})
			}else{
				return false;
			}
		}) //end of btnDelete
		$("#btnReplyMod").click(function(){
			var frno = $(".replyLi").attr("data-frno");
			var frcontent = $("#frcontent").val();
			var jsonBody = {frcontent:frcontent}
			var result = confirm("수정하시겠습니까?")
			if(result){
			$.ajax({
				url:"${pageContext.request.contextPath}/freplies/"+frno,
				type:"put",
				headers:{
	                  "Content-Type":"application/json",
	                  "X-HTTP-Method-Override":"PUT"      
	               },
	            data:JSON.stringify(jsonBody),
	            dataType:"text",
	            success:function(json){
	            	console.log(json);
	            	if(json == "success"){
	            		alert("수정되었습니다.")
	            	}
	            	getPageList(1);
	            }								
			})
			}else{
				return false;
			}
		})
		
	})
</script>

	<script>
		$(function(){
			$("#btnList").click(function(){
				/* location.href = "${pageContext.request.contextPath}/board/listPage?"; */
				$("#f1").attr("action","flist");
				$("#f1").attr("method","get");
				$("#f1").submit();
			})
			$("#btnRemove").click(function(){
				//#f1(form) attr은 속성값을 바꿀수있음
				var result = confirm("삭제 하시겠습니까?")
				if(result){
					$("#f1").attr("action","fremovePage");
					$("#f1").submit();
					alert("삭제 되었습니다.");
				}else{
					return false;
					
				}
				
			})
			 $("#btnModify").click(function(){
				$("#f1").attr("action","fmodifyPage");
				$("#f1").attr("method","get");
				$("#f1").submit();
			}) 
			$(document).on("click",".btnModify", function(){
				var frcon = $(this).parent().prev().text();
				$("#frcontent").val(frcon);
				$("#f1").attr("action","fmodifyPage");
				$("#f1").attr("method","get");
			})
			
									
		})					
	</script>
<%@ include file="../include/footer.jsp" %>	