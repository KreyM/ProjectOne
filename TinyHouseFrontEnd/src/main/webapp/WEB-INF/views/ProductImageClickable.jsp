
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Alternate Living</title>
	
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
	<div id="myCarousel1" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel1" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel1" data-slide-to="1" ></li>
			<li data-target="#myCarousel1" data-slide-to="2" ></li>
		</ol>
		
		<div class="carousel-inner">
			<div class="item active" class="img-responsive center block">
			<a href="http://localhost:8080/TinyHouseFrontEnd/prodDetails/8"><img   alt="1" src="D:/frontend/TinyHouseFrontEnd/src/main/resources/chairs.jpg" align="center" width="50%" height="45 " ></a>	
			</div>
			
			<!-- http://localhost:8080/TinyHouseFrontEnd/prodDetails/38 -->
			<div class="item">
			<a href="http://localhost:8080/TinyHouseFrontEnd/prodDetails/38"> <img   alt="2" src="D:/frontend/TinyHouseFrontEnd/src/main/resources/handy dishwasher.jpg" align="center" width="50%" height="45 " ></a>	
			</div>
			<div class="item">
			<a href="http://localhost:8080/TinyHouseFrontEnd/prodDetails/110"> <img   alt="3" src="D:/frontend/TinyHouseFrontEnd/src/main/resources/sofa.jpg" align="center" width="50%" height="45 " ></a>	
			</div>
		</div>
		
		 
		 
		 
		<!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel1" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel1" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
  </div>
  
  </div>
  
</body>
</html>

