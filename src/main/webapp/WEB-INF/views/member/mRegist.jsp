<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>회원가입</title>
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
<!-- 달력끝 -->
<!-- 미입력시 끊기 -->
<script>
	$(function(){
		var idck = 0;
		 $("#dul").click(function(){
				var userid = $("#userid").val();
				var jsonBody = {userid:userid}
				$.ajax({
					url:"${pageContext.request.contextPath}/member/dul",
					type:"POST",
					headers:{"Content-Type":"application/json","X-HTTP-Method-Override":"POST"},
					data:userid,
					dataType:"text",
					success:function(data){
						console.log(data)
						if(data == "false"){
							alert("중복된 아이디 입니다.")
							idck = 0;
						}else{
							alert("사용할수 있는 아이디 입니다.")
							idck = 1;
						}
					}
				})			
			})
		$("#file1").click(function(){
			var formData = new FormData();	
			formData.append("files", $("#files").val());		
			$.ajax({
				url:"${pageContext.request.contextPath}/member/upload",
				type:"POST",
				data:formData,
				processData:false,
				contentType:false,
				success:function(json){
					console.log(json)
				}
			})
		})	
		$("#btnAdd").click(function(){			
			var userid = $("#userid").val();
			var userpw = $("#userpw").val();
			var userpw2 = $("#userpw2").val();
			var username = $("#name").val();
			var tel = $("#tel").val();
			var birth = $("#datepicker").val();
			var email = $("#email").val();
			var admin = $("#admin").is(":checked");
			var photo = $("#files").val();
			var regpass = /^[a-z0-9!@#$%]{8,15}$/i;
			var regName = /^[a-zA-Z]{3,20}$/;
			var jsonBody = {userid:userid, userpw:userpw, username:username, tel:tel,birth:birth, email:email, admin:admin} //photo:photo
			if(userid == ""){
				alert("아이디를 입력해주세요")
				return false;
			}
			if(userpw == ""){
				alert("패스워드를 입력해주세요")
				return false;
			}
			if(userpw2 == ""){
				alert("패스워드 확인을 입력해주세요")
				return false;
			}
			if(userpw != userpw2){
				alert("패스워드가 일치하지 않아 가입할수 없습니다.")
				return false;
			}
			if(username == ""){
				alert("이름을 입력해주세요")
			}
			if(tel == ""){
				alert("전화번호를 입력해주세요")
				return false;
			}
			if(email == ""){
				alert("이메일을 입력해주세요")
				return false;
			}
			if(!regpass.test(userpw)){
				alert("비밀번호 양식에 맞지않습니다.")
				return false;
			}
			if(regName.test(name)){
				alert("한글이름을 입력해주세요")
				return false;
			}
			if(photo == ""){
				alert("사진을 첨부해주세요")
				return false;
			}
			if(idck == 0){
				alert("아이디 중복체크를 해주세요")
				return false;
			}			
		})
			$("#files").on('change', function(){
				readURL(this);
		})
	})
			function readURL(input){
			if(input.files && input.files[0]){
				var reader = new FileReader();
				
				reader.onload = function(e){
					$('#blah').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
 	$(function(){ 
	 $("#admin").click(function(){
		 		var password = "1234";
		 		var adminpass = prompt('번호를 입력해주세요');
		 		$("input[name=admin]:checked").each(function(){
		 		if(adminpass == password){
		 			$("#admin").prop('checked', true);
		 		}else{
		 			alert("번호가 일치하지 않습니다")
		 			$("#admin").prop('checked',false);
		 		}
		 	})
		 })
	 }) 		
</script>
<!-- ajax방식으로하기 -->
<script>
	
</script>
<style>
	.form-control{
		width:80%;  
	}
	#dul{
		width:90%; 
	}
	#picture img{
		width:200px;
		height:135px;
		margin-top:10px;
		margin-right: 55px;
	}
</style>
</head>
<body>
     <div class="container">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3"></div>
    
    <div class="col-sm-6">
    <h2>회원가입</h2>
        <form action="mRegist" method="post" enctype="multipart/form-data">
        <table class="table table-boardered">
            <tr>
                <th>아이디</th>
                <td><input type="text" class="form-control" name="userid" placeholder="id를 넣으세요" id="userid"></td>
                <td><input type="button" class="form-control" value="중복체크" id="dul"></td>                   
            </tr>
            <tr>
                <th>패스워드</th>
                <td><input type="password" class="form-control" name="userpw" placeholder="비밀번호는 영문만 넣어주세요" id="userpw"></td>      
            </tr>
             
            <tr>
                <th>패스워드확인</th>
                <td><input type="password" class="form-control" name="pass2" placeholder="확인 해주세요" id="userpw2"></td>        
            </tr>
             
              <tr>
                <th>이름</th>
                <td><input type="text" class="form-control" name="username" placeholder="한글이름을 입력해주세요" id="name"></td>        
              </tr>
            	  
            <tr>
                <th>전화번호</th>
                <td><input type="tel" class="form-control" name="tel" placeholder="ex)010-2321-2341" id="tel"></td>
            </tr>
            
           	<tr>
                <th>생년월일</th>
                <td><input type="text" class="form-control" name="birth" id="datepicker"></td>  
             </tr>  
            <tr>
                <th>이메일</th>
                <td><input type="email" class="form-control" name="email" placeholder="ex)abcde@naver.com" id="email"></td>       
            </tr>
            <tr>
                <th>관리자</th>
                <td><input type="checkbox" name="admin" id="admin"></td>       
            </tr>
            <tr>
                
                <th>사진</th>                            
                <td id="picture">
                <input type="file" class="form-control" name="files" id="files" multiple="multiple">               
                <img src="../resources/images/noman.png" id="blah">
                </td>       
            </tr>                    
            <tr>
                <td colspan="2">
                <input type="submit" class="btn btn-primary" value="가입" id="btnAdd">
                <input type="reset" class="btn btn-danger" value="취소">
                <td>
                <input type="hidden" class="form-control" value="중복체크" id="dup"></td>               
            </tr>          
        </table>
    </form>   
    </div>  
    </div>
    </div>
</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>