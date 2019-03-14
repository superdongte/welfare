<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
				<h3 class="box-title">게시글 쓰기</h3>
			</div>			
				<form role="form" method="post" action="fregister" enctype="multipart/form-data">
					<div class="box-body">
						<div class="form-group">
							<label>게시글 타입</label>
							<select name="fgroup">
								<option value="1">공지</option>
								<option value="0">자유</option>
							</select>
						</div>
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="ftitle" class="form-control"
								placeholder="제목을 입력하세요">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control"
							name="fcontent" placeholder="내용을 입력하세요"></textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${login.userid }" readonly="readonly"> 
						</div>
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">적용</button>
					</div>
				</form>			
		</div>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp" %>
