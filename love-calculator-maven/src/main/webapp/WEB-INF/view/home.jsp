<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	font-style: italic;
	font-size: small;
	margin-left: 25px;
}
</style>


</head>
<body>
	<h1 align="center">
		Love Calculator <span style="color: red;"> &#128152; </span>
	</h1>
	<div align="right"><a href="register" >Register</a></div>
	<hr>
	<c:url var="url" value="process-page"> </c:url>
	<form:form action="${url}" modelAttribute="dto">
		<div align="center">
			<label for="yn">your name: </label>
			<form:input id="yn" path="userName" />
			<form:errors path="userName" cssClass="error" />
			<br>
			<br> <label for="cn">crush name: </label>
			<form:input id="cn" path="crushName" />
			<form:errors path="crushName" cssClass="error" />
			<br>
			<p>  
			<form:checkbox  path="confirm" /> confirm that this is just for fun!
			<form:errors path="confirm" cssClass="error" />
			</p>
			<br> <input type="submit" value="Calculate" />
		</div>

	</form:form>

</body>
</html>