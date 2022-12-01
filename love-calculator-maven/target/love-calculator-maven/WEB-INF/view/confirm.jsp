<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Confirmation</title>


</head>
<body>
	<h1>Your registration has been completed successfully</h1>
	<h3>The entered details are: </h3><hr>
	
	<p>Name: ${userRegister.name} </p>
	<p>Username: ${userRegister.userName} </p>
	<p>Password: ${userRegister.password} </p>
	<p>Country: ${userRegister.country} </p>
	<p>Hobbies: </p>
	<c:forEach var="temp" items="${userRegister.hobby}"> 
	${temp}
	</c:forEach>
	
	<p>Gender: ${userRegister.gender} </p>
	
	
	
	
	
</body>
</html>