<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">REGISTER BOARD</h3>
			</div>			
				<form role="form" method="post" action="sregister" enctype="multipart/form-data">
					<div class="box-body">
						<div class="form-group">
							<label>Title</label>
							<input type="text" name="stitle" class="form-control"
								placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label>Content</label>
							<textarea rows="5" class="form-control"
							name="scontent" id="scontent" placeholder="Enter Content"></textarea>
						</div>
						<div class="form-group">
							<label>Writer</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${login.userid }"> 
						</div>
						<div class="form-group">
							<label>Image File</label>
							<input type="file" name="imageFiles" class="form-control"
								placeholder="이미지를 선택하세욧!" multiple="multiple"> 
						</div>
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>			
		</div>
		</div>
	</div>
</section>
