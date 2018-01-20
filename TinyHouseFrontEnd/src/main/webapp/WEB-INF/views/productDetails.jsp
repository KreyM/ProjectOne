<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
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
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<div class="row">
	<div class="col-md-1" >
		
		<h1>${prod.pname }</h1>
	</div>
		<div class="col-sm-4 item-photo" >
		<h3>Product Image</h3> 	<img src="D:/frontend/TinyHouseFrontEnd/src/main/resources/${p.imgName}" height="45%" width="100%"></div>
		<div class="col-sm-5" >
			<h3>Product : ${prod.pname }</h3>
			<h3>Description : ${prod.description }</h3>
			<h3>Price : ${prod.price }</h3>
			<h3>Stock : ${prod.stock }</h3>
			<h3>Supplier : ${prod.supplierName }</h3>
			<h3>Category : ${prod.cname }</h3> <br>	<br>
		</div>
			
		<div class="section" style="padding-left: 5px">
			<form action="${pageContext.request.contextPath }/ addToCart" method="post">
			  <input type="hidden" value="${prod.pid }" name="pid"/> 
			 <input type="hidden" value="${prod.price }" name="price"/> 
			  <input type="hidden" value="${prod.pname }" name="pname"/> 
			   <input type="hidden" value="${prod.imgName }" name="imgName"/> 
			    <input type="number" class="form-control" name="pQty"/> 
			     <input type="submit" value="Add To Cart" class="btn btn-primary btn-lg"/> 
			</form>
		</div>				
</div>		
		
<br><br>
	<div class="col-md-5">
	  <h3>Product Details</h3>
	  <ul><li>All the items sold in this site are eco-friendly</li>
	  <li> They are made in such a way that they have zero - impact </li>
	  <li> Help us in reducing the carbon footprints</li>
	  </ul>
	</div>					
</div>		

</body>
</html>