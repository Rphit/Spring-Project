<%@page import="comm.example.springdemo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br>
Hello!!!, First-Name --*** ${ student.firstName }<br>Last-Name --*** ${student.lastName }<br>
Country --*** ${student.country} <br>

 <%--  <%
       Student s=(Student)request.getAttribute("student");
       String[] arr=s.getLanguage();
       for(String s1:arr)
       {
    	   out.print(s1);
       }
  %>
  --%>
 Favorite Language --*** ${student.language}<br>
   
  Operating System --*** ${student.operating} <br>
  <a href="../home">Home-Page</a>
  
</body>
</html>