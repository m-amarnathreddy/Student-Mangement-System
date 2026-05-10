<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
      <%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.Student" %>
<%@ page import="com.studentmanagement.model.User" %>
<% String success = (String) request.getAttribute("success"); %>
    <% String error = (String) request.getAttribute("error"); %>
    <%
    User user = (User) session.getAttribute("userdata");
%><%
    Student std = (Student) session.getAttribute("studentdata");
%>
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
<div class="update-wrapper">
<h3>Update Student</h3>

<% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>

<% if(success != null) { %>
    <p style="color:green;"><%= success %></p>
<% } %>

<form class="update-form" action="UpdateStudent" method="post">

<input type="hidden" name="sid" value="<%= std.getId() %>">
<% if(user != null && user.getRole() == User.Role.ADMIN) { %>
    <input type="hidden" name="origin" value="Dashboard?view=students">
<% }else{ %><input type="hidden" name="origin" value="Dashboard?view=studentd">
<% } %>
 <% if(user != null && user.getRole() == User.Role.ADMIN) { %>
StudentName:<input type="text" name="sname"value="${student.name}"><br><br>
Dob:<input type="date" name="dob"value="${student.dob}"><br><br>
Address:<input type="text" name="address"value="${student.address}"><br><br>
Phone:<input type="number" name="phone"value="${student.phone}"><br><br>
 <% } else { %>
Email:<input type="email" name="email"value="${student.email}"><br><br>
Password:<input type="text" name="password"value="${student.password}"><br><br>
<%} %>
  <div class="form-actions">
  <%if(user != null && user.getRole() == User.Role.ADMIN) {%>
  <button type="submit" class="action-btn"  onclick="window.location.href='Dashboard?view=students'">
        Update
    </button>
    <%}else { %>
      <button type="submit" class="action-btn" onclick="window.location.href='Dashboard?view=studentd'">Update</button>
      <%} %>
      <%if(user != null && user.getRole() == User.Role.ADMIN) {%>
      <button type="button" class="action-btn" 
            onclick="window.location.href='Dashboard?view=students'">
        Back
    </button>
    <%} else{ %>
<button type="button" class="action-btn" 
            onclick="window.location.href='Dashboard?view=studentd'">
        Back
    </button>
    <%} %>
</div>
</form>
</div>
</body>
</html>