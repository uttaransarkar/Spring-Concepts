<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Customers List</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

<div id = "wrapper">
	<div id = "header">
		<h2>Customer Management Portal</h2>
	</div>
</div>

<div id = "container">
	<div id = "content">
	
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		
		<!-- printing list of customers -->
		<c:forEach var="thisCustomer" items="${customers}">
		<tr>
			<td>${thisCustomer.firstName}</td>
			<td>${thisCustomer.lastName}</td>
			<td>${thisCustomer.email}</td>
		</tr>
		</c:forEach>
	</table>
	
	</div>
</div>

<form>
</form>

</body>
</html>