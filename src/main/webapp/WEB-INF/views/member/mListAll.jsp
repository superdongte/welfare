<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>	    
<!DOCTYPE html>
<html>
<head>
<title>회원정보</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
  <h2>회원정보</h2>  
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="userVO" items="${list }">
      	<tr>
      		<td>${userVO.userid }</td>
      		<td><a href="${pageContext.request.contextPath}/member/mRead?userid=${userVO.userid}">${userVO.username }</a></td>
      		<td>${userVO.email }</td>
      		<td>${userVO.tel }</td>
      	</tr>
      </c:forEach>                 
    </tbody>
  </table>
</div>
	
</body>
</html>