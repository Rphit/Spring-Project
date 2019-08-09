<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
      <h2>Student Form</h2>
      <form:form action="processForm" method="post" modelAttribute="student" >
  First name     <form:input path="firstName"/><br>
  <form:errors path="firstName" />
  Last name     <form:input path="lastName"/><br>
 
 Country :
 <form:select path="country">
  <form:options items="${student.countries}"/><br>
 </form:select><br>
 
 Select language:
 <form:radiobutton path="language" value="c#" label="c#"/>
 <form:radiobutton path="language" value="cpp" label="cpp"/>
 <form:radiobutton path="language" value="Python" label="python"/>
 <form:radiobutton path="language" value="c" label="c"/><br>
 
 Operating System
  <form:checkbox path="operating" value="micro" label="micro"/>
 <form:checkbox path="operating" value="android" label="android"/>
 <form:checkbox path="operating" value="mac" label="mac"/>
 
 
  
<input type="submit" value="submit">
</form:form>
</body>
</html>