<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<c:url value="/categoryUpdate" var="pru"></c:url>
	<form method="post"   action="${pageContext.request.contextPath}/admin/categoryUpdate" >
			<span id="reauth-cid" class="reauth-cid"></span>
		
		<input type="hidden" name="cid" value="${category.cid }">
		<h3 class="input-title"> Category ID : ${category.cid }</h3> <br>
		<%-- <input value="${category.cid }" type="number" name="cid" >
		 --%>
		<h3 class="input-title"> Category Name</h3> <br>
		<input value="${category.cname }" type="text" name="cname" >
		
					
					<br><br>
					<button class="btn btn-md btn-primary" type="submit">
					Update
					</button>
					<button class="btn btn-md btn-warning" type="reset">
					Reset
					</button>
				
				</form>
	
		<a href="${pageContext.request.contextPath}/admin/categoryList"><button class="btn btn-md btn-secondary"  > Back </button></a>
	<br><br>
</div>

</body>
</html>