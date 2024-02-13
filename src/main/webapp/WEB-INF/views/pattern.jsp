<%@page import="com.jspiders.smswithspringmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
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

	<div align="center">
		<form action="pattern" method="post">
			<table border="1px solid">
				<tr>
					<td>Pattern</td>
					<td><input type="text"></td>
				</tr>
			</table>
			<input type="submit" value="SEARCH">
		</form>
	</div>
</body>
</html>