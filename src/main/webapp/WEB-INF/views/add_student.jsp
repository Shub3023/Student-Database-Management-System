<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="home.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

div {
	margin-top: 20px;
}

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: center;
	border: 1px solid #ddd;
}

th {
	background-color: #4CAF50;
	color: white;
}

input[type=text] {
	width: 100%;
	padding: 8px 12px;
	margin: 8px 0;
	box-sizing: border-box;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
<body>
	<div align="center" border="1px solid"'>


		<form action="add_student" method="post">


			<table>


				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="email" name="email"></td>
				</tr>

				<tr>
					<td>Mobile</td>
					<td><input type="text" name="mobile"></td>
				</tr>

				<tr>
					<td>Age</td>
					<td><input type="text" name="age"></td>
				</tr>

			</table>
			<input type="submit" value="ADD">

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