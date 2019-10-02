<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../resources/css/common.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#update").click(function(){
			if(confirm("수정하시겠습니까?")){
				$("#update").attr("type","submit");	
			}
		})
		
		$("#list").click(function(){
			location.href="./list?" + "page=${pvo.page}" + "&perPageNum=${pvo.perPageNum}" + "&search=${pvo.search}";
			
		})	
	})
</script>

</head>
<body>

<div class="form-group container2">
<h3>게시판</h3>
<hr width=60%; align="left"; style="border: solid 1px black;">
<form name = "form" method="post" action="./update">
		<!-- BoardVO에 들어갈 모든 값 위해 히든 인풋-->
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
          <div class="right">
        <button type="button" id="update" class="btn btn-info">수정하기</button>
        <button type="button" id="list" class="btn btn-secondary">목록으로</button>
        
        </div>
    </form>

</div>


</body>
</html>