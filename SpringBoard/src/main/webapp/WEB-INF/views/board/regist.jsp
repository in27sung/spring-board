<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 해더파일  -->
<%@ include file="../include/header.jsp"%>
<!--               본문 내용                       -->
<h1>/views/board/regist.jsp</h1>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 글쓰기</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	
	<!--  action="/board/regist" 제거 (자기 자신의 주소 호출) -->	
	<form role="form" method="post" action="">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label>
				<input type="text" name="writer" class="form-control" id="exampleInputEmail1" placeholder="작성자의 이름을 입력하시오.">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">제 목</label>
				<input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하시오.">
			</div>

			<div class="form-group">
				<label>내   용</label>
				<textarea name="content" class="form-control" rows="3" 
				           placeholder="내용을 입력하세요!"></textarea>
			</div>

		</div>
		<!-- /.box-body -->

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">글 쓰기</button>
		</div>
	</form>
</div>
<!--               본문 내용                       -->

<!-- 푸터파일  -->
<%@ include file="../include/footer.jsp"%>

