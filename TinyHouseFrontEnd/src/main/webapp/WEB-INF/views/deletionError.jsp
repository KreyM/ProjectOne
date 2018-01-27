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

<body > 
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br><br>
<br><br>
<h1 align="center" style="color: red;">Error</h1>
<br><br>
<h4 align="center" >We cannot delete this item.</h4>

<br><br>

<h1 align="center" ><a href="${pageContext.request.contextPath }/index">Home</a> or <a href="javascript:history.back()">Go Back</a></h1>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>