<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 해더파일 -->
<%@ include file="../include/header.jsp" %>
    
    <h1> /views/board/modify.jsp </h1>
    
    ${boardVO } <hr>
    cri : ${cri }<br>
  
    
    <div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 수정하기</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	  <form role="form" ><!--  action="" method="get" -->
	  	<input type="hidden" name="page" value="${cri.page }">
	  	<input type="hidden" name="pageSize" value="${cri.pageSize }">
	  
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">번호</label>
				<input type="text" name="bno" class="form-control"
				       id="exampleInputEmail1" value="${boardVO.bno }" 
				       readonly="readonly" >
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				<input type="text" name="writer" class="form-control"
				       id="exampleInputEmail1" value="${boardVO.writer }" 
				       >
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">제 목</label>
				<input type="text" name="title" class="form-control" 
				id="exampleInputEmail1" value="${boardVO.title }" 
				>
			</div>

			<div class="form-group">
				<label>내   용</label>
				<textarea name="content" class="form-control" rows="3" 
				         >${boardVO.content }</textarea>
			</div>

		</div>
		<!-- /.box-body -->

	   </form>
		<div class="box-footer">
			<button type="submit" class="btn btn-danger">수정</button>
			<button type="submit" class="btn btn-warning">취소</button>
<!-- 			<a href=""> 목록 </a> -->
		</div>
	</div>


<!-- jQuery사용해서 버튼 요소 접근 -->
<script type="text/javascript">
	$(document).ready(function(){
		
		var forms = $("form[role='form']"); // bno를 포함한 폼태그
		
		// 수정버튼 클릭시  수정처리 페이지로 이동
		$(".btn-danger").click(function(){
			alert(" 수정버튼! ");
			// /board/modify (POST) 실행 + 수정정보
			forms.attr("method","POST");
			forms.submit();
			
		});
		
		// 취소버튼 클릭시 게시판 리스트로 이동
		$(".btn-warning").click(function(){
			// 페이지 이동
			//location.href="/board/listAll";
			location.href="/board/listCri?page=${cri.page}&pageSize=${cri.pageSize}";
		});
		
		
	});
	
// 	$(function(){
// 	});
</script>


    
    
<!-- 푸터파일 -->
<%@ include file="../include/footer.jsp" %>

    