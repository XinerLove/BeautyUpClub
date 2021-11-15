<%@page import="java.sql.PreparedStatement"%>
<%@page import="Database.DatabaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="homePage.jsp"><img src="C:\Users\georg\eclipse-workspace2\BeautyUpClub\src\main\webapp\img\lastlogo.jpg" width="150" height="80" class="d-inline-block align-top" alt=""></a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/">Home <span class ="sr-only"> </span></a>
       
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/spas">SPA Stores</a>
      </li>
     
    </ul>
    <form id="searchForm" class="form-inline my-2 my-lg-0">
   			<input class="form-control mr-sm-2" id="searchInput"  type="search" placeholder="Search" aria-label="Search">
	       <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      
    </form>
    <script>
    	
    </script>
   <div class="ml-2">
     <% 
     HttpSession session2 = request.getSession();
      if(session2.getAttribute("auth") == "pass"){
    	  %>
    	  <form action="<%=request.getContextPath()%>/gologout" method="get">
	        	<input type="submit" value="Logout">
          </form>
    	  <%
      }else{
    	  %>
    	    <a class="btn btn-light" href="login.jsp">Login <span class="sr-only">(current)</span></a>
    		<a class="btn btn-secondary" href="Account.jsp">Signup <span class="sr-only">(current)</span></a>
    	  <%
      }
     %>
    	
    </div>
    
    
  </div>
</nav>