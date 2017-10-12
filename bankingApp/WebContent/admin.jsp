<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bank.css" />
</head>
<body>
	<!-- <h1>Welcome</h1> -->


	<div id="topPane" class="topPane">
		<div id="header" class="header">
			<img class="logo"
				src="${pageContext.request.contextPath}/resources/img/a.jpg" />
		<div id='info'>
		<%
			out.println("Welcome : "+session.getAttribute("userName")+" || ");
			out.println("Current Role is : "+session.getAttribute("userRole"));
		%>
		</div>
		</div>
		
		
	</div>
	<div id="leftPane" class="leftPane">
		<button class="myBtn" id="ca">Create User</button>
		<button class="myBtn" id='cc'>Show All Customers</button>
		<form id="lo" action="login">
			<button class="myBtn" id='logOut'>logOut</button>
		</form>
	</div>
	<div id="mainContent" class="mainContent"></div>

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validator.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/js/ajaxService.js"></script>



</body>
</html>