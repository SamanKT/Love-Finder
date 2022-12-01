<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: right;
	font-style: italic;
	font-size: small;
	margin-left: 25px;
}
</style>
</head>

<body>
<form:form action="confirmFeedback" modelAttribute="feedback">
<p>Enter your name: </p><form:input path="name" /> <br>
<form:errors path="name" cssClass="error"/>
<p>Enter your last name: </p><form:input path="lastName"/><br>
<p>Enter your feedback: </p><form:textarea path="body"/><br>

<input type="submit" >
</form:form>
</body>
</html>