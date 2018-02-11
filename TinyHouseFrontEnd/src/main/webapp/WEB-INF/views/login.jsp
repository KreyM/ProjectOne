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

<body bgcolor="acqua"> 
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class="container">
	<h2>LOGIN TO EXPLORE</h2>
	<form action="${pageContext.request.contextPath }/login" class="form-signin" method="post">
		<h3><label> Email : </label></h3>
		<input type="text" name="username" class="login-box" required>
		<h3><label> Password : </label></h3>
		<input type="password" name="password" class="login-box" required>
	<hr>
		<button class="btn btn-lg btn-primary" type="submit">LOGIN</button>
		<button class="btn btn-lg btn-warning" type="reset">Clear</button>
	
	</form>
	<a href="/TinyHouseFrontEnd"><button class="btn btn-lg btn-secondary" >Back</button></a>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>