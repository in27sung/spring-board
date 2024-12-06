<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var cnt = 1;
		
		//alert("제이쿼리 실행!");
		$("#btnAdd").click(function(){
			//alert(" 버튼 클릭! ");
			// 첨부파일 업로드가능한 input태그를 추가(divFile영역에)
			$("#divFile").append("첨부파일 : <input type='file' name='file"+cnt+"'> <br> ");			
			cnt++;
		});
	});

</script>
</head>
<body>
	<h1>views/form.jsp</h1>
	
	<h2> 파일 업로드 페이지 (다중 파일업로드) </h2>

	<fieldset>
		<form action="/upload" method="post" enctype="multipart/form-data">
			이름 : <input type="text" name="name"> <br>
			메세지 : <input type="text" name="msg"> <br>
			
			<div id="divFile">
			</div>			
			<hr>
			
			<input type="button" id="btnAdd" value=" 첨부파일 업로드 추가 ">
			
			<!-- 첨부파일 : <input type="file" name="file"> <br> -->
			
			<input type="submit" value="파일 업로드">		
		</form>
	</fieldset>
	
	
	
	
	
	
	
	
</body>
</html>