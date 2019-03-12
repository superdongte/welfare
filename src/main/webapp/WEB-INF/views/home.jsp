<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/header.jsp" %>	
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<script>
    $(document).ready(function(){
      $('.slider').bxSlider();
    });
  </script>
   <script>
  $(function(){
	  $('#wrap').bxSlider({
	    
	    captions: true,
	    slideWidth: 1400,
	    auto:true,
	    autoControls:true,
	   	pause:5000
	  });
	  $("#dona").click(function(){
		  location.href="${pageContext.request.contextPath}/sup/donation";
	  })
	  $("#vol").click(function(){
		  location.href="${pageContext.request.contextPath}/sup/Volservice";
	  })
	});
</script>
<style>
	section{
		width:1147px;
		margin:0 auto;
	}
	.bx-wrapper{
		margin-top:15px; 
		
	}
	#supbox img{
		float:left;
		width:250px;
		height:230px;
	}
	ul.vol-list{
		list-style: none;
	}
	ul.vol-list li{
		float:left;
		margin:10px;
		position: relative;
		overflow:hidden;
	}
	ul.vol-list li:hover div.caption{
		opacity:1;
		top:0;
	}
	div.caption{
		width:250px;
		height:230px;
		background-color: rgba(0,0,0,0.6);
		position: absolute;
		left:0;
		top:200px;
		opacity:0;
		transition:all 0.5s;
		color:white;
		text-align: center;
	}
	p{
		line-height:50px;
	}
	#container h1{
		padding-top:30px;
	}
</style>
</head>
<body>
	<section>
  	<div id="wrap">
  		<div><img src="${pageContext.request.contextPath}/resources/images/main01.jpg" title="한결같은 이웃주민이 되겠습니다."></div>
  		<div><img src="${pageContext.request.contextPath}/resources/images/main02.jpg" title="한결같은 이웃주민이 되겠습니다."></div>
  		<div><img src="${pageContext.request.contextPath}/resources/images/main03.jpg" title="한결같은 이웃주민이 되겠습니다."></div>
  		<div><img src="${pageContext.request.contextPath}/resources/images/main04.jpg" title="한결같은 이웃주민이 되겠습니다."></div>
  	</div>
  	<div id="supbox">
  		<ul class="vol-list">
  		<li>
  		<img src="${pageContext.request.contextPath}/resources/images/donation.jpg">
  		<div class="caption" id="dona">
  			<br>
  			<br>
  			<h1>후원하기</h1>
  			<p>사랑을 이웃과 함께 나눠요</p>  		
  		</div>
  		</li>
  		<li>
  		<img src="${pageContext.request.contextPath}/resources/images/volunteer.jpg">
  		<div class="caption" id="vol">
  			<br>
  			<br>
  			<h1>봉사하기</h1>
  			<p>나눔 사랑을 실천해요</p>  		
  		</div>
  		</li>
  		<li>
  		<img src="${pageContext.request.contextPath}/resources/images/toy.JPG" id="toy">
  		<div class="caption">
  			<br>
  			<br>
  			<h1>장난감 도서관</h1>
  			<p>아이들의 상상력을 자극하는 공간</p>  		
  		</div>
  		</li>
  		<li>
  		<img src="${pageContext.request.contextPath}/resources/images/location.png" id="loca">	  	
  		<div class="caption">
  			<br>
  			<br>
  			<h1>오시는길</h1>
  			<p>동준사회복지관으로 오세요</p>  		
  		</div>
  		</li>
  		</ul>
  	</div>	
	</section>
<%@ include file="include/footer.jsp" %>		
</body>
</html>
