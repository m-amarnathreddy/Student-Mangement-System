<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.studentmanagement.model.User" %>
    <%@ page import="com.studentmanagement.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
/* Top nav bar */
.navbar {
    background-color: black;
    color: white;
    padding: 5px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    
     position: fixed;  
    top: 0;
    left: 0;           
    width: 100%;      
    z-index: 10000;
  
    }
    body {
    margin: 0;
    padding-top: 60px; 
}
    .navbar a, .dropbtn {
    color: white;
    padding: 10px;
    text-decoration: none;
    border: none;
    background: none;
    cursor: pointer;
    font-size: 16px;
}.dropdown {
    display: inline-block;
    position: relative;
}
.dropbtn {
    color: white;
    padding: 6px 12px;
    font-size: 16px;
    cursor: pointer;
    background: none;
    border: none;
}
.dropdown-content form {
    margin: 0;              /* remove default form margin */
    padding: 0;             /* remove extra padding */
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #34495e;
    min-width: 100px;
    z-index: 1;
    padding: 10px;
    height:80px;
}
.dropdown-content button {
    width: 100%;
    padding: 5px 12px;
    margin: opx 0;
    background-color: #34495e;
    border: none;
    color: white;
    text-align: left;
    cursor: pointer;
    border-radius: 4px;
    font-size: 13px;
    display: block;
}

.dropdown-content button:hover {
    background-color: #1abc9c;
}
.dropdown:hover .dropdown-content {
    display: block; /* show submenu on hover */
}
    </style>
   
<body>
<%
    User u = (User) session.getAttribute("userdata");
    Student s = (Student) session.getAttribute("studentdata");
%>
<nav class="navbar">

<a href="index.jsp" style="color:white; margin:0 15px; text-decoration:none;">Home</a>
<% if(s==null && u==null){ %>
 <div class="dropdown">
        <button class="dropbtn">Login ▼</button>
        <div class="dropdown-content">
        
            <form action="Login" method="get">
                <button type="submit">Login User</button>
            </form>
            <form action="StudentLogin" method="get">
                <button type="submit">Login Student</button>
            </form>
            </div>
            </div>
            
            
        <a href="Register.jsp"style="color:white; margin:0 15px; text-decoration:none;">Register Student</a>
      <%}else if(s!=null || u!=null) {%>
        <a href="Logout" style="color:white; margin:0 15px; text-decoration:none;">Logout</a>
     <%} %>
      <%--   <% 
           User u = (User) session.getAttribute("userdata");
           if(u.getRole() == User.Role.ADMIN ) { 
        %>
            <a href="Register4.jsp"style="color:white; margin:0 15px; text-decoration:none;">Register Course</a>
            <a href="Register2.jsp"style="color:white; margin:0 15px; text-decoration:none;">Register User</a>
            <a href="Register3.jsp"style="color:white; margin:0 15px; text-decoration:none;">Register Enrollment</a>    
            <% } %> --%>

</nav>
</body>
</html>