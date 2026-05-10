<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="com.studentmanagement.model.Student" %>
<%@ page import="com.studentmanagement.model.User"%>
<%@ page import="com.studentmanagement.model.StudentCourse"%>
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
	font-size:14px;
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
<%
Student student = (Student) session.getAttribute("studentdata");
	User user = (User) session.getAttribute("userdata");
	 List<StudentCourse> details = (List<StudentCourse>) request.getAttribute("details");
	%>
	<%if (student == null && user == null) {
        response.sendRedirect("Login.jsp");
        return; 
} %>
<h3>Student & Course Details</h3>
	<table>
		<tr>
			<th>Sid</th>
			<th>Student Name</th>
			<th>Email</th>
			<th>dob</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Cid</th>
			<th>Course Name</th>
			<th>Description</th>
			<th>credits</th>
			<th>enrollment_id</th>
			<th>Grade</th>
			<% if(user != null) { %>
			<th>Action</th>
			<%} %>
		</tr>
		<%
    if (details != null && !details.isEmpty()) {
        for (StudentCourse sc : details) {
%>
		<tr>
			<td><%=sc.getStudentid()%></td>
			<td><%=sc.getName()%></td>
			<td><%=sc.getEmail()%></td>
			<td><%=sc.getDob()%></td>
			<td><%=sc.getAddress()%></td>
			<td><%=sc.getPhone()%></td>
			<td><%=sc.getCourseId()%></td>
			<td><%=sc.getCourse_name()%></td>
			<td><%=sc.getDescription()%></td>
			<td><%=sc.getCredits()%></td>
			<td><%=sc.getEnrollment_id()%></td>
			<td><%=sc.getGrade()%></td>
			<% if(user != null && user.getRole() == User.Role.ADMIN) { %>
			<td><a href="UpdateStudent?id=<%= sc.getStudentid() %>&origin=StudentCourse">Edit
					Student</a> | <a href="UpdateCourse?courseId=<%= sc.getCourseId() %>&origin=Dashboard?view=studentcourse">Edit
					Course</a></td>
			<% } else if(user != null && user.getRole() == User.Role.TEACHER){%>
			<td><a
				href="UpdateEnrollment?enrollmentId=<%=sc.getEnrollment_id() %>&origin=Dashboard?view=studentcourse">Edit</a>
			</td>
			<%} %>

		</tr>

		<%
            }} else if(student !=null){
            	
		%>
		<tr>
			<td colspan="2">No course details found. your are not enrolled</td>
		</tr>
		<%
		}else{
		%>
		<tr>
		<td>No course details found</td>
		</tr>
		<% } %>
</body>
</html>