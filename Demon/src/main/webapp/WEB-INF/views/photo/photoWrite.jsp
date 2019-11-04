<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@include file = "/WEB-INF/views/include/common.jsp"%>
	<script type="text/javascript">
	    $(document).ready(function() {
	        pageReadyAction(1);
	    });
	    
	    
	    function pageReadyAction(type,data){
	    	
	    	switch (type) {
	    	
				case 1:
					
					break;
	            case 2:
	                
	                break;
	            case 3:
	                
	                break;                
				default:
					break;
				
			}
	    	
	    	
	    }
	
	    
	    function save(){
	    	
	    	
	    }
	
	</script>
  </head>
  <body>
  <%@include file = "/WEB-INF/views/include/Top.jsp"%>
        <div class="container" style="width:500px;">
            <div class="form-group">
                <label for="exampleInputEmail1">제목</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하여 주세요.">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">내용</label>
                <textarea class="form-control" id="content" name="content" placeholder="이름을 입력하여 주세요." style="height: 300px; "></textarea>
            </div>
			  <div class="form-group">
			    <label for="exampleInputFile">파일 업로드</label>
			    <input type="file" id="exampleInputFile">
			    <p class="help-block">여기에 블록레벨 도움말 예제</p>
			  </div>
			  <input type="button" style="width: 100%;height: 60px;" value="저장하기" onclick="javascript:save()">
         </div>   
            
            <div>
                <br/>
            </div>
  <%@include file = "/WEB-INF/views/include/Footer.jsp"%>
  </body>
</html>