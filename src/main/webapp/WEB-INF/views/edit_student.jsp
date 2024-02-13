<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="home.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<form action="edit_student" method="post">

			<table border="1px solid">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id"></td>
				</tr>
			</table>
			<input type="submit" value="Edit">

		</form>

	</div>
	<%
	String message = (String) request.getAttribute("message");

	if (message != null) {
	%>
	<div align="center">
		<h1><%=message%></h1>
	</div>
	<%
	}
	%>
</body>
</html>