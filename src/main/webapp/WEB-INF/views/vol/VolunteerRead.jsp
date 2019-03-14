<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!-- Modal -->
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
	$(function(){
		GetVolList();
		$("#addbtn").click(function(){
			$("#myModal").modal();
		})
				
		function GetVolList(){
			$.ajax({
				url:"${pageContext.request.contextPath}/vol/All",
				type:"get",
				dataType : "json",
				success : function(json){
					console.log(json);
					var tableTag = $("<table>").addClass("table table-striped custab");
					tableTag.append("<tr><th>번호</th><th>이름</th><th class='text-center'></th><tr>").append()
					$(json).each(function(i, obj){
						
						var trTag = $("<tr>");
						var thTag = $("<th>");
						var vidTag = $("<td>").text(obj.vnumber).addClass("vnumber");
						var vnameTag = $("<td>").text(obj.vname);
						
						trTag.append(vidTag).append(vnameTag).append("<td class='text-center'><a class='btn btn-info btn-xs model'>수정</a><a class='btn btn-danger btn-xs del'>삭제</a></td>");
						tableTag.append(trTag);
						$("#vlist").append(tableTag);
						
					})
					
				}
			})			
		}
		$("#regvol").click(function () {
				var vname = $("#vname").val();
				var jsonBody = {vname:vname}
				var result = confirm("가입할꺼냐?");
				if(result){
				$.ajax({
					url:"${pageContext.request.contextPath}/vol/insertVol",
					type:"post",
					headers:{
						"Content-Type":"application/json","X-HTTP-Method-Override":"POST"},
					data:JSON.stringify(jsonBody),
					dataType:"text",
					success:function(json){
						console.log(json)						
							if(json == "success"){	
								alert("가입되었습니다.")
		            	}
						$("#vlist").empty();
						GetVolList();
					}
			})//end ajax
				}else{
					return false;
				}
	      })
	      $(document).on("click",".model", function(){
			$("#editModal").modal();
			var vname = $(this).parent().prev().text();
			var vnumber = $(this).parent().prev().prev().text();
			$("#vedit").val(vname);
			$("#vedit").attr("data-num", vnumber);
		  })
			
		  	$("#editvol").click(function(){
		  			var tr = $(".vnumber").parent()
		  			var td = tr.children();
		  			var vnumber = $("#vedit").attr("data-num");
		  			var vname = $("#vedit").val();					
					var jsonBody = {vname:vname}
					var result = confirm("수정하시겠습니까?");
					if(result){
					$.ajax({
						url:"${pageContext.request.contextPath}/vol/"+vnumber,
						type:"put",
						headers:{
			                  "Content-Type":"application/json",
			                  "X-HTTP-Method-Override":"PUT"      
			               },
			            data:JSON.stringify(jsonBody),
			            dataType:"text",
			            success:function(json){
			            	console.log(json);
			            	if(json == "success"){
			            		alert("수정되었습니다.")
			            	}
			            	$("#vlist").empty();
							GetVolList();
			            }
					})
					}else{
						
					}
				}) //end of json
		  	
		$(document).on("click",".del", function(){
			var vnumber = $(this).parent().prev().prev().text(); 
			var result = confirm("삭제하시겠습니까?");
			if(result){
			$.ajax({
				url:"${pageContext.request.contextPath}/vol/"+vnumber,
				type:"delete",
				dataType:"text",
				success:function(json){
					console.log(json);
					if(json == "success"){
						alert("삭제 되었습니다.")
					}
					$("#vlist").empty();
					GetVolList();	
				}
			})//end ajax
			}else{				
			}
		})
	})
</script>
<style>
.custab{
    border: 1px solid #ccc !important;
    padding: 5px !important;
    margin: 5% 0 !important;
    box-shadow: 3px 3px 2px #ccc !important;
    transition: 0.5s !important;
    }
.custab:hover{
    box-shadow: 3px 3px 0px transparent !important;
    transition: 0.5s !important;
    }
a.btn{
	margin-left:5px !important;
	color: white  !important;  
}
#btnwrap{
	padding-top: 50px !important;
}    
</style>
</head>
<body>
	<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle" id="btnwrap">
    	<a href="#" class="btn btn-primary btn-xs pull-right" id="addbtn"><b>+</b> 봉사활동 추가</a>
    	<a href="${pageContext.request.contextPath }" class="btn btn-primary btn-xs pull-right" >돌아가기</a>
    </div>
    <div id="vlist">

    </div>
</div>
<!-- The Modal insert -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">봉사활동추가</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
          <input type="text" placeholder="이름을 입력해주세요" class="modal-body" id="vname">
        <!-- Modal footer -->
          
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal" id="regvol">적용</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
        </div>
        
      </div>
    </div>
  </div>
<!-- end insert Modal -->

<!-- The Modal edit -->
  <div class="modal fade" id="editModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">봉사활동수정</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
          <input type="text" placeholder="이름을 입력해주세요" class="modal-body" id="vedit">
        <!-- Modal footer -->
          
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal" id="editvol">적용</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
        </div>
        
      </div>
    </div>
  </div>
<!-- end insert edit -->


</body>
</html>