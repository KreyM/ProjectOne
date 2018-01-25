<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acknowlegment page</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<h1  align="center" font-style: italic ; font-family: cursive;">Thank You</h1>
<h2 align="center">Payment Made</h2>
<h2 align="center">Go to  <a href="/TinyHouseFrontEnd">HOME</a> or <a href="${pageContext.request.contextPath }/logout">LOGOUT</a></h2>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>