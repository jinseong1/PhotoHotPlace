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
  <script type="text/javascript">
  
  function actionLogin(){
	  
      var jsonData = {}
      
      jsonData.customsId  = $('#customsId').val();
      jsonData.customsPwd = $('#customsPwd').val();
      
      if($.trim(jsonData.customsId) == ''){
          alert('이메일을 입력하여주세요.');
    	  return;
      } else if($.trim(jsonData.customsPwd) == ''){
    	  alert('비밀번호를 입력하여주세요.');
    	  return;
      }
      
      $.ajax({
          url:"/login/customsLogin",
          data:jsonData,
          dataType:'json',
          type:'post',
          success:function(data){
              
          },
          error: function (request, status, error){
              alert('에러가 발생하였습니다. 관리자에게 문의 바랍니다.');
          }
      }); 
  }
  
  function searchId(){
	  
  }
  function searchPwd(){
	  
  }
  function singUp(){
	  location.href = '/moving/singUp';
  }
  
  
  </script>
<body>
	<div>
	    <div class="container" style="width:500px;">
			<form accept-charset="UTF-8" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1" style="text-align: left;">아이디</label>
					<input type="email" class="form-control" id="customsId" name="customsId" placeholder="아이디를 입력하여주세요.">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" style="text-align: left;">비밀번호</label>
					<input type="password" class="form-control" id="customsPwd" name="customsPwd" placeholder="비밀번호를 입력하여 주세요.">
				</div>
				<input type="button" style="width: 100%;height: 60px;" onclick="javascript:actionLogin()" value="로그인" />
			</form>
			<hr>
			<div>
			    <div style="min-width: 300px; text-align: center;" >
			    <a onclick="javascript:searchId()"><span style="color:gray;">아이디 찾기</span></a>
			    |
			    <a onclick="javascript:searchPwd()"><span style="color:gray;">비밀번호 찾기</span></a>
			    |
			    <a onclick="javascript:singUp()"><span style="color:gray;">회원가입</span></a>
			    </div>
			</div>
		</div>
		<div>&nbsp;&nbsp;</div>
	</div>
</body>
<%@include file = "/WEB-INF/views/include/Footer.jsp"%>
</html>