<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <h2>후원하기</h2>
        <form action="donation" method="post">
        <table class="table table-boardered">
            <tr>
                <th>아이디</th>
                <td><input type="text" class="form-control" name="userid" placeholder="id를 넣으세요" id="userid" value="${login.userid }" readonly="readonly"></td>                
            </tr>
            <tr>
                <th>후원방식</th>
                <td>
                <input type="radio" value="일반후원" name="dgroup">일반후원(복지관에서 필요에 맞게 지원됩니다.)
                <br>
                <input type="radio" value="지정후원" name="dgroup">지정후원(결연 가족지원)
                <br> 
                <input type="radio" value="해피빈" name="dgroup">해피빈
                <input type="radio" value="사랑의 열매" name="dgroup">사랑의 열매
                </td>      
            </tr>
             
            <tr>
                <th>후원기간</th>
                <td><input type="text" class="form-control" name="vtime" placeholder="" id="datepicker"></td>        
            </tr>
             
              <tr>
                <th>후원금액</th>
                <td>
                <input type="radio"  name="dmoney" class="m" value="10,000">10,000원
                <input type="radio"  name="dmoney" class="m" value="20,000">20,000원
                <input type="radio"  name="dmoney" class="m" value="40,000">40,000원
                <input type="radio"  name="dmoney" class="m" value="50,000">50,000원
                </td>        
              </tr>
              <tr>
                <th>송금은행</th>
                <td>
                <input type="radio"  name="dmode" class="m" value="농협">농협
                <input type="radio"  name="dmode" class="m" value="신한은행">신한은행
                <input type="radio"  name="dmode" class="m" value="대구은행">대구은행
                <input type="radio"  name="dmode" class="m" value="우리은행">우리은행
                <input type="radio"  name="dmode" class="m" value="국민은행">국민은행
                </td>        
              </tr>
              <tr>
                <td colspan="2">
                <input type="submit" class="btn btn-primary" value="후원하기" id="btnAdd">
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