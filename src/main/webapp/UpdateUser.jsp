<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.User" %>
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
<div class="update-wrapper">
<h3>User Updation</h3>
<% if(error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>

<% if(success != null) { %>
    <p style="color:green;"><%= success %></p>
<% } %>
<form class="update-form" action="UpdateUser" method="post">
    <input type="hidden" name="origin" value="Dashboard?view=userprofile">
UserName:<input type="text" name="uname"value="${user.username}"><br><br>
Password:<input type="password" name="password" value="${user.password}"><br><br>
<!--  
Role:<select name="role">
        <option value="ADMIN" ${user.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
        <option value="USER" ${user.role == 'TEACHER' ? 'selected' : ''}>TEACHER</option>
    </select><br><br>   -->
  <div class="form-actions">
   <button type="submit" class="action-btn">Update</button>
        <button type="button" class="action-btn"
                onclick="window.location.href='Dashboard?view=userdetails'">
            Back
        </button>
        </div>
</form>
</div>
</body>
</html>