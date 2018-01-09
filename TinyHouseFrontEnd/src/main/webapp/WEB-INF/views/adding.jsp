<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<title> Alternate Living</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link href=" https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
 <link type="text/css" rel="stylesheet" href="webapp\WEB-INF\views\nav.css">

</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container"><br>

<div class="page-header">
<div class="container">

<div class="row">
<div class="col-md-6">
<div class="panel with-nav-tabs panel-warning">
<div class="panel-heading">
      <ul class="nav nav-tabs">
      <li class="active"> <a href="#tab2" data-toggle="tab">Supplier</a>
      <li> <a href="#tab1" data-toggle="tab">Category</a>
      <li> <a href="#tab3" data-toggle="tab">Product</a>
      
      </ul>
</div>

			<div class="panel-body">
			<div class="tab-content">
				<div class="tab-pane fade " id="tab2">
				<form method="post" class="form-signin" action="saveSupplier">
					<span id="reauth-email" class="reauth-email"></span>
					<h3 class="input-title"> Supplier Id</h3> <br>
					<input class="form-control" type="number" name="sid" required/>
					
					<h3 class="input-title"> Supplier Name</h3> <br>
					<input class="form-control" type="text" name="supplierName" required/>
					<button class="btn btn-md btn-primary" type="submit">
					Save
					</button>
					<button class="btn btn-md btn-warning" type="reset">
					Clear
					</button>
				</form>
				</div>
				
				<div class="tab-pane fade in active" id="tab1">
				<form method="post" class="form-signin" action="<c:url value="/saveCategory"/>">
					<span id="reauth-email" class="reauth-email"></span>
					<h3 class="input-title"> Category Id</h3> <br>
					<input class="form-control" type="number" name="cid" required/>
					
					<h3 class="input-title"> Category Name</h3> <br>
					<input class="form-control" type="text" name="cname" required/>
					<button class="btn btn-md btn-primary" type="submit">
					Save
					</button>
					<button class="btn btn-md btn-warning" type="reset">
					Clear
					</button>
				</form>
				</div>
				
				<div class="tab-pane fade" id="tab3">
				<form method="post" class="form-signin" action="/saveProduct">
					<span id="reauth-email" class="reauth-email"></span>
					<h3 class="input-title"> Product Id</h3> <br>
					<input class="form-control" type="number" name="pid" required/>
					
					<h3 class="input-title"> Product Name</h3> <br>
					<input class="form-control" type="text" name="pname" required/>
				</form>
				</div>
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