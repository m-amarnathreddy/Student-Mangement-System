<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.Student" %>
<%@ page import="com.studentmanagement.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h2 {
	color: #2c3e50;
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
<table border="1">
<h3>Students data:</h3>
<tr>
    <th>Student ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>DOB</th>
    <th>Address</th>
    <th>Phone</th>
    <% 
    User user = (User) session.getAttribute("userdata");
    if(user != null && user.getRole() == User.Role.ADMIN ) { %>
<th>Action</th>
<% }%>
</tr>
<%
List<Student> slist=(List<Student>) request.getAttribute("students");
if(slist!=null){
for(Student std:slist)
{
	%>
        <tr>
        <td><%= std.getId() %></td>
		<td><%= std.getName() %></td>
		<td><%= std.getEmail() %></td>
		<td><%= std.getDob() %></td>
		<td><%= std.getAddress() %></td>
		<td><%= std.getPhone() %></td>
		 <% if(user != null && user.getRole() == User.Role.ADMIN) { %>
		<td>
		<a href="UpdateStudent?id=<%= std.getId() %>&origin=Dashboard?view=students">Edit</a>
		<a href="Delete?sid=<%=  std.getId() %>">Delete</a></td>
		<%} %>
        </tr>
   <% }} %>
</table>

</body>
</html>