<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User List View</title>
	</head>
	<body>
		<h1>User List View</h1>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Edad</th>
				<th>Idioma</th>
			</tr>

			<c:forEach var="u" items="${userList}">
				<tr>
					<td>${u.id}</td>
					<td>${u.name}</td>
					<td>${u.email}</td>
					<td>${u.age}</td>
					<td>${u.language}</td>
				</tr>
			</c:forEach>
			
		</table>
		
	</body>
</html>