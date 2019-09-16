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
		
		$("#edit button:button").on("click",function(){
			switch($("#edit button:button").index(this)){
				case 0:
					location.href="./update?no=${view.no}";
					break;
				case 1:
					$("#edit").attr("action","./delete").submit();
					break;
				case 2:
					location.href="./list?page=${pvo.page}";
					break;
				 default:
					alert("오류가 발생 하였습니다.");
					break;
				    }	
				})
		
		
	});




</script>

</head>
<body>

<div class="form-group container2">


<form name = "form" method="post" id="edit">
		<input type="hidden" id="no" name = "no" value= "${view.no}" >	
        <div class="form-group">
              <label for="exampleFormControlInput1">제목</label> <!-- 같은url 즉 /view니까 view모델이 넘어온거 -->
            <input type="text" class="form-control" id="title" name = "title" value= "${view.title}" readonly="readonly">
          </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="writer" name = "writer" value= "${view.writer}" readonly="readonly">
          </div>
          <div class="form-group">
            <label for="exampleFormControlInput1">작성날짜</label>
            <input type="text" class="form-control" id="regDate" name = "regDate" value= "${view.regDate}" readonly="readonly">
          </div>
          <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="content" name = "content" rows="10" readonly="readonly">${view.content}</textarea>
          </div>
          

        <!--<a href="/board/update?no=${view.no}" class="btn btn-info" role="button">수정하기</a>-->
        <button type="button" id="update" class="btn btn-info">수정하기</button>
        <button type="button" id="delete" class="btn btn-danger">삭제하기</button>
        <!-- <a href="/board/delete?no=${view.no}" class="btn btn-danger" role="button">삭제하기</a> -->
        <button type="button" id="list" class="btn btn-secondary">목록으로</button>
    </form>

</div>


</body>
</html>