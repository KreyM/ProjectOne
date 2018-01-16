<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%-- <%@ taglib prefix="nav" uri="/WEB-INF/taglibs/navigation.tld" %> --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Front Page HEADER</title>
	
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
<nav class="navbar navbar-inverse" >
<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TINY HOUSE </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/TinyHouseFrontEnd">Home</a></li>
      <!-- <li class="active"><a href="adminList">Admin List</a></li> -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin List
        <span class="caret"></span> </a>
        <ul  class="dropdown-menu">
        <li><a href="${pageContext.request.contextPath }/admin/productList">Product</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/supplierList">Supplier</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/categoryList">Category</a></li>
		</ul>
		</li>	         
              
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            Category Choice <span class="caret"></span>
          </a>      
          
          <ul class="dropdown-menu">
             <c:forEach var="catVal" items="${catList }">
             	<li><a href="${pageContext.request.contextPath }/productCustList?cid=${catVal.cid}">${catVal.cname}</a></li>
             </c:forEach>
          </ul>
        </li>
      
      
      <li><a href="#">Page 3</a></li>
     <li><a href="adding">Admin</a></li>
    </ul>
     <ul class="nav navbar-nav navbar-right">
      <li><a href="goToRegister"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="goToLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
  
</nav>

</body>
</html>