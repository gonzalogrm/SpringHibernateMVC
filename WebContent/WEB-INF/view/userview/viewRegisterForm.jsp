<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View Register Form</title>
	</head>
	<body>
		<h1>Registro completado</h1>
		Name: ${user.name}<br>
		Email: ${user.email}<br>
		Age: ${user.age}<br>
		Language: ${user.language}<br>
		
		<!-- 
		<br><br>		
		<a href="${pageContext.request.contextPath}/index">Volver al inicio</a>	
		 -->		
		
		<br><br>
		<input type="button" 
		value="Volver a Inicio" 
		onclick="window.location.href='${pageContext.request.contextPath}/index'; return false;"/>	
	</body>
</html>