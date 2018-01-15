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
   <h2>Product List </h2>
   <table class="table table-hover" id="ap1" class="display" border="2" width="80" align="center">
   		<tr>
	   		<th>Serial No.</th>
	   		<th>Product ID</th>
	   		<th> Product Name</th>
	   		<th>Product Description </th>
	   		<th>Product Supplier </th>
	   		<th>Product Category</th>
	   		<th>Stock</th>
	   		<th>Price</th>
	   		<th>Image</th>
	   		
   		</tr>
   		
   		<c:if test="${empty prodList }">
   		  <tr> 
   		    <td colspan="9" align="center"> No record found :( </td>
   		  </tr>  
   		</c:if>
   		
   		<c:forEach var="p" varStatus="st" items="${prodList }">
   		  <tr>
   		 	<td> <c:out value="${st.count }"></c:out></td>
   		 	<td> <c:out value="${p.pid }"></c:out></td>
   		 	<td> <c:out value="${p.pname }"></c:out></td>
   		 	<td class="span3"> <c:out value="${p.description }"></c:out></td>
   		 	<td> <c:out value="${p.supplier.supplierName }"></c:out></td>
   		 	<td> <c:out value="${p.category.cname }"></c:out></td>
   		 	<td> <c:out value="${p.stock }"></c:out></td>
   		 	<td> <c:out value="${p.price }"></c:out></td>
   		 	<td> <img src="${pageContext.request.contextPath}/resouces/${p.imgName}" height="50px" width="50px"></td>
   		   
				
   		   </tr>	
   		</c:forEach>
   		
   		
   
   </table>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
   			
</body>
</html>