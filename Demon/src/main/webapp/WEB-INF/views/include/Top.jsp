<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!-- Top source Start -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <!-- Brand Name start -->
      <a class="navbar-brand" href="/">포토 핫플</a>
      <!-- Brand Name end -->
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
     </ul>
     <% 
        if((String)session.getAttribute("C_ID") != null){
     %> 
    <a href="javascript:logout()">
     <button type="button" style="float: right;" class="btn btn-default navbar-btn">Log Out</button>
    </a>
     <% } else {%>
    <a href="javascript:loginPageMove()">
     <button type="button" style="float: right;" class="btn btn-default navbar-btn">Sign in</button>
    </a>
    <%} %>
     
    </div>
  </div>
</nav>
<!-- Top source End -->