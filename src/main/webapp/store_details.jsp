<%@page import="bean.services.Facial"%>
<%@page import="bean.services.Laser"%>
<%@page import="bean.services.Massage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Database.DatabaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Store Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<link rel="dns-prefetch" href="//fonts.gstatic.com">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<%@ include file="header.jsp"%>
<style type="text/css">
	.carousel {
    cursor: pointer;
}
h1 {
  background-color: lightblue;
}
h2{ font color="red"
}
</style>

</head>
<body>
<div class="container" style="padding-block:10px;">
	<div class="row">
		<div class="col-lg-12" style="color:red; text-align:center;"><h1><b><% out.println(request.getAttribute("name")); %> Details Page</b></h1></div>
	</div>
	<br />
	<div class="row">
		<div class="col-lg-6"><h2>Email: <% out.println(request.getAttribute("email")); %> </h2></div>
		<div class="col-lg-6"><h2>Phone Number: <% out.println(request.getAttribute("phone")); %> </h2></div>
	</div>
	<div class="row">
		<div class="col-lg-6"><h2>License Number: <% out.println(request.getAttribute("license")); %> </h2></div>
		<div class="col-lg-6"><h2>Zip_code: <% out.println(request.getAttribute("zipcode")); %> </h2></div>
	</div>
	<div class="row">
		<div class="col-lg-6"><h2>City: <% out.println(request.getAttribute("city")); %> </h2></div>
		<div class="col-lg-6"><h2>State: <% out.println(request.getAttribute("state")); %> </h2></div>
	</div>
	
	<div class="row">
		<div class="col-lg-6"><h2>SPA Id: <% out.println(request.getAttribute("spa_id")); %> </h2></div>
		<div class="col-lg-6"><h2>Country: <% out.println(request.getAttribute("country")); %> </h2></div>
	</div>

</div>
<div class="container" style="margin-top:20px;">
	<div class="row">
		<div class="col-lg-12" style="color:red; text-align:center;"><h1><b>Massage Services</b></h1></div>
		<%
		ArrayList<Massage> allServices = new ArrayList<Massage>();
			allServices = (ArrayList<Massage>)request.getAttribute("massageServices");
		
		if(allServices == null){
			%>
			<div class="col-sm-6">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title"><% out.println(" No Massage Service"); %></h5>
			       
			      </div>
			    </div>
			  </div>
			<% 
		}else{
			for(Massage service : allServices){
				%>
				<div class="col-sm-6">
				    <div class="card">
				      <div class="card-body">
				        <h5 class="card-title"><% out.println(service.getType()); %></h5>
				        <p class="card-text"><% out.println(service.getPrice()); %></p>
				       
				      </div>
				    </div>
				  </div>
				<% 
			}
		}
	%>
	</div>
	
	<div class="row">
		<div class="col-lg-12" style="color:red; text-align:center;"><h1><b>Facial Services</b></h1></div>
		<%
		ArrayList<Facial> allFacialServices = new ArrayList<Facial>();
		allFacialServices = (ArrayList<Facial>)request.getAttribute("facialServices");
		
		if(allFacialServices == null){
			%>
			<div class="col-sm-6">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title"><% out.println(" No Facial Service"); %></h5>
			       
			      </div>
			    </div>
			  </div>
			<% 
		}else{
			for(Facial service : allFacialServices){
				%>
				<div class="col-sm-6">
				    <div class="card">
				      <div class="card-body">
				        <h5 class="card-title"><% out.println(service.getType()); %></h5>
				        <p class="card-text"><% out.println(service.getPrice()); %></p>
				       
				      </div>
				    </div>
				  </div>
				<% 
			}
		}
	%>
	</div>
	
	<div class="row">
		<div class="col-lg-12" style="color:red; text-align:center;"><h1><b>Laser Services</b></h1></div>
		<%
		ArrayList<Laser> allLaserServices = new ArrayList<Laser>();
		allLaserServices = (ArrayList<Laser>)request.getAttribute("laserServices");
		
		if(allLaserServices == null){
			%>
			<div class="col-sm-6">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title"><% out.println(" No Laser Service"); %></h5>
			       
			      </div>
			    </div>
			  </div>
			<% 
		}else{
			for(Laser service : allLaserServices){
				%>
				<div class="col-sm-6">
				    <div class="card">
				      <div class="card-body">
				        <h5 class="card-title"><% out.println(service.getType()); %></h5>
				        <p class="card-text"><% out.println(service.getPrice()); %></p>
				       
				      </div>
				    </div>
				  </div>
				<% 
			}
		}
	%>
	</div>
</div>

</body>
 
<%@ include file="footer.jsp"%>
</html>