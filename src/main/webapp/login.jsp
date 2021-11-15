<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body background="img/login backaground.jpg">
	<div align="center">
	<h1 style="color:red">Welcome</h1>
	
		<h2><font face="Arial" size ="100px" color="red">Beauty Up Club</font></h2>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table >
				<tr>
					<th>Email: </th>
					<td><input type="text" name="email" size="30"/></td>
					
				</tr>
				<tr>
					<th>Password: </th>
					<td><input type="password" name="password" size="30" /></td>

				</tr>

			</table>
			<input type="submit" value="Login" />
			<div style="color: #FF0000;">${errorMessage}</div>
		</form>
	</div>
</body>
</html>