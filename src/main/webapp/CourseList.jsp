<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentmanagement.model.Course"%>
<%@ page import="com.studentmanagement.model.User" %>
<% String success = (String) request.getAttribute("success"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Details</title>
</head>
<style>
h2 {
	color: #2c3e50;
}

table {
	border-collapse: collapse;
	width: 50%;
	margin-top: 20px;
	font-size:16px;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f4f4f4;
}
</style>
<body>
<% if(success != null) { %>
    <p style="color:green;"><%= success %></p>
<% } %>
<h3>Courses:</h3>
	<table border="1">
		<tr>
			<th>course_id</th>
			<th>course_name</th>
			<th>description</th>
			<th>credits</th>
			<% 
    User user = (User) session.getAttribute("userdata");
    if(user != null && user.getRole() == User.Role.ADMIN ) { %>
			<th>Action</th>
<% } %>
		</tr>
		<%
		List<Course> clist = (List<Course>) request.getAttribute("courses");
		if (clist != null) {
			for (Course cu :clist) {
		%>
		<tr>
			<td><%=cu.getCourseId()%></td>
			<td><%=cu.getCourseName()%></td>
			<td><%=cu.getDescription()%></td>
			<td><%=cu.getCredits()%></td>
			<% if(user != null && user.getRole() == User.Role.ADMIN) { %>
			<td><a
				href="UpdateCourse?courseId=<%= cu.getCourseId() %>&origin=Dashboard?view=courses">Edit</a>
				<a
				href="DeleteCourse?courseId=<%= cu.getCourseId() %>&origin=Dashboard?view=courses">Delete</a>
				</td>
				<%} %>
		</tr>

		<%
		}
		}
		%>
	</table>

</body>
</html>