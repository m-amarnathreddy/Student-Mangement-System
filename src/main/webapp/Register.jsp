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
.register-wrapper {
    height: calc(100vh - 60px);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;

}
.register-form {
    background: #fff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    width: 350px;
}
.register-form input, .register-form select {
    margin: 2px 0;
    padding: 2px;
    width: 100%;
    box-sizing: border-box;
}
.form-actions {
    display: flex;
    justify-content: space-between; /* side by side buttons */
    margin-top: 5px;
   
}
.form-actions form {
    flex: 1;
    margin: 0 5px;
}
.action-btn {
	disply-flex: 1;
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
.register-form input[type="submit"], .back-btn {
    background: #34495e;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 4px;
    padding: 8px;
    margin-top: 10px;
    width: 48%;
}
.register-form input[type="submit"]:hover, .back-btn:hover {
    background: #1abc9c;
}
.error-msg {
    color: red;
    margin-bottom: 10px;
    text-align: center;
}
</style>
<body>
<%@ include file="Nav.jsp" %>
<div class="register-wrapper">
<h3>Student Registration: </h3>
    <%  String errorMsg = (String) request.getAttribute("errorMsg");
    if(errorMsg != null) { %>
        <div class="error-msg"><%= errorMsg %></div>
    <% } %>
<form class="register-form" action="Register" method="post" >
StudentName:<input type="text" name="sname"><br><br>
Email:<input type="email" name="email"><br><br>
Dob:<input type="date" name="dob"><br><br>
Address:<input type="text" name="address"><br><br>
Phone:<input type="number" name="phone"><br><br>
Password:<input type="text" name="password"><br><br>
<div class="form-actions">
<input type="submit" value="Register" class="action-btn">
<button type="button" class="action-btn" onclick="window.location.href='index.jsp'">
        Back to Home
      </button>
</div>
</form>
</div>
</body>
</html>