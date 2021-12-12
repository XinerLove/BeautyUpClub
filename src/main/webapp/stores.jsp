<%@page import="bean.spa.SPA"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Stores</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<%@ include file="header.jsp"%>
<style type="text/css">
	.carousel {
    cursor: pointer;
}
.container{
	padding-bottom: 5%;
}

</style>

</head>
<body style="background-color:powderblue;">
<div class="container">

<div class="row">
	<%
		ArrayList<SPA> spaList = new ArrayList<SPA>();
		spaList = (ArrayList<SPA>)request.getAttribute("allSpa");
		
		if(spaList == null){
			
		}else{
			for(SPA spa : spaList){
				%>
				<div class="col-sm-6">
				    <div class="card" style="background: red;">
				     <% String path = "https://cdn.pixabay.com/photo/"+spa.getImage(); %>
				     <img class="card-img-bottom" src="<% out.println(path); %>" alt="Card imge">
				    
				      <div class="card-body">
				        <h2 class="card-title"><% out.println(spa.getName()); %> </h2>
				        <p class="card-text"><% out.println(spa.getPhone()); %> </p>
				        <form action="<%=request.getContextPath()%>/singleSpa" method="get">				  
				        	<input style="display:none;" type="text" name="id" value="<% out.println(spa.getId()); %>"></input>
				        	<input style = "color:red; background: pink"; type="submit" value="Go to <% out.println(spa.getName()); %> Store"></input>
				        </form>
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