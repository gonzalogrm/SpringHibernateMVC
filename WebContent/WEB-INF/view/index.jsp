<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Index</title>
		<!-- 
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/ccs/EasyCSS.css">
		 -->
	</head>
	<body>
		<h1>INDEX</h1>
		<br><br>
		<a href="users/userlist">Ver todos los usuarios</a>
		<br><br>
		<a href="users/searchByID">Buscar usuario por ID</a>
		<br><br>
		<a href="users/searchByEmail">Buscar usuario por email</a>
		<br><br>
		<a href="users/newUserFrom">Dar de alta usuario</a>	
		<br><br>
		
		<br><br>
		<!-- Nos lleva a nuestra carpeta WebContent -->
		<img alt="JAVA" 
		src="${pageContext.request.contextPath}/resources/img/javalogo.jpg" 
		style="width:128px;height:128px;">
	</body>
</html>