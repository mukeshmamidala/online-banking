<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bank.css" />

<title>Login Form</title>
</head>
<body>
	<div id="header" class="header">
		<img class="logo"
			src="${pageContext.request.contextPath}/resources/img/logo.jpg" />
	</div>

	<div class="login-page">
		<div class="form">
			<%
				String status = (String) request.getAttribute("errorStatus");
				System.out.println(status);
				if (status != null && status.equals("fail")) {
					out.println("<label class='errMsg' id='errLbl'>Inavlid User id or Password..</label>");
				} else {
					out.println("<label class='errMsg' id='errLbl'></label>");
				}
			%>
			<form class="login-form" method="post" id="loginForm" action="ForgotPassword" method="POST">
				
				<input placeholder="Enter Registered Mobile" id="mobile"
					name="username" type="number" required
					onkeyup="check(); return false;"> <input type="password"
					placeholder="Enter New Password" id="userpwd" name="userpwd" />
				<button onclick="validation()" type="button" id="login">Change Password</button>
			</form>
			
					
			<!-- <button id="chngPass">Chng</button> -->
			
			
		</div>
	</div>

	

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validator.js"></script>

</body>

</html>