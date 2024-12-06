<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h1>views/result.jsp</h1>
 	
 	${map }<hr>
 	
 	<h2>이름 : ${map.name } </h2>
 	<h2>메세지 : ${map.msg } </h2>
 	<h3> 파일목록 </h3>
 	<c:forEach var="file"  items="${map.fileList }">
 		<h3><a href="/download?fileName=${file}">${file}</a></h3>
 		<%-- <img src="C:/upload/$ {file }"> --%>
 		<img src="/download?fileName=${file}" width="50" height="50">
 	</c:forEach>
 	
 	<hr>
 	
 	
 	<hr>
 	
 	<a href="/form">다시 파일업로드</a>
 	
 	
 	
 	
 	
</body>
</html>