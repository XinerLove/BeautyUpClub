<%@page import="bean.account.Account"%>
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
h1 { font-size: 3.3em;
  background-color: lightblue;
}
h2{ display: block;
  font-size: 1.8em;
  margin-top: 0.83em;
  margin-bottom: 0.83em;
  margin-left: 0;
  margin-right: 0;
  font-weight: bold;
}
</style>

</head>
<body style="background-color:powderblue;">
<h1 style="color:red; text-align:center;">Customer Profile</h1>
<div class="container" style="margin-top:20px; backround-color: lightblue;">
	<div class="row">
		<h2 style="color:red;">Welcome <% out.println(request.getAttribute("fname").toString()); %> <% out.println(request.getAttribute("lname").toString()); %> </h2>
	</div>
	<div class="row">
		<div class="col-md-6" style="color:black;"><h2> Email: <% out.println(request.getAttribute("email").toString()); %></h2> </div>
		<div class="col-md-6" style="color:black;"><h2> City:  <% out.println(request.getAttribute("city").toString()); %></h2></div>
		<div class="col-md-6" style="color:black;"><h2> State: <% out.println(request.getAttribute("state").toString()); %></h2></div>
		<div class="col-md-6" style="color:black;"><h2> Street: <% out.println(request.getAttribute("street").toString()); %></h2></div>
		<div class="col-md-6" style="color:black;"><h2> Country: <% out.println(request.getAttribute("country").toString()); %></h2> </div>
		<div class="col-md-6" style="color:black;"><h2> Zip_Code: <% out.println(request.getAttribute("zipCode").toString()); %></h2></div>
	</div>
</div>
</body>
 
<%@ include file="footer.jsp"%>
</html>