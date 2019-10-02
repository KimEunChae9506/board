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
	.aa{
	font-size:40px; 
	margin-left:40%; 
	margin-top:5%;
}
</style>
<link rel="stylesheet" href="../resources/css/common.css">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/8a7fdcda3d.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script type = "text/javascript">

	
	function sel(){
		$("#edit").attr("action","./list").submit();
		}

	$(document).ready(function(){
		
		$("#add").click(function(){
					location.href="./insert";
				})
		$("#delete").click(function(){
					if(confirm("삭제하시겠습니까?")){
						$("#edit").attr("action","./delete").submit();
					}	
				})
		$("#serbt").click(function(){
			$("#edit").attr("action","./list").submit();
				})
				
		$("input:checkbox").click(function(){
		   $("#delete").removeClass("disabled");
				if($(this).prop("checked")){ // 현재 선택한 체크박스의 값이 true인지 확인
					$("input:checkbox").prop("checked",false); // 전체 체크박스의 값을 false로 변경
					$(this).prop("checked",true); // 현재 선택한 체크박스의 값만 true로 변경
				}else{
					$("input:checkbox").prop("checked",false); // 전체 체크박스의 값을 false로 변경
					$("#delete").addClass("disabled");
					}
		    	})
			
		$("#checkall").click(function(){
			$("#delete").removeClass("disabled");
				if($("#checkall").prop("checked")){
					$("input:checkbox").prop("checked",true);
				}else{
					$("input:checkbox").prop("checked",false);
					$("#delete").addClass("disabled");
				     }
	       	   })		
	})

</script>
</head>
<body>
<div class="container">
<a href="./list" class="aa">은채 게시판</a>
<form id="edit" name="edit" method=post>
  <div class="form-group row">
	  <div class="col-xs-2">
		<select name = "numsel" class="form-control" id="exampleFormControlSelect1" onchange="sel()">
		    <option value = "${pvo.perPageNum}">게시글수순</option>
			<option value = '5'>5개씩</option>
			<option value = '10'>10개씩</option>
			<option value = '15'>15개씩</option>
		</select>
	</div>
	<div class="col-xs-2">
		<select name = "orderBy" class="form-control" id="exampleFormControlSelect1" onchange="sel()">
		    <option value = "${pvo.orderBy}">등록&제목순</option>
			<option value = 'd'>등록순</option>
			<option value = 't'>제목순</option>
		</select>
	</div>

	<div class="col-xs-6" style="background-color:white;">
	</div>
	<div class="col-xs-1">
  		<button type="button" class="btn btn-primary right" id="add" >등록</button>
    </div>
	<div class="col-xs-1">
		<button type="button" class="btn btn-danger disabled right"  id="delete">삭제</button>
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
	    </tr>
	   </thead>
	  
	   <tbody> 
	   <c:forEach items="${list}" var="list" > <!-- 컨트롤러에서 받아온 list, for문에서 사용할 변수이름 -->
	     <tr>
	        <td><input type="checkbox" name="check" id="check" value="${list.no}"></td>
	    	<td>${list.no}</td>
	    	<td><a href="/board/view?no=${list.no}&page=${pvo.page}&perPageNum=${pvo.perPageNum}&search=${pvo.search}">${list.title}</a></td>
	    	<td>${list.writer}</td>
	    	<td>${list.date}</td>
	     </tr>
	    </c:forEach>
	    </tbody>
	</table>
	
			
	
	<div class="col-xs-3" style="background-color:white; ">
	</div>
	<div class="col-xs-5 padd">
	    <input type="text" class="form-control padd" id="search" value = "${pvo.search}" name="search" placeholder="내용을 검색하세요." autocomplete="off">
	</div>
	<div class="col-xs-1 padd">
	    <button type="button" class="btn btn-success" id = "serbt">검색</button>
	</div>
	
			<input type="hidden" id="page" name = "page" value= "${pvo.page}" >	
	   	    <input type="hidden" id="perPageNum" name = "perPageNum" value= "${pvo.perPageNum}" >
</form>	
	<ul class="btn-group pagination right" >
	    <c:if test="${pm.prev}">
	    <li>
	        <a href='<c:url value="/board/list?page=${pm.startPage-1 }&perPageNum=${pvo.perPageNum}&orderBy=${pvo.orderBy}&search=${pvo.search}"/>'><i class="fa fa-chevron-left"></i></a>
	    </li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="num">
	    <li>
	        <a href='<c:url value="/board/list?page=${num}&perPageNum=${pvo.perPageNum}&orderBy=${pvo.orderBy}&search=${pvo.search}"/>'><i class="fa">${num}</i></a>
	    </li>
	    </c:forEach>
	    <c:if test="${pm.next}">
	    <li>
	        <a href='<c:url value="/board/list?page=${pm.endPage+1 }&perPageNum=${pvo.perPageNum}&orderBy=${pvo.orderBy}&search=${pvo.search}"/>'><i class="fa fa-chevron-right"></i></a>
	    </li>
	    </c:if>
	</ul>

</div>
</body>
</html>
