<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h3 class="box-title">등록</h3>
			</div>			
				<form role="form" method="post" action="jregister" enctype="multipart/form-data">
					<div class="box-body">
						<div class="form-group">
							<label>기관을 선택해주세요</label>
							<select name="ornum">
								<c:forEach var="jlist" items="${list}">
									<option value="${jlist.ornum }">${jlist.orname}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="jtitle" class="form-control"
								placeholder="제목을 입력하세요">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control"
							name="jcontent" placeholder="내용을 입력하세요"></textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="userid" class="form-control"
								placeholder="Enter Writer" value="${login.userid }" readonly="readonly"> 
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
<%@ include file="../include/footer.jsp" %>
