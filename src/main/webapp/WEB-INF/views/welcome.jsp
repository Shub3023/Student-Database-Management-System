<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email= (String)request.getAttribute("message");
%>
<a href="home">HOME</a>
<a href="add_student">ADD</a>
<a href="edit_student">EDIT</a>
<a href="delete_student">DELETE</a>
<a href="get_students">ALL STUDENT</a>
<a href="delete_admin?email=<%=email%>">DELETEADMIN</a>

</body>
</html>