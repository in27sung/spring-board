<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  contentType="text/html; charset=UTF-8" %>

<%@ include file="include/header.jsp"%>

<!-- 본문 내용 -->
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<hr>

<input type="button" value="버튼1" class="btn-lg btn-success btn-mycolor"> <br>
<button>버튼2</button>

<a class="btn btn-app">
	<i class="fa fa-play"></i> Play
 </a>
 
 <a class="btn btn-block btn-social btn-github">
                <i class="fa fa-github"></i> Sign in with GitHub
      </a>


<!-- 본문 내용 -->

<%@ include file="include/footer.jsp"%>
