<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentmanagement.model.Student"%>
<%
    String success = request.getParameter("success");
    String error = request.getParameter("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h2 {
	color:black;
}

table {
	border-collapse: collapse;
	width: 50%;
	margin-top: 10px;
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
<% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>
<%
    Student std = (Student) session.getAttribute("studentdata");
    if(std== null) {
        response.sendRedirect("LoginStudent.jsp");
        return;
%><%} else if(std!=null){ %>
<h2>Student Details: </h2>
	<table border="1">
		<tr>
			<th>student_id</th>
			<td><%=std.getId()%></td>
			</tr>
			<tr>
			<th>Name</th>
			<td><%=std.getName()%></td>
			</tr>
			<tr>
			<th>Email</th>
			<td><%=std.getEmail()%></td>
			</tr>
			<tr>
			<th>Dob</th>
			<td><%=std.getDob()%></td>
			</tr>
			<tr>
			<th>Address</th>
			<td><%=std.getAddress()%></td>
			</tr>
			<tr>
			<th>Phone</th>
			<td><%=std.getPhone()%></td>
		</tr>		
		<%
		} else {
		%>
		<p>No student found with given ID.</p>
		<%}%>
	</table>
	<div style="margin-top:20px; margin-left:14vw">
<a href="Dashboard?view=student" style="display:inline-block; padding:7px 12px; background:#34495e; color:white; text-decoration:none; border-radius:7px;">Update</a>
</div>

</body>
</html>