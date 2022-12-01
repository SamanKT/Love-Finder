<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<script type="text/javascript">
	function nameValidation() {

		if (document.getElementById("n").value.length < 1) {
			alert("Name cannot be blank!");
			return false;
		}

		else {
			return true;
		}
	}
</script>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	font-style: italic;
	font-size: small;
	margin-left: 35px;
}
</style>

</head>
<body>
	<h1>
		Love Calculator <span style="color: red;"> &#128152; </span>
	</h1>
	<h3>User Registration</h3>
	<hr>
	<br>
	<form:form action="confirmation" modelAttribute="userRegister"
		onsubmit="return nameValidation()">
		<label for="n">Enter name: </label>
		<form:input path="name" id="n" />
		<br>
		<br>

		<label for="un">Enter a user name: </label>
		<form:input path="userName" id="un" />
		<form:errors path="userName" cssClass="error"  />
		<br>
		<br>

		<label for="ps">Enter password: </label>
		<form:password path="password" id="ps" />
		<br>
		<br>

		<label for="cn">Choose country: </label>
		<form:select path="country" id="cn">
			<form:option value="Turkey" />
			<form:option value="USA" />
			<form:option value="Canada" />
		</form:select>
		<br>
		<br>
		
		Hobbies:<br>
		volleyball<form:checkbox path="hobby" value="volleyball" />
		programming<form:checkbox path="hobby" value="programming" />
		reading<form:checkbox path="hobby" value="reading" />
		<br>
		<br>
		
		Gender:<br> Male<form:radiobutton path="gender" value="male" />
		Female<form:radiobutton path="gender" value="female" />
		<br>
		<br>
		Age: <form:input path="age"/>
		<form:errors path="age"  cssClass="error" />
		 <br><br>

		<input type="submit" value="Register"><br><br>
		<hr>
		<h3>Communication</h3>
		Enter your Email: <form:input path="communicationDTO.email"/>
		<form:errors path="communicationDTO.email" /> <br>
		Enter your Phone: <form:input path="communicationDTO.phone"/>
		<form:errors path="communicationDTO" cssClass="error"/>
		
	</form:form>


</body>
</html>