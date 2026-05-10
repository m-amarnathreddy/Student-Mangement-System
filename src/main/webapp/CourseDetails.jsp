<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<%@ page import="com.studentmanagement.model.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Course course=(Course) request.getAttribute("course");
if(course !=null ){
%>
<table border="1">
		<tr>
			<th>course_id</th>
			<th>course_name</th>
			<th>description</th>
			<th>credits</th>
		</tr>
		<tr>
			<td><%=course.getCourseId()%></td>
			<td><%=course.getCourseName()%></td>
			<td><%=course.getDescription()%></td>
			<td><%=course.getCredits()%></td>
			<td><a href="GetCourse?cid=<%= course.getCourseId() %>">view</a>
		</tr>

		<%
		}else {
		%>
		<p>No course</p>
		<% } %>
		</table>
</body>
</html>