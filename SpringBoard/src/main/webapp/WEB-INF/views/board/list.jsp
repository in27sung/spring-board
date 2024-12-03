<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %>

        <h1>/views/board/list.jsp</h1>
        
<%--         ${boardList } --%>
        pageVO : ${pageVO }<br>
        result : ${result }<br>
        <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">게시판 리스트</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered">
                <tbody><tr>
                  <th style="width: 50px">번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th style="width: 60px">조회수</th>
                </tr>
                
                <c:forEach var="vo" items="${boardList }">
	                <tr>
	                  <td>${vo.bno }</td>
	                  <td>
	                  	 <a href="/board/read?bno=${vo.bno }&page=${pageVO.cri.page}&pageSize=${pageVO.cri.pageSize}">${vo.title }</a>
	                  </td>
	                  <td>${vo.writer }</td>
	                  <td>
	                      <fmt:formatDate value="${vo.regdate }" pattern="yy/MM/dd"/>  
	                  </td>
	                  <td>
		                  <span class="badge bg-red">
		                  	${vo.viewcnt }
		                  </span>
	                  </td>
	                </tr>
                </c:forEach>
                
              </tbody></table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <ul class="pagination pagination-sm no-margin pull-right">
                
                <c:if test="${pageVO.prev }">
                	<li><a href="/board/listCri?page=${pageVO.startPage-1 }">«</a></li>
                </c:if>
                
                <c:forEach var="i" begin="${pageVO.startPage }" 
                           end="${pageVO.endPage }"
                           step="1">
                	<li 
	                	<c:if test="${i == pageVO.cri.page }">
	                		class="active"
	                	</c:if>
	                	<%-- $ {(i == pageVO.cri.page)? "class='active'":""} --%>
                	><a href="/board/listCri?page=${i }">${i }</a></li>
                </c:forEach>
                
                <c:if test="${pageVO.next }">
                	<li><a href="/board/listCri?page=${pageVO.endPage + 1}">»</a></li>
                </c:if>
                
              </ul>
            </div>
          </div>
          
          
          <script type="text/javascript">
          	  // JSP(JAVA) - JSTL/EL - HTML - JavaScript/Jquery
          	  // 글쓰기 성공했을때만
          	  // 메세지 실행가능하도록    
          	  var result = "${result}";
          	  
          	  if(result == "registOK"){
				  alert(" 글쓰기 성공! ");
          	  }
          	  
          	  if(result == "modifyOK"){
          		  alert(" 글수정 성공! ");
          	  }
          
          </script>
          
          
        
        
        
<%@ include file="../include/footer.jsp" %>