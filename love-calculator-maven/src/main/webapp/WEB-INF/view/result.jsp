<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator Result</title>
</head>
<body>
<h1 align="center">Love Calculator <span style="color: red;"> &#128152; </span></h1>
<hr>

${dto.userName} and ${dto.crushName} are: <br> <br>

${dto.result} <br><br>

  
<a href="${pageContext.request.contextPath}/email">   Send results</a>
<br>
Request: ${requestScope.dto.userName} <br>
Session:  ${sessionScope.dto.userName} 
</body>
</html>