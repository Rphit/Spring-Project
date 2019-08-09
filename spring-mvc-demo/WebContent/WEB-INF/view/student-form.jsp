<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
student from view page
<form:form action="student/processForm" method="post" modelAttribute="student">
First name   <form:input path="firstName"/>
last name  <form:input path="lastName"/>

 <input type="submit">
</form:form>

</body>
</html>