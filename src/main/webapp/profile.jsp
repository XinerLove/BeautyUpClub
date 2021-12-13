<%@page import="bean.services.Laser"%>
<%@page import="bean.services.Facial"%>
<%@page import="bean.services.Massage"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Profile</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<%@ include file="header.jsp"%>
<style type="text/css">
	.carousel {
    cursor: pointer;
}
h3{ font-size: 1.9em;

color: red;}
.card {
	background-color: lightblue; !important;
}
.container{
	padding-bottom: 80%;
}


</style>

</head>
<body style="background-color:powderblue;">

	<div class="container"  style="width:100%; height: 200px;">
		<div class="row">
			<div class="col-md-12" style="text-align:center;"><h1 style="color: red;"><% out.println(request.getAttribute("name")+" Store");%></h1></div>
			<div class="col-md-12" style="text-align:right;"><a href="addService.jsp" class="btn btn-primary">Add Services</a> </div>
		</div>
		
	
		<div class="row" style="justify-content: center; text-align: center;">
		
		    <div class="col-md-8" >
		    	<div class="card">
				      <div class="card-body">
				     	 
				        <h5 class="card-title"><h3>Email: <% out.println(request.getAttribute("email"));%></h3></h5>
				        <p class="card-text"><h3>Phone: <% out.println(request.getAttribute("phone"));%></h3></p>
				        <p class="card-text"><h3>License: <% out.println(request.getAttribute("license"));%></h3></p>
				       
				      </div>
				    </div>
		    <h3></h3>
		    </div>
		</div>
		<br />
		
			<div class="row">
			<div class="col-md-12" style="text-align:center;">
			
			
			
<h3>Massage Services</h3>
</div>
			</div>
	
		 	<div class="row">
		 		<%
		ArrayList<Massage> allServices = new ArrayList<Massage>();
			allServices = (ArrayList<Massage>)request.getAttribute("massageServices");
		
		if(allServices == null){
			%>
			<div class="col-sm-6">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title"><% out.println(" No Service"); %></h5>
			       
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
				     	 <div>
				     	 	<form action="<%=request.getContextPath()%>/edit-service" method="get" style="float: right;">				  
				        	<input style="display:none;" type="text" name="id" value="<% out.println((service.getId())); %>"></input>
				        	<input style="display:none;" type="text" name="type" value="<% out.println("massage"); %>"></input>
				        	<input type="submit" value="edit"></input>
				        	</form>
				     	 </div>
				        <h5 class="card-title"><% out.println(service.getType());%></h5>
				        <p class="card-text"><% out.println("$"+service.getPrice()); %></p>
				       
				      </div>
				    </div>
				  </div>
				<% 
			}
		}
%>
		 		
		 	</div>
		 	
		 	<br />
			<div class="row">
	<div class="col-md-12" style="text-align:center;">
<h3>Facial Services</h3>
</div></div>
		 	<div class="row">
			 

<%
		ArrayList<Facial> facialServices = new ArrayList<Facial>();
			facialServices = (ArrayList<Facial>)request.getAttribute("facialServices");
		
		if(facialServices == null){
			%>
			<div class="col-sm-6">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title"><% out.println(" No Service"); %></h5>
			       
			      </div>
			    </div>
			  </div>
			<% 
		}else{
			for(Facial service : facialServices){
				%>
				<div class="col-sm-6">
				    <div class="card">
				      <div class="card-body">
				      	<div>
				     	 	<form action="<%=request.getContextPath()%>/edit-service" method="get" style="float: right;">				  
				        	<input style="display:none;" type="text" name="id" value="<% out.println((service.getId())); %>"></input>
				        	<input style="display:none;" type="text" name="type" value="<% out.println("facial"); %>"></input>
				        	<input type="submit" value="edit"></input>
				        	</form>
				     	 </div>
				        <h5 class="card-title"><% out.println(service.getType()); %></h5>
				        <p class="card-text"><% out.println("$"+service.getPrice()); %></p>
				       
				      </div>
				    </div>
				  </div>
				<% 
			}
		}
%>

</div>
<br />
<div class="row">
	<div class="col-md-12" style="text-align:center;">
<h3>Laser Services</h3>
</div>
			</div>
		 	<div class="row">
<%
		ArrayList<Laser> laserServices = new ArrayList<Laser>();
laserServices = (ArrayList<Laser>)request.getAttribute("laserService");
		
		if(laserServices == null){
			%>
			<div class="col-sm-6">
			    <div class="card">
			      <div class="card-body">
			        <h5 class="card-title"><% out.println(" No Service"); %></h5>
			       
			      </div>
			    </div>
			  </div>
			<% 
		}else{
			for(Laser service : laserServices){
				%>
				<div class="col-sm-6">
				    <div class="card">
				      <div class="card-body">
				      	<div>
				     	 	<form action="<%=request.getContextPath()%>/edit-service" method="get" style="float: right;">				  
				        	<input style="display:none;" type="text" name="id" value="<% out.println((service.getId())); %>"></input>
				        	<input style="display:none;" type="text" name="type" value="<% out.println("laser"); %>"></input>
				        	<input type="submit" value="edit"></input>
				        	</form>
				     	 </div>
				        <h5 class="card-title"><% out.println(service.getType()); %></h5>
				        <p class="card-text"><% out.println("$"+service.getPrice()); %></p>
				       
				      </div>
				    </div>
				  </div>
				<% 
			}
		}
%>
</div>
		</div>
	</div>





</body>
 
<%@ include file="footer.jsp"%>
</html>