<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>동영상과 다르게  부트스트랩 적용 Head 부분만 붙이면 됩니다.</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
 
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
 
<!-- jquery cdn  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<!-- 달력 -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<script type="text/javascript">
 $(function() { 
  $("#datepicker").datepicker({
	dateFormat: 'yymmdd',
	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
     dayNamesMin: ['일','월','화','수','목','금','토'],
	 changeMonth: true, //월변경가능
     changeYear: true, //년변경가능
	 showMonthAfterYear: true, //년 뒤에 월 표시
  });
 });
</script>
<style type="text/css">
	

</style>
</head>
<body>
	 <div class="container">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3"></div>
    
    <div class="col-sm-6">
    <h2>봉사활동 지원</h2>
        <form action="Volservice" method="post">
        <table class="table table-boardered">
            <tr>
                <th>아이디</th>
                <td><input type="text" class="form-control" name="userid" placeholder="id를 넣으세요" id="userid" value="${login.userid }" readonly="readonly"></td>                
            </tr>
            <tr>
                <th>봉사명</th>
                <td>
                <select name="vnumber">
                <option>선택해주세요</option>
                <c:forEach var="vlist" items="${list}">
             		<option value="${vlist.vnumber }">${vlist.vname }</option>                		                	                	
                </c:forEach>
                </select>
                </td>      
            </tr> 
            <tr>
                <th>봉사 희망 날짜</th>
                <td>
                <input type="text" class="form-control" name="vtime" placeholder="" id="datepicker">
                </td>        
            </tr>
            <tr>
            	<th>동기</th>
            	<td>
            	<textarea rows="" cols="60" name="vreason"> 
            	 
            	</textarea>	
            	<input type="hidden" name="vgroup" value="0">
            	</td>            	
            </tr>            
              <tr>
                <td colspan="2">
                <input type="submit" class="btn btn-primary" value="신청하기" id="btnAdd">
                <input type="reset" class="btn btn-danger" value="취소">
                </td>               
            </tr>
 		</table>
    </form>   
    </div>  
    </div>
    </div>
</div>            	  
</body>
</html>