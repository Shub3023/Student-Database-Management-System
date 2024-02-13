<%@page import="java.util.List"%>
<%@page import="com.jspiders.smswithspringmvc.pojo.StudentPOJO"%>
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
		<form action="delete_student" method="post">

			<table border="1px solid">

				<tr>
					<td>Id</td>
					<td><input type="text" name="id"></td>


				</tr>


			</table>


			<input type="submit" value="Delete">

		</form>
	</div>


	<%
	List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");

	if (students != null && students.size() > 0)

	{
	%>
	<div align="center" border="1px solid">

		<table border="1px solid">

			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Age</th>
			<%
			for (StudentPOJO student : students) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getMobile()%></td>
				<td><%=student.getAge()%></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
	<%
	}
	%>
	<%
	String message = (String) request.getAttribute("message");

	if (message != null) {
	%>
	<h1 align="center"><%=message%></h1>

	<%
	}
	%>
</body>
</html>