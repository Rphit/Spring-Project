<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="customer" action="processForm" method="post"></form>
First Name <form:input path="firstName" required/><br></br>
Last Name <form:input path="lastName"  required/><br></br>
Email <form:input path="email"  required/><br></br>
<input type="submit"  value="submit"/>
</form:form>
</body>
</html>