<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.Enrollment" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Enrollment en = (Enrollment) request.getAttribute("enrollment");
if (en != null) {
%>
<table border="1">
<tr>
<th>Enrollment_id</th>
<th>Student_id</th>
<th>Course_id</th>
<th>Grade</th>
</tr>

<tr>
		<td><%= en.getEnrollment_id() %></td>
		<td><%= en.getStudent_id() %></td>
		<td><%= en.getCourse_id() %></td>
		<td><%= en.getGrade() %></td>
		<td><a href="GetEnrollment?eid=<%= en.getEnrollment_id() %>"></a>
        </tr>
  <% }else{ %>
  <p>No Entry in given id</p>
  <% } %>
</body>
</html>