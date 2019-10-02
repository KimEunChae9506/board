<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
<link rel="stylesheet" href="../resources/css/common.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#edit button:button").on("click",function(){
			switch($("#edit button:button").index(this)){
				case 0://수정
					location.href="./update?no=${view.no}" + "&page=${pvo.page}" + "&perPageNum=${pvo.perPageNum}" + "&search=${pvo.search}";
					break;
				case 1://삭제
					if(confirm("삭제하시겠습니까?")){
						$("#edit").attr("action","./delete").submit();
					}
					break;
				case 2://목록
					location.href="./list?" + "page=${pvo.page}" + "&perPageNum=${pvo.perPageNum}" + "&search=${pvo.search}";
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
<h3>게시판</h3>
<hr width=60%; align="left"; style="border: solid 1px black;">
<form name = "edit" method="post" id="edit">
		<input type="hidden" id="no" name = "check" value= "${view.no}" >	
        <div class="form-group">
              <label for="exampleFormControlInput1">제목</label>
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
          
		 <div class="right">
	        <button type="button" id="update" class="btn btn-info">수정하기</button>
	        <button type="button" id="delete" class="btn btn-danger">삭제하기</button>
	        <button type="button" id="list" class="btn btn-secondary">목록으로</button>
   		 </div>
   		 <!--  /delete로 보낼 현재 pvo데이터들 --->
	   		<input type="hidden" id="page" name = "page" value= "${pvo.page}" >	
	   	    <input type="hidden" id="perPageNum" name = "perPageNum" value= "${pvo.perPageNum}" >	
	   	    <input type="hidden" id="search" name = "search" value= "${pvo.search}" >
    </form>

</div>


</body>
</html>