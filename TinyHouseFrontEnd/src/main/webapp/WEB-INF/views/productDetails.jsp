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
	<script type="text/javascript">
	$(function() {
		$('#myProductTable')
				.DataTable(
						{
							ajax : {
								url : 'TinyHouseFrontEnd/prodDetails/111',
								dataSrc : ''
							},
							columns : [
									
									{
										data : 'name'
									},{
										data : 'brand'
									},
									{
										data : 'description'
									},
									{
										data : 'quantity'
									},
									{
										data : 'price',
										mRender : function(data, type, row) {
											return "&#8377; &#160;" + data;
										}
									},

									{
										data : null,
										mRender : function(data, type, row) {
											return '<img src="D:/frontend/TinyHouseFrontEnd/src/main/resources/${prod.imgName}' 
							+ row.imageUrl+ '" height="50" width="50">';
										}
									},
									{
										data : null,
										mRender : function(data, type, row) {
											return '<a class="btn btn-primary" href="${contextRoot}/productDetails/' 
							+ row.id+ '">View Item</a> &nbsp;<a class="btn btn-primary" href="${contextRoot}/cart/addtocart/' 
							+ row.id + '"><span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>';
										}
									} ]
						});
	});
</script>

</head>

<body> 
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
	<div class="container">
	<div class="row">
		<div class="col-md-8" >
			
			<h1>${prod.pname }</h1>
		</div>
		<hr color="blue">
		<br><br>
			<div class="col-sm-4 item-photo" >
			<h3><b> <font color="grey">Product Image</font></b></h3> 	
			 <img src="D:/frontend/TinyHouseFrontEnd/src/main/resources/${prod.imgName}" height="45%" width="100%">
			 <h3>Product Details</h3>
		  <ul><li>All the items sold in this site are eco-friendly</li>
		  <li> They are made in such a way that they have zero - impact </li>
		  <li> Help us in reducing the carbon footprints</li>
		  </ul>
			<%--  <table>
			 <c:forEach var="p" varStatus="st" items="${prodList }">
   		  <tr><td><img src="D:/frontend/TinyHouseFrontEnd/src/main/resources/${p.imgName}" height="50px" width="50px"></td></tr></c:forEach></table>
			 --%></div>
			<div class="col-md-5" >
			
				<h3><b> <font color="grey">Product</font> :  ${prod.pname }</b></h3>
				<h3><b> <font color="grey">Description</font> : ${prod.description }</b></h3>
				<h3><b> <font color="grey">Price </font> : ${prod.price }</b></h3>
				<h3><b> <font color="grey">Stock </font> : ${prod.stock }</b></h3>
				<h3><b> <font color="grey">Supplier </font> : ${prod.supplier.supplierName }</b></h3>
				<h3><b> <font color="grey">Category</font> :${prod.category.cname }</b></h3> <br>	<br>
				<hr width="10%">
				<%-- <form action="${pageContext.request.contextPath }/addToCart" method="post">
				<input type="hidden" name="pid" value="${prod.pid}"> 
				<input type="hidden" name="pname" value="${prod.pname}"> 
				<input type="hidden" name="description" value="${prod.description}"> 
				<input type="hidden" name="price" value="${prod.price}"> 
				<input type="hidden" name="stock" value="${prod.stock}"> 
				<input type="hidden" name="supplierName" value="${prod.supplier.supplierName}"> 
				<input type="hidden" name="cname" value="${prod.category.cname}"> 
				<input type="hidden" name="imgName" value="${prod.imgName}"> 
				   <label><h3>Quantity </h3></label> <input type="number" width="20%" class="form-control" name="pQty" required=/> 
				     <input type="submit" value="Add To Cart" class="btn btn-primary btn-lg"/> 
				</form> --%>
				 <form action="${pageContext.request.contextPath }/addToCart/${prod.pid }" method="post">
				<input type="hidden" name="pid" value="${prod.pid}"> 
				<input type="hidden" name="pname" value="${prod.pname}"> 
				<input type="hidden" name="description" value="${prod.description}"> 
				<input type="hidden" name="price" value="${prod.price}"> 
				<input type="hidden" name="stock" value="${prod.stock}"> 
				<input type="hidden" name="supplierName" value="${prod.supplier.supplierName}"> 
				<input type="hidden" name="cname" value="${prod.category.cname}"> 
				<input type="hidden" name="imgName" value="${prod.imgName}"> 
				   <label>Quantity </label> <input type="number" width="20%" class="form-control" name="pQty" required/> 
				     <input type="submit" value="Add To Cart" class="btn btn-primary btn-lg"/> <span class="glyphicon glyphicon-shopping-cart"></span>
			
		
				</form>   
				<%-- <form action="${pageContext.request.contextPath }/ addToCart" method="post">
				 <label>Product ID</label>  <input type="hidden" value="${prod.pid }" name="pid"/> 
				 <label>Product Price</label> <input type="hidden" value="${prod.price }" name="price"/> 
				  <label>Product Name</label> <input type="hidden" value="${prod.pname }" name="pname"/> 
				   <label></label> <input type="hidden" value="${prod.imgName }" name="imgName"/> 
				   <label>Qunatity</label> <input type="number" width="20%" class="form-control" name="pQty"/> 
				     <input type="submit" value="Add To Cart" class="btn btn-primary btn-lg"/> 
				</form> --%>
			</div>				
			
	<br><br>
		<!-- <div class="col-md-9">
		  <h3>Product Details</h3>
		  <ul><li>All the items sold in this site are eco-friendly</li>
		  <li> They are made in such a way that they have zero - impact </li>
		  <li> Help us in reducing the carbon footprints</li>
		  </ul>
		
		</div>			
		 -->
					</div>
	</div>



</body>

</html>
