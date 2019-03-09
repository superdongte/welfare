<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
  	<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
  <style>
  .modal-header, h4, .close {
    background-color: #5cb85c;
    color:white !important;
    text-align: center;
    font-size: 30px;
  }
  .modal-footer {
    background-color: #f9f9f9;
  }
  #seting{
  	margin-top:10px;
	float: right;
	background-color: #D4F4FA;
	border-radius: 15px;  
  }
  .loginSdj{
  	background-color: #D4F4FA;
  	border: none;
  	padding-right: 1px;
  }
  </style>
</head>
<body>

<div class="container">
  <!-- Trigger the modal with a button -->
  <div id="seting">
  <button type="button" class="loginSdj" id="home">홈화면</button>
  <button type="button" class="loginSdj" id="myBtn">로그인 ㅣ</button> 
  <button type="submit" class="loginSdj" id="regBtn">회원가입</button>	
  <button type="button" class="loginSdj" id="reginfo">회원정보보기</button>
  <button type="button" class="loginSdj" id="regvol">봉사관리</button>
  <button type="button" class="loginSdj" id="regor">기관관리</button>
  <button type="button" class="loginSdj" id="supvol">자원봉사자 확인</button>
  <button type="button" class="loginSdj" id="supmoney">후원 확인</button>
  <button type="button" class="loginSdj" id="volservice">봉사 지원</button>
  <button type="button" class="loginSdj" id="donation">후원 하기</button>
  <button type="button" class="loginSdj" id="fboard">자유 게시판</button>
  <button type="button" class="loginSdj" id="sboard">현장 게시판</button>
  <button type="button" class="loginSdj" id="jboard">구직 게시판</button>
  </div>
  <div>
  	<c:if test="${login != null }">
  		<span>[${login.username}]님 환영합니다.</span>
  		<a href="${pageContext.request.contextPath }/user/logout" class="btnout">로그아웃</a>
  	</c:if>
  	<c:if test="${login == null }">
  		<a href="${pageContext.request.contextPath }/user/login" class="btnlog">로그인임</a>
  	</c:if>
  </div>
</div>
 
<script>
$(document).ready(function(){
  $("#home").click(function(){
	  location.href="${pageContext.request.contextPath}"
  })
  $("#myBtn").click(function(){
       location.href="${pageContext.request.contextPath}/user/login"
  });
  $("#regBtn").click(function(){
	   location.href="${pageContext.request.contextPath}/member/mRegist"; 
  })
  $("#reginfo").click(function(){
	  location.href="${pageContext.request.contextPath}/member/mListAll";
  })
  $("#regvol").click(function(){
	  location.href="${pageContext.request.contextPath}/vol/VolunteerRead";
  })
  $("#supvol").click(function(){
	  location.href="${pageContext.request.contextPath}/sup/sVol";
  })
  $("#supmoney").click(function(){
	  location.href="${pageContext.request.contextPath}/sup/sMoney";
  })
  $("#donation").click(function(){
	  location.href="${pageContext.request.contextPath}/sup/donation";
  })
  $("#volservice").click(function(){
	  location.href="${pageContext.request.contextPath}/sup/Volservice";
  })
  $("#fboard").click(function(){
	  location.href="${pageContext.request.contextPath}/fboard/flist";
  })
  $("#sboard").click(function(){
	  location.href="${pageContext.request.contextPath}/sboard/slist";
  })
  $("#regor").click(function(){
	  location.href="${pageContext.request.contextPath}/organ/OranizeRead";
  })
  $("#jboard").click(function(){
	  location.href="${pageContext.request.contextPath}/jboard/jlist";
  })
});
</script>

</body>
</html>