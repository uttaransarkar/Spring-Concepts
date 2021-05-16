<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Page</title>
</head>
<body>

Student has been registered: ${student.firstName} ${student.lastName}
<br>
<br>
Country of residence: ${student.country}
<br>
<br>
Favorite Language: ${student.favLanguage}
<br><br>

Experienced in:
<ul>

<!-- to display a list of items we will use jstl c:forEach tag -->
<c:forEach var="thisOS" items="${student.opSystem}">
	
	<li> ${thisOS} </li>
</c:forEach>
</ul>
</body>
</html>