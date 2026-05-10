<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
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
    padding-top: 60px; /* space for fixed nav bar */
}
.form-container {
    height: calc(100vh - 60px); /* full height minus nav bar */
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}
.success-msg {
    color: green;
    margin-bottom: 15px;
    font-weight: bold;
    text-align: center;
}
.login-form {
    background: #fff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}
.login-form input,
.login-form select {
    margin: 8px 0;
    padding: 8px;
    width: 100%;
    box-sizing: border-box;
}

.login-form input[type="submit"] {
    background: #34495e;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 4px;
}

.login-form input[type="submit"]:hover {
    background: #1abc9c;
}
</style>
<body>
<%@ include file="Nav.jsp" %>
<div class="form-container">
 <%
        String success = request.getParameter("success");
        if(success != null) {
    %>
        <div class="success-msg"><%= success %></div>
    <%
        }
    %>
<form class="login-form" action="StudentLogin" method="post">
    Email: <input type="text" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</div>
</body>
</html>