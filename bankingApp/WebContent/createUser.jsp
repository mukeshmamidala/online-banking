<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	media="screen" />
<title></title>
</head>
<body>

	<div class="main">
		
			<ul class="left-form">
			
			<%
				if(request.getAttribute("status") !=null){
					out.println("<h2 class='errMsg' id='errLbl' style='color: red'>"+request.getAttribute("status")+"</h2>");
				}else{
					out.println("<h2 class='errMsg' id='errLbl' style='color: red'></h2>");
				}
			%>
			
				<h2 style="margin-top: 39px;">Add New User:</h2>
				
				<li><input type="text" placeholder="Username" id="username" required /> 
					<div class="clear"></div></li>
				<li><input placeholder="Mobile no" id="mobile"
					name="username" type="number" 
					onkeyup="check(); return false;" required /> 
					<div class="clear"></div></li>

				<!-- <li><input type="password" placeholder="Password" id="pwd" required />
						
					<div class="clear"></div></li>
 -->

				<li><label
					style="opacity: 0.6; padding-left: 13px; font-size: 15px; margin-top: 5px; font-family: 'Open Sans', sans-serif;">Assign
						Role to User ::</label> <select name="role"
					style="width: 100px; height: 44px; border: 1px solid #EBEBEB; margin-left: 40px; border-left: 0; border-top: 0; border-bottom: 0; opacity: 0.6; font-size: 15px;">
						<option value="admin">Admin</option>
						<option value="user">User</option>
						<option value="cashier">Cashier</option>

				</select>
					<div class="clear"></div></li>
				
				<input id="registerUser" type="submit"  value="Create User Account" >
				<div class="clear"></div>
			</ul>

			<div class="clear"></div>

		

	</div>







<script
		src="${pageContext.request.contextPath}/resources/js/ajaxService.js"></script>
<script
		src="${pageContext.request.contextPath}/resources/js/validator.js"></script>
</body>
</html>