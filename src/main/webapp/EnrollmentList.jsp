<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.Enrollment" %>
<%@ page import="com.studentmanagement.model.User" %>
<% String success = (String) request.getAttribute("success"); %>

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
<% if(success != null) { %>
    <p style="color:green;"><%= success %></p>
<% } %>
<h3>Enrollment Details:</h3>
<table border="1">
<tr>
<th>Enrollment_id</th>
<th>Student_id</th>
<th>Course_id</th>
<th>Grade</th>
<% User user = (User) session.getAttribute("userdata");
    if(user != null && user.getRole() == User.Role.TEACHER ) { %>
<th>Action</th>
<%} %>
</tr>
<%
    List<Enrollment> elist = (List<Enrollment>) request.getAttribute("enrollments");
    if (elist != null && !elist.isEmpty()) {
        for (Enrollment en : elist) {
%>
<tr>
    <td><%= en.getEnrollment_id() %></td>
    <td><%= en.getStudent_id() %></td>
    <td><%= en.getCourse_id() %></td>
    <td><%= en.getGrade() %></td>
    <% if(user != null && user.getRole() == User.Role.TEACHER) { %>
    <td>
        <a href="UpdateEnrollment?enrollmentId=<%= en.getEnrollment_id() %>">Edit</a>
        <a href="DeleteEnrollment?enrollmentId=<%= en.getEnrollment_id() %>">Delete</a>
    </td>
    <%} %>
</tr>
<%
        }
    } else {
%>
<tr>
    <td colspan="5">No enrollments found.</td>
</tr>
<%
    }
%>

</table>

</body>
</html>