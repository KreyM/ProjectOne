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
 <div class="col-md-6" jumbotron-danger>
 	<div class="head"><h2>Shipping Details</h2></div>
 	<div class="outer">
 	  <div class="well" style="width: 100 %;border-color: red;  ">
 	  
			 	  <form action="${pageContext.request.contextPath}/orderProcess" method="post">
			<c:set var="ptot" value="0">
			</c:set>
			<c:forEach var="c" items="${cart}">
				<c:set var="ptot" value="${ptot+c.price*c.qty }">
				
				</c:set>
				
				</c:forEach>
			<div class="well">
			<table>
			<tr>
			<td colspan="3">NAME:</td><td>${user.name}</td>
			</tr>
			
			<tr>
			<td colspan="3">EMAIL ID:</td><td>${user.email}</td>
			</tr>
			
			<tr>
			<td colspan="3">ADDRESS:</td><td>${user.address}</td>
			</tr>
			
			<tr>
			<td colspan="3">PHONE NO:</td><td>${user.phone}</td>
			</tr>
			</table>
			<br><br><br>
			
			
<div class="outer">
<h3>Enter Payment Details</h3>
<br>
<label> Select Payment</label>
<select name="payment">
<option value="Cash">Cash </option>
<option value="Net">Net Banking</option>
<option value="Cheque">Cheque</option>
</select>
<br><br>
</div>
Name: <input type="text" name="name on card">
<br>

Card Number:<input type="number" name="card number">
<br>
CVV:<input type="number" name="CVV">
<input type="hidden" name="total" value="${ptot }">

</div>
<input type="submit"   value="PAY" style="width:75%" class="btn btn-danger">
<input type="reset" value="Cancel" style="width:75%" class="btn btn-primary">

			
 	  
</form>
</div><!-- 
<button type="submit" value="PAY" onsubmit="/ack.jsp">Pay</button> -->

 	  
 	  
 	  
 	  </div>
 	</div>
 </div>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>


<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
  
          <table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					     <c:set var="grandTotal" value="0"></c:set>
                        <c:forEach items="${cart.cartItems}" var="cartItem">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"> <img src="${images}/${cartItem.product.code}.jpg" alt="..."  class="img-responsive border"/></div>
									<div class="col-sm-10">
										<h6><b>${cartItem.product.name}</b></h6>
										<p>${cartItem.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377; ${cartItem.product.unitPrice} /-</td>
							<td data-th="Quantity">${cartItem.quantity}</td>
							<td data-th="Subtotal" class="text-center">${cartItem.totalPrice}</td>
							 <td><a href="${contextRoot}/cart/removecartitem/${cartItem.cartItemId}" class="btn btn-danger pull-left ">
                             <c:set var="grandTotal" value="${cartItem.totalPrice + grandTotal}"></c:set>	
                             <i class="material-icons">remove</i></a></td>
                             
                             
                                            
						</tr>
					</c:forEach>
					</tbody>
					
					<tfoot>
						  <tr class="visible-xs">
							<td class="text-center"><strong>Total:- ${grandTotal}</strong></td>
						</tr>
						<tr>
						    <td><a href="${contextRoot}/show/all/products" class="btn btn-warning">Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><h6 style="font-size:20px;"><strong><b>Total:- ${grandTotal}</b></strong></h6></td>
							<td><a href="${contextRoot}/cart/${cart.cartid}/order" class="btn btn-success btn-block">Checkout</a></td>
						</tr>
					</tfoot>
				</table>

    
</div>
<br><br>
<br>
<br>
<br>
<br>
<br>
<br><br>
<br>
<br>
<br>
<br>
<br><br>
<br>
<br>
<br>
<br>
<br>














<%-- <div class="container">
	<c:if test="${not empty message}">
	
		<div class="alert alert-info">
		
			<h3 class="text-center">
				${message}
			</h3>
		
		</div>
	
	</c:if>
	<c:choose>
		
		<c:when test="${not empty cartLines}">
		
<table id="cart" class="table table-hover table-condensed">
				<thead>
		<tr>
			<th style="width:50%">Product</th>
			<th style="width:10%">Price</th>
			<th style="width:8%">Quantity</th>
			<th style="width:22%" class="text-center">Subtotal</th>
			<th style="width:10%"></th>
		</tr>
	</thead>
	<tbody>
		
		
		<c:forEach items="${cartLines}" var="cartLine">
		<tr>
			<td data-th="Product">
				<div class="row">
					<div class="col-sm-2 hidden-xs"><img src="${images}/${cartLine.product.code}.jpg" alt="${cartLine.product.name}" class="img-responsive cartImg"/></div>
					<div class="col-sm-10">
						<h4 class="nomargin">${cartLine.product.name}
							<c:if test="${cartLine.available == false }">
								<strong class="unavailable">(Not Available)</strong>
							</c:if>
						</h4>
						<p>Brand - ${cartLine.product.brand}</p>
						<p>Description- ${cartLine.product.description}</p>
					</div>
				</div>
			</td>
			<td data-th="Price">&#8377; ${cartLine.buyingPrice}</td>
			<td data-th="Quantity">
				<input type="number" id="count_${cartLine.id}" min="1" max="3" class="form-control text-center" value="${cartLine.productCount}">
			</td>
			<td data-th="Subtotal" class="text-center">&#8377; ${cartLine.total}</td>
			<td class="actions" data-th="">
				<button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-refresh"></span></button>
				<a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>								
			</td>
		</tr>
		
		</c:forEach>
 	
	</tbody>
	<tfoot>
		<tr class="visible-xs">
			<td class="text-center"><strong>Total &#8377; ${userModel.cart.grandTotal}</strong></td>
		</tr>
		<tr>
			<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a></td>
			<td colspan="2" class="hidden-xs"></td>
			<td class="hidden-xs text-center"><strong>Total &#8377; ${userModel.cart.grandTotal}</strong></td>
			<td><a href="#" class="btn btn-success btn-block">Checkout <span class="glyphicon glyphicon-chevron-right"></span></a></td>
		</tr>
	</tfoot>
</table>		
		
		</c:when>
		
		<c:otherwise>
			
			<div class="jumbotron">
			
				<div class="text-center">
				
					
					<h1>Your cart is empty!</h1>
				
				</div>
			
			</div>
		
		</c:otherwise>
	
	</c:choose>
</div> --%>

 -->
