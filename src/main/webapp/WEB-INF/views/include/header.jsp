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
  #container{
  		width:1024px;
  		margin:0 auto;
  }
  .container-fluid{
  		height: 50px;
  }
  .navbar-header img{
  		width: 100px;
  		height: 50px;
  }
  #seting{
  	margin-top:15px;
	float: right;
	border-radius: 15px;
  }
  #seting a{
  	color:grey;
  }  
  .loginSdj{
  	border: none;
  	padding-right: 4px;  	
  	line-height: 15px;
  	background-color: none;
  }
  #loginbox{
  	margin-top: 1px;  
  }
</style>
</head>
<body>

<div class="container">
  <!-- Trigger the modal with a button -->
 <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header navbar-left">      
      <img src="${pageContext.request.contextPath}/resources/images/sub01.png">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">동준복지관</a>  
    </div>
    <ul class="nav navbar-nav  navbar-right">
      
      <li class="dropdown"><a class="dropdown-toggle " data-toggle="dropdown" href="#">사업안내 <span class="caret"></span></a>
        <ul class="dropdown-menu" >
          <li><a href="#">사례관리 기능</a></li>
          <li><a href="#">서비스 제공 기능</a></li>
          <li><a href="#">지역 조직화 기능</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">나눔활동 <span class="caret"></span></a>
      	 <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/sup/donation">후원</a></li>
          <li><a href="${pageContext.request.contextPath}/sup/Volservice">자원봉사</a></li>
        </ul>      
      </li>      	           
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판 <span class="caret"></span></a>
      	 <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/fboard/flist">자유게시판</a></li>
          <li><a href="${pageContext.request.contextPath}/sboard/slist">현장게시판</a></li>
          <li><a href="${pageContext.request.contextPath}/jboard/jlist">구직 게시판</a></li>
        </ul>      
      </li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">복지관소개 <span class="caret"></span></a>
      	 <ul class="dropdown-menu">
          <li><a href="#">인사말</a></li>
          <li><a href="#">비전</a></li>
          <li><a href="#">연혁</a></li>
          <li><a href="#">윤리강형헌장</a></li>
          <li><a href="#">조직도</a></li>
        </ul>      
      </li>
    </ul>
    <div id="seting">
   <c:if test="${login.admin == true}">
  <a href="${pageContext.request.contextPath}/member/mListAll">회원정보보기 |</a>
  <a href="${pageContext.request.contextPath}/vol/VolunteerRead">봉사관리 |</a>
  <a href="${pageContext.request.contextPath}/organ/OranizeRead">기관관리 |</a>
  <a href="${pageContext.request.contextPath}/sup/sVol">자원봉사자 확인 |</a>
  <a href="${pageContext.request.contextPath}/sup/sMoney">후원확인</a>
  	[관리자]
  </c:if>
  <c:if test="${login.admin == false }">
  	<a href="${pageContext.request.contextPath }/member/mRead?userid=${login.userid}">내정보 |</a>
  	<a href="${pageContext.request.contextPath }/sup/sVol?searchType=mu&keyword=${login.userid}">My자원봉사|</a>
  	<a href="${pageContext.request.contextPath }/sup/sMoney?searchType=mm&keyword=${login.userid}">My후원확인</a>
  	[회원]
  </c:if>
  </div>
  </div>
</nav>
	<div id="longinbox" align="right">
  	<c:if test="${login != null }">
  		<span>[${login.username}]님 환영합니다.</span>
  		<a href="${pageContext.request.contextPath }/user/logout" class="btnout">로그아웃</a>
  	</c:if>
  	<c:if test="${login == null }">
  		<a href="${pageContext.request.contextPath }/user/login" class="btnlog">로그인</a> 	  	
  	</c:if>
  	<a href="${pageContext.request.contextPath}/member/mRegist">회원가입</a>
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