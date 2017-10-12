<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

th{
background-color: gray;
color: white;
}

</style>

</head>
<body>
	
	   <div align="center">
        <table border="1" cellpadding="5" style='width: 500px;'>
            <caption><h2>Account Summary for : <%=session.getAttribute("userId") %></h2></caption>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Dr</th>
                <th>Cr</th>
            </tr>
             
            <c:forEach var="user" items="${accountSummryList}" >
                <tr>
                     <td><c:out value="${user.transactionId}" /></td>
                  	 <td><c:out value="${user.date}" /></td>
                    <td><c:out value="${user.debit}" /></td>
                    <td><c:out value="${user.credit}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>

	 
</body>
</html>