<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Customer Details</title>
	<style>
		.error {color: red}
	</style>
</head>
<body>
<h2>Customer Registration</h2>

<i>Please Note: (*) marked fields are mandatory  </i>
<br><br>

<form:form action="processForm" modelAttribute="customer">

	First Name(*): <form:input path="firstName"/>
	
	<!-- for displaying error messages -->
	<form:errors path="firstName" cssClass="error"></form:errors>
	<br><br>
	
	Last Name: <form:input path="lastName"/>
	<br><br>
	
	<input type="submit" value="SUBMIT">
</form:form>

</body>
</html>