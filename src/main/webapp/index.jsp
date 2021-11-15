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
<body>
<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div onclick="goToService('massage-services')" class="carousel-item active">
      <img src="C:\Users\georg\eclipse-workspace2\BeautyUpClub\src\main\webapp\img\spa2.jpeg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5 style = "color:red; font-size:40px;">Massage Services</h5>
        <p style ="color:red">"Get any Service related to Massage here you Want".</p>
      </div>
    </div>
    <div onclick="goToService('facial-services')"class="carousel-item">
      <img src="C:\Users\georg\eclipse-workspace2\BeautyUpClub\src\main\webapp\img\spa3.jpeg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5 style = "color:red; font-size:40px;">Facial Services</h5>
        <p style ="color:red">"Get any Service related to Facial here you Want"".</p>
      </div>
    </div>
    <div onclick="goToService('laser-services')"class="carousel-item">
      <img src="C:\Users\georg\eclipse-workspace2\BeautyUpClub\src\main\webapp\img\spa1.jpeg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5 style = "color:red; font-size:40px;">Laser Services</h5>
        <p style ="color:red; font-size: 18px;">"Get any service related to Laser you want".</p>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<br>




<script type="text/javascript">
	function goToService(name){
	
		window.location="http://localhost:8080/BeautyUpClub/"+name;
	}
</script>
</body>
 
<%@ include file="footer.jsp"%>
</html>