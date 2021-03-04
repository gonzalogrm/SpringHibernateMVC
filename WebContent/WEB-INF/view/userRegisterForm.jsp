<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register User</title>
	</head>
	<body>
		<!-- https://www.javatpoint.com/spring-mvc-form-tag-library -->
		<form:form action="processForm" modelAttribute="user">
			<!-- References getters setters -->
			<!-- Getters y Setters sin Get/Set y en minúscula -->
			ID: <form:input path="id"/><br>
			Name: <form:input path="name"/><br>
			Nickname: <form:input path="nickname"/><br>
			
			<!-- Al enviar, las MVC tags llaman a los setters -->
			<input type="submit" value="Send">
		</form:form>
	</body>
</html> 