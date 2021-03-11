<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Taglib para las etiquetas de spring con prefijo form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search by Email</title>
	</head>
	<body>
		<form:form action="viewUserData" modelAttribute="searchParams">
			ID: <form:input path="email"/><br>
			<input type="submit" value="Send">
		</form:form>
	</body>
</html>