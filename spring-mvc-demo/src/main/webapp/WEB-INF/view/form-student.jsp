<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Student Form</title>
</head>
<body>

<h2>Student Registration From</h2>

<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName"/>
	<br><br>
	Last Name: <form:input path="lastName"/>
	<br><br>
	Select Country: 
	<form:select path="country">
	
		<form:options items="${student.countries}" />
	</form:select>
	
	<br><br>
	Select Favorite Language:<br>
	<form:radiobutton path="favLanguage" value="Java"/>Java 
	<form:radiobutton path="favLanguage" value="C++"/> C++
	<form:radiobutton path="favLanguage" value="Python"/> Python
	<form:radiobutton path="favLanguage" value="Javascript"/> Javascript
	
	<br><br>
	Select the operating systems you are experienced in: <br>
	Windows<form:checkbox path="opSystem" value="Windows" /><br>
	Linux<form:checkbox path="opSystem" value="Linux" /><br>
	MacOS<form:checkbox path="opSystem" value="MacOS" /><br>
	Unix<form:checkbox path="opSystem" value="Unix" /><br>
	
	<input type="submit" value="SUBMIT"> 
	
</form:form>

</body>
</html>