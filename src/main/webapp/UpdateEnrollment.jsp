<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page isELIgnored="false" %>
        <%@ page import="com.studentmanagement.model.User" %>
    <%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.Enrollment" %>
<% String success = (String) request.getAttribute("success"); %>
    <% String error = (String) request.getAttribute("error"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f9f9f9;
    padding-top: 40px;
}

/* wrapper centers everything */
.update-wrapper {
    height: calc(100vh - 60px);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}

/* card style for form */
.update-form {
    background: #fff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    width: 350px;
}

/* inputs */
.update-form input, .update-form select {
    margin: 8px 0;
    padding: 8px;
    width: 100%;
    box-sizing: border-box;
}

/* messages */
.error-msg {
    color: red;
    margin-bottom: 10px;
    text-align: center;
    font-weight: bold;
}
.success-msg {
    color: green;
    margin-bottom: 10px;
    text-align: center;
    font-weight: bold;
}

/* buttons side by side */
.form-actions {
    display: flex;
    justify-content: space-between;
    margin-top: 15px;
}

.action-btn {
    flex: 1;
    margin: 0 5px;
    background: #34495e;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 4px;
    padding: 10px;
    box-sizing: border-box;
    text-align: center;
}

.action-btn:hover {
    background: #1abc9c;
}

/* heading */
.update-wrapper h3 {
    margin-bottom: 10px;
    text-align: center;
}
</style>
<body>
<%
    User user = (User) session.getAttribute("userdata");
    Enrollment enrollment = (Enrollment) request.getAttribute("enrollment");
%>
<div class="update-wrapper">
<h3>Update Enrollment</h3>
<% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>

<% if(success != null) { %>
    <p style="color:green;"><%= success %></p>
<% } %>
<form  class="update-form" action="UpdateEnrollment" method="post">
<input type="hidden" name="enrollmentId" value="${enrollment.enrollment_id }">
StudentId:<input type="text" name="student_id"value="${enrollment.student_id}" 
<%= (user != null && user.getRole() == User.Role.TEACHER) ? "readonly" : "" %>><br><br>
CourseId:<input type="text" name="course_id"value="${enrollment.course_id}"
<%= (user != null && user.getRole() == User.Role.TEACHER) ? "readonly" : "" %>><br><br>
Grade:<input type="text" name="grade"value="${enrollment.grade}"><br><br>
 <div class="form-actions">
<input type="submit" class="action-btn" value="Update">
<button type="button" class="action-btn" onclick="window.location.href='Dashboard?view=enrollments'">
  Back
</button>
<input type="hidden" name="origin" value="${param.origin}">
</form>

</body>
</html>