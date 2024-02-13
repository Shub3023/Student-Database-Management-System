<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="Log_in" method="post">
			<table border="1px solid">
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="LogIn">
		</form>
	</div>
	
	<% 
	String message = (String) request.getAttribute("message");
	
	if(message !=null){
	%>
	<div align="center">
	  <h1><%=message %></h1>
	</div>
	<%
	}
	%>
</body>
</html>