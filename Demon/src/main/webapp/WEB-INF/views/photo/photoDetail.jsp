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
	
	
	</script>
  </head>
  <body>
  <%@include file = "/WEB-INF/views/include/Top.jsp"%>
  <div>
  
  </div>
  <%@include file = "/WEB-INF/views/include/Footer.jsp"%>
  </body>
</html>