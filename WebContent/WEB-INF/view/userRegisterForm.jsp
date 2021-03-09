<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Taglib para las etiquetas de spring con prefijo form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register User</title>
	</head>
	<body>
		<h1>Register new User</h1>
		<!-- https://www.javatpoint.com/spring-mvc-form-tag-library -->
		<form:form action="processForm" modelAttribute="user">
			<!-- References getters setters -->
			<!-- Getters y Setters sin Get/Set y en minúscula -->
			ID: <form:input path="id"/><br>
			<!-- Incluimos el mensaje de error de validación -->
			Name: <form:input path="name"/> <form:errors path="name" style="color:red" /><br>
			Nickname: <form:input path="nickname"/><br>
			Age: <form:input path="age"/> <form:errors path="age" style="color:red" /><br>
			Email: <form:input path="email"/> <form:errors path="email" style="color:red" /><br>
			Role: 
			<br>
			<form:select path="role" multiple="false">
				<form:option value="user" label="User"></form:option>
				<form:option value="admin" label="Admin"></form:option>
			</form:select><br>
			Language: 
			<br>
				<form:checkbox path="language" value="spa" label="Español"></form:checkbox><br>
				<form:checkbox path="language" value="eng" label="English"></form:checkbox><br>
			
			<br><br>
			
			<!-- Al enviar, las MVC tags llaman a los setters -->
			<input type="submit" value="Send">
		</form:form>
	</body>
</html> 