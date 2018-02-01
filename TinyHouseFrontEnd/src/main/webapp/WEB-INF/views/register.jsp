<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<style type="err">
	.has-error .control-label,
.has-error .help-block,
.has-error .form-control-feedback {
    color: #a94442;
}

/* Color of valid field */
.has-success .control-label,
.has-success .help-block,
.has-success .form-control-feedback {
    color: #3c763d;
}
</style>

</head>

<body> 
<jsp:include page="header.jsp"></jsp:include>
<h2>Registration Form</h2>
<div class="container">
	<div class="col-sm-12">
		<div class="row">
		<form:form action="saveRegister" method="post" modelAttribute="user">
<!-- <form > -->
<form:errors path="name" cssStyle="err.css" cssClass="err"/>
		<div class="form-group">
		<label> Name :  </label>
		<input name="name" class="form-control" placeholder= "Enter name" required/>
		</div>
		<div class="form-group">
		<form:errors  path="email" cssStyle="err.css" cssClass="err"/>
		<label> Email :  </label>
		<input name="email" class="form-control" placeholder= "Enter Email"  required/>
		</div>
		<div class="form-group">
		<label> Password :  </label>
		<input name="password" type="password" class="form-control" placeholder= "Enter Password" required/>
		</div>
		<div class="form-group">
		<label> Address :  </label>
		<input name="address" class="form-control" placeholder= "Enter Address" required/>
		</div>
		<div class="form-group">
		<form:errors path="phone" cssClass="err"/>
		<label> Phone Number :  </label>
		<input name="phone" class="form-control" placeholder= "Enter Phone Number" required/>
		</div>
		<br>
		<br>
		<button type="submit" class="btn btn-lg btn-info">SUBMIT</button>
		<button type="reset" class="btn btn-lg btn-danger">CANCEL</button>
		
<!-- 		</form>
 -->	
 </form:form>	
		</div> <!-- row end -->
	
	</div>

</div>
</body>
</html>