<%@page import="com.jspiders.smswithspringmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
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
	<%
	StudentPOJO student = (StudentPOJO) request.getAttribute("students");

	if (student != null) {
	%>
	<form action="update_student" method="post">
		<table border="1px solid">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="<%=student.getId()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value="<%=student.getName()%>"></td>
			</tr>


			<tr>
				<td>email</td>
				<td><input type="email" name="email"
					value="<%=student.getEmail()%>" ></td>
			</tr>

			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile"
					value="<%=student.getMobile()%>"></td>
			</tr>
			
			
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"
					value="<%=student.getAge()%>"></td>
			</tr>

		</table>
		<input type="submit" value="UPDATE">
	</form>
	<%
	}
	%>
	</div>
	
</body>
</html>