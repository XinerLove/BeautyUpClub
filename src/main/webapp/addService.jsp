<%@page import="java.util.Iterator"%>
<%@page import="bean.spa.SPA"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home Page</title>
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
		<h1 style="color:red;">Add Service</h1>
		<form action="<%=request.getContextPath()%>/addService" method="post">
			<table >
				<tr>
					<td style= "color:red; font-size:30px;">Service: 
					</td>
					<td>
						<select name="service">
						  <option value="laser">Laser</option>
						  <option value="massage">Massage</option>
						  <option value="facial">Facial</option>
						</select>
					</td>
					
				</tr>
				<tr>
					<td style= "color:red; font-size:30px;">Type: </td>
					<td><input type="text" name="type" /></td>
				</tr>
				<tr>
					<td style= "color:red; font-size:30px;">Price: </td>
					<td><input type="text" name="price" /></td>
				</tr>
				<tr>
					
				</tr>
				<tr>
					<td>  </td>
					<td><input type="submit" value="Add Service" style ="background-color: #AED6F1 ; border: solid 1px #6E6E6E;
				height:30px; front-size:20px; vertical-align:10px; color: #FF5733"></td>
				</tr>	
			</table>
			
			
			<div style="color: #FF0000;">${serviceErrMessage}</div>
		</form>
	</div>

<script type="text/javascript">
	function goToService(name){
	
		window.location="http://localhost:8080/BeautyUpClub/"+name+".jsp";
	}
</script>
</body>
 
<%@ include file="footer.jsp"%>
</html>