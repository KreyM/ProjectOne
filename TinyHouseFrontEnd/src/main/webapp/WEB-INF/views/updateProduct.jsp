<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
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

<body >
<jsp:include page="header.jsp"></jsp:include>
<div class="container"><br>
 <c:url value="/productUpdate" var="pru"></c:url>
	<form method="post"   action="${pageContext.request.contextPath}/productUpdate" enctype="multipart/form-data">
		<span id="reauth-email" class="reauth-email"></span>
		<input type="hidden" name="pid" value="${prod.pid }">
		
		<h3 class="input-title"> Product Name</h3> <br>
		<input value="${prod.pname }" type="text" name="pname" required/>
		
		<h3 class="input-title"> Product Description</h3> <br>
		<input style="justify-content: flex-end;column-width: auto;" spellcheck="true" size="70%" value="${prod.description }" type="text" name="description" required/>
		
		<h3 class="input-title"> Product Price</h3> <br>
		<input value="${prod.price }" type="number" name="price" required/>
		
		<h3 class="input-title"> Product Stock</h3> <br>
		<input value="${prod.stock }" type="number" name="stock" required/>
					
					<div class="form-group">
					<table>
					<tr>
						<td> Select Supplier
						<td><select class="form-control" name="pSupplier" required>
								${prod.supplier.supplierName }
								<c:forEach items="${satList}" var="sat">
								  <option value="${sat.sid}"> ${sat.supplierName}</option>
								</c:forEach>
							</select>
					</td>
					</tr>
					</table>
					</div>
					
					<div class="form-group">
					<table>
					<tr>
						<td> Select Category</td>
						<td><select class="form-control" name="pCategory" required>
								 ${prod.category.cname}<!-- //<option> removing since the present option was coming twice in the drop down</option> -->
								<c:forEach items="${catList}" var="cat">
								  <option value="${cat.cid}"> ${cat.cname}</option>
								</c:forEach>
							</select>
					</td>
					</tr>
					</table>
					</div>
					<div class="fileinput fileinput-new" data-provides="fileinput">
					<th> Product Image</th>
					<td> <input class="form-control" type="file" name="file" accept="image/*"> Current Image : ${prod.imgName}</td>
					</div>
					<br><br>
					<button class="btn btn-md btn-primary" type="submit">
					Update
					</button>
					<button class="btn btn-md btn-warning" type="reset">
					Cancel
					</button>
				</form>
				</div>
			
</body>
</html>