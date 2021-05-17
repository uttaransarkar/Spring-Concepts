<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page</title>
</head>
<body>

<h3>Customer Details</h3>

Customer has been successfully registered: <b>${customer.firstName} ${customer.lastName}</b>
<br><br>

You have <b>${customer.noOfPasses}</b> free passes.
<br><br>

Delivery at: <b>${customer.postalCode}</b>
<br><br>

Course Code: <b>${customer.courseCode}</b>

</body>
</html>