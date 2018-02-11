
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Alternate Living</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href=" https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="webapp\WEB-INF\views\nav.css">

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<br>

		<div class="page-header">
			<div class="container">

				<div class="row">
					<div class="col-md-6">
						<div class="panel with-nav-tabs panel-warning">
							<div class="panel-heading">
								<h2>Add To Cart</h2>
							</div>

							<div class="panel-body">
								<div class="row">
									<form:form action="saveCart" method="post"
										modelAttribute="user">
				<div class="form-group">
					<table>
					<tr>
						<td> Select Product</td>
						<td><select class="form-control" name="pProduct" required>
								<option value="">SELECT Product</option>
								<c:forEach items="${prodList}" var="prod">
								  <option value="${prod.pid}"> ${prod.pname}</option>
								</c:forEach>
								
							</select>
				<%-- 			<button onclick="myFunction()">Click me</button>

<p id="demo">
${pProduct.prod.pname}
</p>

<script>
function myFunction() {
    document.getElementById("demo").innerHTML = "hi ${pProduct.prod.pname}";
}
</script> 
			 --%>				<br><br>
							
							<h2>${pProduct.prod.pid}</h2>
							<br><br>
							<c:if test="${empty pProduct }">
   		  <tr> 
   		    <td colspan="9" align="center"> Select a product( </td>
   		  </tr>  
   		</c:if>
							
							
							<table class="table table-hover table-condensed" id="cart" class="display" border="2" width="80" align="center">
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
   		
   		<c:set var="ptot" value="0"></c:set>
   		<c:forEach var="p" varStatus="st" items="${cartInfo}">
   		  <tr>
   		 	<td> <c:out value="${pProduct.pname }"></c:out></td>
   		 	<td > <c:out value="${pProduct.qty }"></c:out></td>
   		 	<td> <c:out value="${pProduct.supplier.supplierName }"></c:out></td>
   		 	<td> <c:out value="${pProduct.price }"></c:out></td>
   		 	<td> <img src="D:/frontend/TinyHouseFrontEnd/src/main/resources/${pProduct.imgName}" height="50px" width="50px"></td>
   		   <td> <c:out value="${pProduct.tot+pProduct.qty * pProduct.price}"></c:out> </td>
   		   
   		   <td class="span2">
   		   <c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
   		   <a class="btn btn-info" role="button" href="<c:url value="/deleteCart/${pProduct.cartId }"/>" >  Delete </a>
   		   </td>
				
   		   </tr>	
   		</c:forEach>
   		
   		<td>
   		<span class="col-md-8" align="center"><label>Total : </label> <c:out value="${pProduct.ptot }"></c:out> </span>
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
					</td>
					</tr>
					</table>
					</div>
	
										
										<br>
										<br>
										<button type="submit" class="btn btn-lg btn-info">Add</button>
										<button type="reset" class="btn btn-lg btn-danger">CANCEL</button>

										<!-- 		</form>
 -->
									</form:form>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>


	</div>
</body>
</html>

