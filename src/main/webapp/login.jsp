<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>
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
<body background="login background.jpg">
	<div align="center">
	<h1 style="color:red">Welcome</h1>
	
		<h2><font face="Arial" size ="100px" color="red">Beauty Up Club</font></h2>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table >
				<tr>
					<th style="color:red; font-size:20pt;">Email</th>
					<td><input type="text" name="email" size="30"/></td>
					
				</tr>
				<tr>
					<th style="color:red; font-size:20pt;">Password</th>
					<td><input type="password" name="password" size="30" /></td>

				</tr>

			</table>
			<input type="submit" size ="40" value="Login" style ="background-color: #AED6F1 ; border: solid 1px #6E6E6E;
				height:30px; front-size:20px; vertical-align:10px; color: #FF5733"/>
			<div style="color: #FF0000;">${errorMessage}</div>
		</form>
	</div>
</body>






<%@ include file="footer.jsp"%>
</html>