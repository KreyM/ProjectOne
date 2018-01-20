<%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Front Page Footer</title>
	
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body >

<nav class="navbar navbar-inverse"  >
<div class="container-fluid">
<div class="navbar fixed-bottom" >
  <a class="navbar-brand" href="#">TINY HOUSE </a>
  <ul class="nav navbar-nav">
      <li class="active"><a href="/TinyHouseFrontEnd">Home</a></li>
    <li><a href="admin/adding">Admin</a></li>  
     <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin List
        <span class="caret"></span> </a>
        <ul  class="dropdown-menu">
        <li><a href="${pageContext.request.contextPath }/admin/productList">Product</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/supplierList">Supplier</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/categoryList">Category</a></li>
		</ul>
		</li>
  </ul>  
  <ul class="nav navbar-nav navbar-right">

   
	 <li><a href="https://www.facebook.com/"> <span class="fa fa-facebook"> </span> Facebook </a> </li>
	 <li><a href="https://twitter.com/"> <span class="fa fa-twitter"> </span> Twitter </a> </li>
	 <li><a href="https://in.linkedin.com/"> <span class="fa fa-linkedin"> LinkedIn </span></a>
	 <li><a href="https://in.pinterest.com/"> <span class="fa fa-pinterest"> Pinterest </span></a>
	 <li><a href=""> <span class=""> </span></a>
	 <li><a href=""> <span class=""> </span></a>
	 <li><a href=""> <span class=""> </span></a>
    </ul>
    
</div>
</div>
	</nav>
</body>
</html>