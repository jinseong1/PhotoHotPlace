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
  var latitude;
  var longitude;
  $(document).ready(function() {
	  navigator.geolocation.getCurrentPosition(function(pos) {
		  latitude = pos.coords.latitude;
		  longitude = pos.coords.longitude;
	  });
	  pageReadyAction(1);
  });
  
  window.onload = function() {
	  divPhoto();
      divMap();
      // 브라우저 크기가 변할 시 동적으로 사이즈를 조절해야 하는경우
      window.addEventListener('resize', divMap);
      window.addEventListener('resize', divPhoto);
  }  
  
  function divPhoto() {
      $('.divPhoto').height($('.divPhoto').width());
  }
  function divMap(){
	  $('.divMap').height($('.divMap').width());
  }
  
  function actionSearch(){
      if($.trim($('#searchData').val()) == ''){
          alert('검색어를 입력하여주세요.');
          return;
      }
      $('#searchMove').submit();
  }
  
  function pageReadyAction(type, data){
	  
	  switch (type) {
	      case 1:
	    	  
	    	  var jsonData = {}
	    	  jsonData.searchData = '${searchData}';
	    	  
	          $.ajax({
	              url:"/phothList/getSearchList",
	              data:{'searchData':'${searchData}'},
	              dataType:'text',
	              type:'post',
	              success:function(key){
	            	  $('#listId').html(key);
	            	  
	              },
	              error: function (request, status, error){                
                      alert('에러가 발생하였습니다. 관리자에게 문의 바랍니다.');
                  }
	          }); 
	    	  
		break;

	    case 2:
	    	data = '1';
	    	$('#no').val(data);
	    	$('#detailMove').submit();

		break;
   
		case 3:
			break;
			
		default:
			break;
	}
	  
  }
  
  
  // detail photo Click function Action Detail Page 
  function photClickAction(){
	  
	  
	  
  }
  
  </script>  
  <body>
  <form id="detailMove" action="/moving/photoDetail" accept-charset="UTF-8" method="post" >
      <input type="hidden" id ="no" name ="no" value = ""/>
  </form>
  <form id="searchMove" action ="/moving/searchMainAction" accept-charset="UTF-8" method="post" >
  <div style="margin: 5% 20%;">
      <input type="text" style="min-width: 100px;width:80%; float:left;" id="searchData" name="searchData" class="form-control" placeholder="검색어를 입력하여주세요."/>
      <input type="button" class="btn btn-default" onclick="javascript:actionSearch()" value="검색"/>
  </div>
  </form>
  <div>
     <!-- map start -->
	  <div style="margin: auto 7%;">
	     <div>
	        <div id="map"style="width: 100%;" class="divMap"></div>
	     </div>  
	     <br/>
	  </div>
	  <!-- map end -->
	  
	  <!-- photo list start -->
	  <div style="margin: auto 7%;" id="listId">
	  </div>
	   <!-- photo list end -->
	   
  </div> 
  
  <br/>
  <script>
      function initMap() {
    	  // The location of Uluru
    	  var uluru = {lat: latitude, lng: longitude};
    	  // The map, centered at Uluru
    	  var map = new google.maps.Map(
    	      document.getElementById('map'), {zoom: 6, center: uluru});
    	  // The marker, positioned at Uluru
    	  var marker;
    	  
    	  var locations = [ 
		      ['명동', 37.563576, 126.983431],
		      ['가로수길', 37.520300, 127.023008],
		      ['광화문', 37.575268, 126.976896],
		      ['남산', 37.550925, 126.990945],
		      ['이태원', 37.540223, 126.994005]
		    ];
    	  
    	  for (i = 0; i < locations.length; i++) {
			  marker = new google.maps.Marker({
			      position: new google.maps.LatLng(locations[i][1], locations[i][2]),
			      map: map
			  });
		  }    	  
    	  new google.maps.Marker({position: marker, map: map});
      }
  </script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAl2qSxjcq_mErcApOpiXJsotFzpFkOFFc&callback=initMap" async defer></script>  
  <%@include file = "/WEB-INF/views/include/Footer.jsp"%>
  </body>
</html>