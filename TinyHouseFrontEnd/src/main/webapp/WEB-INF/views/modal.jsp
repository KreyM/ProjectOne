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
	<hr>
	<div class="modal fade bs-demo-modal-sm" tabindex="1" role="dialog"
	aria-labelledby="myModal" aria-hidden="true" id="onload">
	  <div class="modal-dialog modal-sm">	
		<div class="modal-content">
		  <div class="modal-header">
		  	<button type="button" class="close">X</button>
		  </div>
		  <div class="modal-body"> <span>Adding Successful</span>  </div>
		  
		  <div class="modal-footer">
		  <a href="${pageContext.request.contextPath }/admin/adding" class="btn btn-warning" role="button">
		  Back		  </a></div>
		
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() 
		{
			$('#onload').modal('show');
		});
		

</script>
</body>
</html>