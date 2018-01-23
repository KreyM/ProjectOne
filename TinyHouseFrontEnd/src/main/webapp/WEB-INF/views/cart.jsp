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
 <table class="table table-hover" id="ap1" class="display" border="2" width="80" align="center">
   		<tr>
	   		<th>Serial No.</th>
	  <!--  		<th>Product ID</th> -->
	   		<th> Product Name</th>
	   		<th>Product Quantity </th>
	   		<th>Product Supplier </th>
	   		<th>Price</th>
	   		<th>Image</th>
	   		<th>Subtotal</th>
	   		<th>Action</th>
   		</tr>
   		<c:if test="${empty prodList }">
   		  <tr> 
   		    <td colspan="9" align="center"> No record found :( </td>
   		  </tr>  
   		</c:if>
   		
   		<c:forEach var="p" varStatus="st" items="${cartInfo}">
   		  <tr>
   		 	<td> <c:out value="${p.pname }"></c:out></td>
   		 	<td > <c:out value="${p.qty }"></c:out></td>
   		 	<td> <c:out value="${p.supplier.supplierName }"></c:out></td>
   		 	<td> <c:out value="${p.price }"></c:out></td>
   		 	<td> <img src="D:/frontend/TinyHouseFrontEnd/src/main/resources/${p.imgName}" height="50px" width="50px"></td>
   		   <td> <c:out value="${p.tot+p.qty * p.price}"></c:out> </td>
   		   
   		   <td class="span2">
   		   <c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
   		   <a class="btn btn-info" role="button" href="<c:url value="/deleteCart/${p.cartId }"/>" >  Details </a>
   		   </td>
				
   		   </tr>	
   		</c:forEach>
   		
   		<td>
   		<span class="col-md-8" align="center"><label>Total : </label> <c:out value="${ptot }"></c:out> </span>
   		</td>
   		
   		<tfoot>
   		<td>
   		  <a class="btn btn-warning" href="${pageContext.request.contextPath }/index"> Continue shopping</a>
   		</td></tfoot>
   		
   		<tfoot>
   		<td>
   		  <a class="btn btn-warning" href="${pageContext.request.contextPath }/checkout"> Purchase</a>
   		</td></tfoot>
   		
   </table>
</body>
</html>