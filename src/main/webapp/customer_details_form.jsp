<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Create Account</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<%@ include file="header.jsp"%>
<style type="text/css">
	.carousel {
    cursor: pointer;
}
</style>
</head>
<body background="login backaground.jpg">
	<div align="center">
		<h1 style="color:red;">Provide the following information to complete signup</h1>
		<form action="<%=request.getContextPath()%>/account-details" method="post">
			<table >
				<tr>
					  <th style="color:red; font-size:20pt;">Street</th>
					
					<td><input type="text" name="street" /></td>
					
					  <th style="color:red; font-size:20pt;">City</th>
					
					<td><input type="text" name="city" /></td>
					
				</tr>
				<tr>
				  <th style="color:red; font-size:20pt;">State</th>
					<td><input type="text" name="state" /></td>
				</tr>
				<tr>
				  <th style="color:red; font-size:20pt;">Country</th>
					<td><input type="text" name="country" /></td>
				</tr>
				<tr>
				  <th style="color:red; font-size:20pt;">Zip Code</th>
					<td><input type="text" name="zip_code" /></td>
					
				</tr>
				

				
				<tr>
				<td>   </td>	
				<th><input type="submit" size ="40" value="Sign Up as Spa" style ="background-color: #AED6F1 ; border: solid 1px #6E6E6E;
				height:30px; front-size:20px; vertical-align:10px; color: #FF5733" name= "type"/></th>	
				<th><input type="submit" size="40" value="Sign Up as customers"   size ="40" value="Sign Up as Spa" style ="background-color: #AED6F1 ; border: solid 1px #6E6E6E;
				height:30px; front-size:20px; vertical-align:10px; color: #FF5733" name = "type"/></th>
				</tr>
			</table>
			
			<div style="color: #FF0000;">${accErrMessage}</div>
		</form>
	</div>
</body>

<body>
 <div id="page-container">
   <div id="content-wrap">
     <!-- all other page content -->
   </div>
   <%@ include file="footer.jsp"%>
 </div>
</body>
</html>

