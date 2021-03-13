<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Taglib para las etiquetas de spring con prefijo form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register Admin</title>
	</head>
	<body>
		<h1>Register new Admin</h1>
		<!-- https://www.javatpoint.com/spring-mvc-form-tag-library -->
		<form:form action="processNewAdmin" modelAttribute="admin" method="POST">
			<!-- References getters setters -->
			<!-- Getters y Setters sin Get/Set y en minúscula -->
			<!-- ID: <form:input path="id"/><br>-->
			
			<!-- Incluimos el mensaje de error de validación -->
			ID: <form:input path="id"/><br>
			Name: <form:input path="name"/><br>
			<!-- Al enviar, las MVC tags llaman a los setters -->
			<input type="submit" value="Send">
		</form:form>
		
		<br><br>
		<input type="button" 
		value="Volver a Inicio" 
		onclick="window.location.href='${pageContext.request.contextPath}/index'; return false;"/>
	</body>
</html> 