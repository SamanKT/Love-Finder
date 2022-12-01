<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
</head>
<body>
<h2>Hi ${dto.userName}</h2> 
<h3>Your result is ready to send</h3><hr> <br>
	<form:form action="email-process" modelAttribute="emailDTO" method="POST">
Enter Your Email: <form:input path="id" /> 
<input type="submit" value="Send">

	</form:form>

</body>
</html>