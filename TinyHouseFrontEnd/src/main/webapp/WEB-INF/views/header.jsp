<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<style>
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/aboutUs">TINY HOUSE </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/TinyHouseFrontEnd">Home</a></li>
      <!-- <li class="active"><a href="/admin/adminList">Admin List</a></li> -->
     
     
     <security:authorize access="hasRole('ROLE_ADMIN')">
      <div class="dropdown">
       <button class="dropbtn">Admin List <span class="caret"></span></button>
        
		 <ul class="dropdown-content">
        <li><a href="${pageContext.request.contextPath }/admin/productList">Product</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/supplierList">Supplier</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/categoryList">Category</a></li>
		</ul>
		</div>	         
            </security:authorize>  
        <li class="dropdown">
          <a class="dropdown-hover" data-hover="dropdown" href="#">
            Category Choice <span class="caret"></span>
          </a>      
          
          <ul class="dropdown-content">
             <c:forEach var="catVal" items="${catList }">
             	<li><a href="${pageContext.request.contextPath }/productCustList?cid=${catVal.cid}">${catVal.cname}</a></li>
             </c:forEach>
          </ul>
          
        </li>
      
      
      <li><!-- <a href="#">Page 3</a> --></li>
<security:authorize access="hasRole('ROLE_ADMIN')">
     <li><a href="admin/adding">Admin</a></li>
</security:authorize>
    </ul>
    
     <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name==null }"> 
     <li><a href="goToLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="goToRegister"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     
     </c:if>
     
     <c:if test="${pageContext.request.userPrincipal.name!=null }">
     <security:authorize access="hasRole('ROLE_USER')">
     <li><a href="${pageContext.request.contextPath }/goToCart"> My Cart <i class="fa fa-shopping-cart" aria-hidden="true"></i></a> </li>
    		</security:authorize>
    	 <li><a>Let's Go Tiny,${pageContext.request.userPrincipal.name} </a></li>
     		<li><a href="${pageContext.request.contextPath }/logout"> Logout, Bye</a></li>
     	
     </c:if>
    </ul>
    
    <br>
    <br>
    
    
  </div>
  
</nav>
<hr>

</body>
</html><%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/aboutUs">TINY HOUSE </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/TinyHouseFrontEnd">Home</a></li>
      <!-- <li class="active"><a href="/admin/adminList">Admin List</a></li> -->
     
     
     <security:authorize access="hasRole('ROLE_ADMIN')">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin List
        <span class="caret"></span> </a>
        <ul  class="dropdown-menu">
        <li><a href="${pageContext.request.contextPath }/admin/productList">Product</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/supplierList">Supplier</a></li>
         <li><a href="${pageContext.request.contextPath }/admin/categoryList">Category</a></li>
		</ul>
		</li>	         
            </security:authorize>  
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
      
      <!-- 
      <li><a href="#">Page 3</a></li> -->
<security:authorize access="hasRole('ROLE_ADMIN')">
     <li><a href="admin/adding">Admin</a></li>
</security:authorize>
    </ul>
    
     <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name==null }"> 
     <li><a href="${pageContext.request.contextPath }/goToLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="${pageContext.request.contextPath }/goToRegister"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     
     </c:if>
     
     <c:if test="${pageContext.request.userPrincipal.name!=null }">
     <security:authorize access="hasRole('ROLE_USER')">
     <li><a href="${pageContext.request.contextPath }/goToCart"> My Cart <i class="fa fa-shopping-cart" aria-hidden="true"></i></a> </li>
    		</security:authorize>
    	 <li><a>Let's Go Tiny,${pageContext.request.userPrincipal.name} </a></li>
     		<li><a href="${pageContext.request.contextPath }/logout"> Logout, Bye</a></li>
     	
     </c:if>
    </ul>
    
    <br>
    <br>
    
    
  </div>
  
</nav>
<hr>

</body>
</html> --%>