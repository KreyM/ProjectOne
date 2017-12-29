<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<html>
<head>
	<title>Tiny Movement</title>
	
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
<jsp:include page="header.jsp"></jsp:include>
<h2>Registration Form</h2>
<div class="container">
	<div class="col-sm-12">
		<div class="row">
		<form action="saveRegister">
		<div class="form-group">
		<label> Name :  </label>
		<input name="name" class="form-control" placeholder= "Enter name"/>
		</div>
		<div class="form-group">
		<label> Email :  </label>
		<input name="email" class="form-control" placeholder= "Enter Email"/>
		</div>
		<div class="form-group">
		<label> Password :  </label>
		<input name="password" class="form-control" placeholder= "Enter Password"/>
		</div>
		<div class="form-group">
		<label> Address :  </label>
		<input name="address" class="form-control" placeholder= "Enter Address"/>
		</div>
		<div class="form-group">
		<label> Phone Number :  </label>
		<input name="phone" class="form-control" placeholder= "Enter Phone Number">
		</div>
		<br>
		<br>
		<button type="submit" class="btn btn-lg btn-info">SUBMIT</button>
		<button type="reset" class="btn btn-lg btn-danger">CANCEL</button>
		
		</form>
		
		</div> <!-- row end -->
	
	</div>

</div>
</body>
</html>