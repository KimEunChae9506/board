<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container2{
margin-left:25%;
margin-top:200px;
width:50%;
}


</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#submit").click(function(){
			var title = document.form.title.value;
			var content = document.form.content.value;
			var writer = document.form.writer.value;
			if(title == "" || writer == "" || content == ""){
				alert("내용을 모두 입력하세요");
				return;
			}else{
				if(confirm("작성하시겠습니까?")){
					$("#submit").attr("type","submit");
					
				}else{
					return;
				}
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
<form name = "form" action = "./insert2" method="post">
        <div class="form-group">
              <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="title" name = "title" placeholder="제목을 작성해주세요.">
          </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="writer" name = "writer"placeholder="이름을 적어주세요.">
          </div>
          <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="content" name = "content" rows="10"></textarea>
          </div>
        <button type="button" id="submit" class="btn btn-info">등록하기</button>
        <button type="button" id="list" class="btn btn-secondary">목록으로</button>
    </form>
</div>
</body>
</html>