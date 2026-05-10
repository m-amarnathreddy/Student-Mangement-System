<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    padding-top: 30px; /* space for nav bar if fixed */
}

/* wrapper centers everything */
.course-wrapper {
    height: calc(100vh - 60px);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}

/* card style for form */
.course-form {
    background: #fff;
    padding: 10px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    width: 350px;
}

/* inputs */
.course-form input {
    margin: 8px 0;
    padding: 8px;
    width: 100%;
    box-sizing: border-box;
}

/* submit button */
.course-form input[type="submit"] {
    background: #34495e;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 4px;
    padding: 10px;
    margin-top: 10px;
}

.course-form input[type="submit"]:hover {
    background: #1abc9c;
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
.form-actions {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
}

.action-btn {
  flex: 1;               /* equal width for both buttons */
  margin: 0 5px;
  background: #34495e;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 4px;
  padding: 10px;
  box-sizing: border-box;
}
.action-btn:hover {
  background: #1abc9c;
}

/* heading */
.course-wrapper h3 {
    margin-bottom: 10px;
    text-align: center;
}
</style>
<body>
<div class="course-wrapper">
<h3>Course Registration</h3>
<% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>


<% if(success != null) { %>
    <p style="color:green;"><%= success %></p>
<% } %>
<form class="course-form" action="Register4" method="post">
CourseName:<input type="text" name="course_name"><br><br>
Description:<input type="text" name="description"><br><br>
Credits:<input type="text" name="credits"><br><br>
<div class="form-actions">
  <button type="submit" class="action-btn">Register</button>
<button type="button" class="action-btn" onclick="window.location.href='Dashboard.jsp'">Back</button>
</form>
</div>
</div>
</body>
</html>