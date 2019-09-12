<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container2{
width:50%;
margin-left:25%;
margin-top:100px;
}


</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#update").click(function(){
			if(confirm("수정하시겠습니까?")){
				$("#update").attr("type","submit");
				
			}else{
				return;
			}
			
			
		})
		
		$("#list").click(function(){
			location.href="./list";
		})
		
		
		
	})




</script>

</head>
<body>

<div class="form-group container2">


<form name = "form" method="post">
		<!-- 인서트와 달리 데이터 전송 때 글번호도 필요하니 작성 -->
		<input type="hidden" id="no" name = "no" value= "${view.no}" >	
        <div class="form-group">
              <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="title" name = "title" value= "${view.title}" >
          </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
           <input type="text" class="form-control" id="writer" name = "writer" value= "${view.writer}" >
          </div>
          <div class="form-group">
            <label for="exampleFormControlInput1">작성날짜</label>
            <p>${view.regDate}</p>
          </div>
          <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="content" name = "content" rows="10">${view.content}</textarea>
          </div>
        <button type="button" id="update" class="btn btn-info">수정하기</button>
        <button type="button" id="list" class="btn btn-secondary">목록으로</button>
    </form>

</div>


</body>
</html>