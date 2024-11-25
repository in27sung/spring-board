<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- headerFile -->
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>

<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 리스트</h3>
	</div>
	<!-- /.box-header -->
	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 50px">번호</th>
					<th>제목</th>
					<th style="width: 80px">작성자</th>
					<th style="width: 80px">작성일</th>
					<th style="width: 80px">조회수</th>
				</tr>
				<tr>
					<c:forEach var="boardList" items="${boardList}">
						<tr>
							<td>${boardList.bno}</td>
							<td>${boardList.title}</td>
							<td>${boardList.writer}</td>
							<td>
								<fmt:formatDate value="${boardList.regdate}" pattern="yyyy/MM/dd"/> 
							</td>
							<td>
							<span class="badge bg-red">
								${boardList.viewcnt}
								</span>
							</td>
						</tr>
					</c:forEach>
		</table>
	</div>
	<!-- /.box-body -->
	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
			<li><a href="#">«</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">»</a></li>
		</ul>
	</div>
</div>




<!-- footerFile -->
<%@ include file="../include/footer.jsp"%>