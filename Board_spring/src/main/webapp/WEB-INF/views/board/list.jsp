<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>list</title>
	<style>
	.th{
	background-color:gray;
	}
	
	</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/8a7fdcda3d.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type = "text/javascript">

	$(document).ready(function(){
		
		$("#add").click(function(){
			location.href="./insert";
		})
		$("#update").click(function(){
			window.open("");		
		})
		$("#delete").click(function(){
			$("#edit").attr("action","./delete").submit();		
		})
		$("#sel").click(function(){
			//location.href="./listSearch";
			$("#edit").attr("action","./list").submit();	
		})
		
		$("input:checkbox").click(function(){
		 $("button:button").removeClass("disabled");
			if($(this).prop("checked")){ // 현재 선택한 체크박스의 값이 true인지 확인
				$("input:checkbox").prop("checked",false); // 전체 체크박스의 값을 false로 변경
				$(this).prop("checked",true); // 현재 선택한 체크박스의 값만 true로 변경
			}else{
				$("input:checkbox").prop("checked",false); // 전체 체크박스의 값을 false로 변경
				$("button:button").addClass("disabled");
				$("#add").removeClass("disabled");
			}
			})
		$("#checkall").click(function(){
			$("button:button").removeClass("disabled");
			if($("#checkall").prop("checked")){
				$("input:checkbox").prop("checked",true);
			}else{
				$("input:checkbox").prop("checked",false);
			}
		})
	})
	


</script>
</head>
<body>
<div class="container">
	<h1 class="text-center">은채 게시판</h1>
	<form id="edit" name=writeform method=post action="">
	  <div class="form-group row">
	  <div class="col-xs-2">
	<select name = "select" class="form-control" id="exampleFormControlSelect1">
	<option value = "">게시글수</option>
	<option value = 5>5개씩</option>
	<option value = 10>10개씩</option>
	<option value = 15>15개씩</option>
	</select>
	</div>
	<div class="col-xs-2">
	<select name = "order" class="form-control" id="exampleFormControlSelect1">
	<option value = "">---</option>
	<option value = 't'>제목순</option>
	<option value = 'd'>등록순</option>
	</select>
	</div>
	<div class="col-xs-1">
	    	<button type="button" class="btn btn-primary" id="sel">입력</button>
	    </div>
	    <div class="col-xs-1">
	    	<button type="button" class="btn btn-primary" id="add">추가</button>
	    </div>
	    <div class="col-xs-1">
	    	<button type="submit" class="btn btn-success disabled" id="update">수정</button>
	    </div>
	    <div class="col-xs-1">
	    	<button type="submit" class="btn btn-danger disabled" id="delete">삭제</button>
	    </div>
	  </div>
	
</div>
<div class="container">
	

	<table class="table table-striped">
	  <thead>
		<tr class="th">
			<th><input type="checkbox" id="checkall" name="checkall"></th>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
	    </tr>
	   </thead>
	  
	   <tbody> 
	   <c:forEach items="${list}" var="list" > <!-- 컨트롤러에서 작성했던 list, 즉 model.addAttribute("list", list); -->
	     <tr>
	        <td><input type="checkbox" name="check" id="check" value="${list.no}"></td>
	    	<td>${list.no}</td>
	    	<td><a href="/board/view?no=${list.no}">${list.title}</a></td> <!-- url에 ?다음 매개변수로 no get방식으로 보낼거야 -->
	    	<td>${list.writer}</td>
	    	<td>${list.date}</td>
	    	<td>${list.viewCnt}</td>
	     </tr>
	    </c:forEach>
	    </tbody>
	    </form>
	</table>

<ul class="btn-group pagination" style="float:right">
    <c:if test="${pm.prev}">
    <li>
        <a href='<c:url value="/board/list?page=${pm.startPage-1 }"/>'><i class="fa fa-chevron-left"></i></a>
    </li>
    </c:if>
    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="num">
    <li>
        <a href='<c:url value="/board/list?page=${num}"/>'><i class="fa">${num}</i></a>
    </li>
    </c:forEach>
    <c:if test="${pm.next}">
    <li>
        <a href='<c:url value="/board/list?page=${pm.endPage+1 }"/>'><i class="fa fa-chevron-right"></i></a>
    </li>
    </c:if>
</ul>



</div>
</body>
</html>
