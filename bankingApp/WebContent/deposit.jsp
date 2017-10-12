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

			<h2 style="margin-top: 39px;">Deposit Money </h2>

			<form id="depositForm">
				<li><input type="number" placeholder="Enter Account Number"
					id="userId" name="userId" onkeyup="check(); return false;" required />
					<div class="clear"></div></li>
				<li><input placeholder="Enter Amount" id="amt" name="amount"
					type="number" required />
					<div class="clear"></div></li> <input id="depositBtn" type="submit"
					value="Deposit">

				<div class="clear"></div>
		</ul>

		<div class="clear"></div>
		</form>


	</div>







	<script
		src="${pageContext.request.contextPath}/resources/js/ajaxService.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validator.js"></script>
</body>
</html>