
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	.carousel {
    cursor: pointer;
}
body{ background-repeat: no repeat;
background-size: cover;
}
</style>


<title>SPA Infor</title>
</head>
<body background="cc1.png">
	<div align="center">
		<h1>Create SPA information</h1>
		<form action="<%=request.getContextPath()%>/spaCreation" method="post">
			<table >
				<tr>
					<th>SPA Name: </th>
					<td><input type="text" name="spa_name" /></td>
					
				</tr>
				<tr>
					<th>Street: </th>
					<td><input type="text" name="street" /></td>
					<tr>
					<th>City: </th>
					<td>
						<select name="city">
						  <option value="Marlboro">Marlboro</option>
						  <option value="New York">New York</option>
						  <option value="Los Angeles">Los Angeles</option>
						  <option value="Chicago">Chicago</option>
						  <option value="Houston">Houston</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>State: </th>
					<td>
						<select name="state">
						  <option value="New Jersey">New Jersey</option>
						  <option value="New York">New York</option>
						  <option value="California">California</option>
						  <option value="Illinois">Illinois</option>
						  <option value="Texas">Texas</option>
						</select>
					</td>
					<tr>
					<th>Zip code: </th>
					<td>
						<input type="text" name="zip_code"/>
					</td>
				</tr>
				<tr>
				<th>Country: </th>
				
				<td><input type ="text" name="country"  /><td>
				</tr>
				
				<tr>
					<th>License Number: </th>
					<td><input type="text" name="spa_licenece" /></td>
				</tr>
				<tr>
					<th>Phone Number: </th>
				<td> <input type="text" name="spa_phone" /></td>
				
				
				
				
				<tr>
					<td> <input type="submit" value="Create SPA"/></td>
					
				</tr>		
			</table>
			
			
			<div style="color: #FF0000;">${spaErrMessage}</div>
		</form>
	</div>
</body>
</html>



