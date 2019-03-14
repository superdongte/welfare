<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>
	#picture{
		width:200px;
		height:135px;  
	}
	#picture img{
		width:200px;
		height: 135px;
		margin-top: 15px;
	}

</style>
<body>
<div class="container">
  <h2>회원상세정보</h2>
  <table class="table">
    <tbody>
      <tr>
        <td rowspan="6" id="picture"><img src="displayFile?filename=${userid.photo }"></td>   
      </tr>      
      <tr class="success">
        <td>아이디</td>
        <td>"${userid.userid }"</td>
      </tr>
      <tr class="danger">
        <td>이름</td>
        <td>"${userid.username }"</td>
      </tr>
      <tr class="info">
        <td>전화번호</td>
        <td>"${userid.tel }"</td>
      </tr>
      <tr class="warning">
        <td>생년월일</td>
        <td>"${userid.birth}"</td>
      </tr>
      <tr class="danger">
        <td>이메일</td>
        <td>"${userid.email}"</td>
      </tr>
    </tbody>
  </table>
  	<input type="button" value="회원정보수정" class="btn btn-primary" id="update">
  	<input type="button" class="btn btn-danger" value="탈퇴" id="delete">
  	<c:if test="${login.admin == true }">
  		<input type="button" class="btn btn-primary" value="돌아가기" id="back">
  	</c:if> 	 
  <form id="m1" action="" method="post">
  	<input type="hidden" name="userid" value="${userid.userid }">
  </form>	 
</div>
<script>
	$(function(){
		$("#update").click(function(){
			$("#m1").attr("action","mUpdate");
			$("#m1").attr("method","get");
			$("#m1").submit();
		})
		$("#delete").click(function(){
			var result = confirm("정말로 탈퇴하시겠습니까?");
			if(result){
				$("#m1").attr("action","mdelete");
				$("#m1").submit();
				alert("탈퇴되었습니다.")
			}else{
				return false;
			}
		})
		$("#back").click(function(){
			location.href="${pageContext.request.contextPath}/member/mListAll"
		})
	})

</script>
<%@ include file="../include/footer.jsp" %>
</body>
</html>