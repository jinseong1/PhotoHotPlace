<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@include file = "/WEB-INF/views/include/common.jsp"%>
	<%@include file = "/WEB-INF/views/include/Top.jsp"%>
  </head>
  <script>
  
  window.onload = function() {
      div2Resize();
      // 브라우저 크기가 변할 시 동적으로 사이즈를 조절해야 하는경우
      window.addEventListener('resize', div2Resize);
  }  
  
  function div2Resize() {
      $('.picCls').height($('.picCls').width());
  }
  
  function actionSearch(){
	  var moveData = $.trim($('#searchData').val());
	  if(moveData == ''){
		  alert('검색어를 입력하여주세요.');
		  return;
	  }
	  $('#searchMove').submit();
  }
  
  </script>
  <body>
  <form id="searchMove" action ="/moving/searchMainAction" accept-charset="UTF-8" method="post" >
  <div style="margin: 5% 20%;">
      <input type="text" style="min-width: 100px;width:80%; float:left;" id="searchData" name="searchData" class="form-control" placeholder="검색어를 입력하여주세요."/>
      <input type="button" class="btn btn-default" onclick="javascript:actionSearch()" value="검색"/>
  </div>
  </form>
  <div>
  <div style="margin: auto 7%;">
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
     	<div style="width:80%;height:80%; margin:1% 10%">
     	qqqqqqq1111
     	</div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:left;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>
     <div style="width:50%; border-style:dashed;float:right;" class="picCls">
        <div style="background-color: black;width:80%;height:80%; margin:1% 10%">
        qqqqqqq
        </div>
     </div>                                                                       
  </div>
  </div> 
  <div>
     &nbsp;&nbsp;
  </div>
  <%@include file = "/WEB-INF/views/include/Footer.jsp"%>                                               
  </body>
    
</html>