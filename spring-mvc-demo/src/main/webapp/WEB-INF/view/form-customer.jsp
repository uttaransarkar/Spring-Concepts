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

<i>Please Note: Fields marked with (*) are mandatory  </i>
<br><br>

<!-- modelAttribute will have its fields populated by the form data -->
<form:form action="processForm" modelAttribute="customer">

	First Name(*): <form:input path="firstName"/>
	
	<!-- for displaying error messages -->
	<form:errors path="firstName" cssClass="error"></form:errors>
	
	<br><br>
	
	Last Name: <form:input path="lastName"/>
	<br><br>
	
	Number of free passes(*): <form:input path="noOfPasses"/>
	<!-- for displaying error messages -->
	<form:errors path="noOfPasses" cssClass="error"></form:errors>
	<br><br>
	
	Postal Code: <form:input path="postalCode"/>
	<!-- for displaying error messages -->
	<form:errors path="postalCode" cssClass="error"></form:errors>
	
	<br><br>
	Course Code: <form:input path="courseCode"/>
	<!-- for displaying error messages -->
	<form:errors path="courseCode" cssClass="error"></form:errors>
	
	<br><br>
	<input type="submit" value="SUBMIT">
</form:form>

</body>
</html>