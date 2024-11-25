<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- headerFile -->
<%@ include file="../include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 입력</title>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 글쓰기</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">작성자</label> <input type="text" name = "writer" class="form-control" id="exampleInputEmail1" placeholder="작성자의 이름을 입력하시오.">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">글 제목</label> <input type="text" name = "title" class="form-control" id="exampleInputPassword1" placeholder="제목을 입력하시오.">
			</div>
			<div class="form-group">
                  <label>내 용</label>
                  <textarea class="form-control" name = "content" rows="3" placeholder="Enter ..."></textarea>
                </div>
		</div>
		<!-- /.box-body -->

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">글 쓰기</button>
		</div>
	</form>
</div>



<!-- footerFile -->
<%@ include file="../include/footer.jsp"%>