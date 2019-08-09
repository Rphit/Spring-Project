<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <table id="table-1">
   
   <tbody>
   <tr>
    <td>Firstname</td>
    <td>Last name</td>
    <td>email</td>
    </tr>
    
    <c:forEach var="customer" items="${customerList}">
    <tr>
    <td>{customer.firstName}</td>
    <td>{customer.lastName}</td>
    <td>{customer.email}</td>
    
   </tr> 
    
   </c:forEach>
   </tbody>
   </table>

</body>
</html>