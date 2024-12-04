<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 해더파일 -->
<%@ include file="../include/header.jsp" %>
    
    <h1> /views/board/read.jsp </h1>
    
    bno : ${bno } <br>
    cri : ${cri } <br>
    ${resultVO } <hr>
    
    
    <form role="form" ><!--  action="" method="get" -->
    	<input type="hidden" name="bno" value="${resultVO.bno }">
    	<input type="hidden" name="page" value="${cri.page }">
    	<input type="hidden" name="pageSize" value="${cri.pageSize }">
    </form>
    
    
    <div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 본문내용</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				<input type="text" name="writer" class="form-control"
				       id="exampleInputEmail1" value="${resultVO.writer }" 
				       readonly>
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">제 목</label>
				<input type="text" name="title" class="form-control" 
				id="exampleInputEmail1" value="${resultVO.title }" 
				readonly="readonly">
			</div>

			<div class="form-group">
				<label>내   용</label>
				<textarea name="content" class="form-control" rows="3" 
				          readonly="readonly">${resultVO.content }</textarea>
			</div>

		</div>
		<!-- /.box-body -->

		<div class="box-footer">
			<button type="submit" class="btn btn-danger">수정</button>
			<button type="submit" class="btn btn-warning">삭제</button>
			<button type="submit" class="btn btn-success" >목록이동</button>
<!-- 			<a href=""> 목록 </a> -->
		</div>
</div>

<!-- jQuery사용해서 버튼 요소 접근 -->
<script type="text/javascript">
	$(document).ready(function(){
		
		// 목록이동
		$(".btn-success").click(function(){
			 //alert(" 목록이동 버튼 클릭! ");
			 //location.href="/board/listAll";
			 location.href="/board/listCri?page=${cri.page}&pageSize=${cri.pageSize}";
		});
		
		var forms = $("form[role='form']"); // bno를 포함한 폼태그
		
		// 수정버튼 클릭시  수정페이지로 이동
		$(".btn-danger").click(function(){
// 			 location.href="/board/modify"; (x)	
			 // /board/modify 주소로 bno가지고 GET방식으로 이동
			 
			 // 폼태그에 액션페이지를 /board/modify 변경
			 forms.attr("action","/board/modify");
			 // 폼태그 서브밋
			 forms.submit();
		});
		
		
		// 삭제버튼 클릭시
		// 글번호(bno)를 가지고 삭제 처리(POST) 이동
		$(".btn-warning").click(function(){
			forms.attr("action","/board/remove");
			forms.attr("method","POST");
			forms.submit();			
		});
		
		
		
	});
	
// 	$(function(){
// 	});
</script>


    
    
<!-- 푸터파일 -->
<%@ include file="../include/footer.jsp" %>

    