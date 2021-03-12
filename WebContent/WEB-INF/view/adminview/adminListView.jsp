<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin List View</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/ccs/TableCSS.css">
	</head>
	<body>
		<h1>Admin List View</h1>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
			</tr>

			<c:forEach var="a" items="${adminList}">
				<tr>
					<td>${a.id}</td>
					<td>${a.name}</td>
				</tr>
			</c:forEach>
			
		</table>
		
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