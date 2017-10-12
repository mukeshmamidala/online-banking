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
		
		
		<button class="myBtn" id="home">Home</button>
		<button class="myBtn" id="accountStatement">Account statement</button>
		<button class="myBtn" id="miniStatement">Mini statement</button>
		<button class="myBtn" id="transferMoney">Transfer money</button>
		<button class="myBtn" id="billPay">Bill pay</button>
		<button class="myBtn" id="balance">Balance</button>
		
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

<script
		src="${pageContext.request.contextPath}/resources/js/user.js"></script>

</body>
</html>