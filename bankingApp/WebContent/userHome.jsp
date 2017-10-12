<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User home</title>

<style type="text/css">
	.home{
		color: Orange;
		font-size: 20px;
		padding-left: 25px;
	}

</style>

</head>
<body>
	 <h1 class="home"> Hello Dear : 
	 	<%=
	 		(String)session.getAttribute("userName")
	 	%>
	 </h1>
	 <hr>
	 <h1 class="home"> Your Current Role is : 
	 	<%=
	 		(String)session.getAttribute("userRole")
	 	%>
	 </h1>
	 <hr>
	 <h1 class="home"> Your Id is : 
	 	<%=
	 		session.getAttribute("userId")
	 	%>
	 </h1>
	 
</body>
</html>