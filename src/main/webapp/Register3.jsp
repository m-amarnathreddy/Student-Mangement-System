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
.enroll-wrapper {
    height: calc(100vh - 60px);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}

/* card style for form */
.enroll-form {
    background: #fff;
    padding: 10px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    width: 350px;
}

/* inputs */
.enroll-form input {
    margin: 8px 0;
    padding: 8px;
    width: 100%;
    box-sizing: border-box;
}

/* submit button */
.enroll-form input[type="submit"] {
    background: #34495e;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 4px;
    padding: 10px;
    margin-top: 10px;
}

.enroll-form input[type="submit"]:hover {
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
.enroll-wrapper h3 {
    margin-bottom: 10px;
    text-align: center;
}
</style>
<body>

<div class="enroll-wrapper">
<h3>Enrollment: </h3>
<% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>

<% if(success != null) { %>
    <p style="color:green;"><%= success %></p>
<% } %>
<form class="enroll-form" action="Register3" method="post">
Student_Id:<input type="text" name="student_id"><br><br>
Course_Id:<input type="text" name="course_id"><br><br>
<!--  Grade:<input type="text" name="grade"><br><br> this is default null admin unable to add-->
<div class="form-actions">
  <button type="submit" class="action-btn">Register</button>
<button type="button" class="action-btn" onclick="window.location.href='Dashboard.jsp'">
  Back
</button>
</form>
</div>
</div>
</body>
</html>