<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
  <h2>봉사지원자 조회</h2>  
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>봉사명</th>
        <th>시간</th>
        <th>동기</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
      	<c:forEach var="Volun" items="${list }" >
      	<tr>
      		<td>${Volun.userid }</td>
      		<td>${Volun.vname }</td>
      		<td>${Volun.vtime }</td>
      		<td>${Volun.vreason }</td>
      		<td>${Volun.tel }</td>
      	</tr>
      	</c:forEach>               
    </tbody>
  </table>
</div>
</body>
</html>