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
<br><br>
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

