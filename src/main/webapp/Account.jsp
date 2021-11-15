<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="img/login backaground.jpg">
	<div align="center">
		<h1>Create Account</h1>
		<form action="<%=request.getContextPath()%>/account" method="post">
			<table >
				<tr>
					<th>First Name</th>
					
					<td><input type="text" name="fname" /></td>
					
					<th>Last Name: </th>
					
					<td><input type="text" name="lname" /></td>
					
				</tr>
				<tr>
				
					<th>Email: </th>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
				<th>Password:</th>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
				<th>Confirm Password: </th>
					<td><input type="password" name="confirm_password" /></td>
					
				</tr>
				

				
				<tr>
				<td>   </td>	
				<th><input type="submit" value="Sign Up as Spa" name = "type"/></th>	
				<th><input type="submit" value="Sign Up as customers" name = "type"/></th>
				</tr>
			</table>
			
			<div style="color: #FF0000;">${accErrMessage}</div>
		</form>
	</div>
</body>
</html>

