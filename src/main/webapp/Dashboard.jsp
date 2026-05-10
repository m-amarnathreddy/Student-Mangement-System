<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.studentmanagement.model.User" %>
<%@ page import="com.studentmanagement.model.StudentCourse"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dash Board</title>
<style>
body {
    margin: 00px;
    font-family: Arial, sans-serif;
}
.main {
    display: flex;
    height: 100vh; 
  
}

/* Sidebar styling */
.sidebar {
position:fixed;
top:30px;
    width: 150px;
    background-color: #2c3e50;
    color: white;
    
    padding-top: 20px;
     height:100%;
  overflow-y: auto;
}


.sidebar a {
    display: block;          /* vertical stack */
    margin: 10px;
    text-decoration: none;
}
.sidebar button {
    width: 100%;
    padding: 10px;
    background-color: #34495e;
    border: none;
    color: white;
    text-align: left;
    cursor: pointer;
    border-radius: 4px;
}

.sidebar button:hover {
    background-color: #1abc9c;
}

/* Main content area */
.content {
margin-top: 00px; 
margin-left:150px;
    flex: 1;
    padding: 20px;
     min-height: calc(100vh - 60px);
   background: #f9f9f9;
}
.submenu {
    display: none;
    margin-left: 20px; /* indent child items */
}
.submenu button {
display: block;
    width: 100%;
    padding: 5px;
    margin: 8px 0;   /* vertical gap between buttons */
    background-color: #34495e;
    border: none;
    color: white;
    text-align: left;
    cursor: pointer;
    border-radius: 4px;
}

.collapsible {
    width: 100%;
    padding: 10px;
    background-color: #34495e;
    border: none;
    color: white;
    text-align: left;
    cursor: pointer;
    border-radius: 4px;
}


.collapsible:hover {
    background-color: #1abc9c;
}

</style>

</head>
<body>

	<%@ include file="Nav.jsp"%>
	<div class="main">
	<div class="sidebar">
	<a href="Dashboard?view=userdetails"><button>Profile</button></a>
    <a href="Dashboard?view=students"><button>Students</button></a>
    <a href="Dashboard?view=courses"><button>Courses</button></a>
    <a href="Dashboard?view=enrollments"><button>Enrollments</button></a>
    <a href="Dashboard?view=studentcourse"><button>Student & Course</button></a>
     <% 
          
           if(u != null && u.getRole() == User.Role.ADMIN ) { 
        %>
        <button class="collapsible">Register ▼</button>
          <div class="submenu">
        <button onclick="location.href='Dashboard?view=registerCourse'">Course</button>
        <button onclick="location.href='Dashboard?view=registerEnrollment'">Enrollment</button> 
        <button onclick="location.href='Dashboard?view=registerUser'">User</button>    
            <% } %>
    </div>
</div>
<div class="content">
    <%
        String view = request.getParameter("view");
    if (view == null) {
        view = (String) request.getAttribute("view");
    }
        if("students".equals(view)) {
    %>
        <%@ include file="StudentList.jsp" %>
    <%
        } else if("courses".equals(view)) {
    %>
        <%@ include file="CourseList.jsp" %>
    <%
        } else if("enrollments".equals(view)) {
    %>
        <%@ include file="EnrollmentList.jsp" %>
    <%
        } else if("studentcourse".equals(view)) {
        	
    %>
        <%@ include file="StudentCourse.jsp" %>
        <%} else if("users".equals(view)) {%>
        <%@ include file="UpdateUser.jsp" %>
        	<%}else if("userdetails".equals(view)){ %>
        	<% if (request.getAttribute("success") != null) { %>
    <p style="color:green;"><%= request.getAttribute("success") %></p>
<% } %>
<% if (request.getAttribute("error") != null) { %>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
   	<%@ include file="UserDetails.jsp" %>
       <% 
       }else if("registerCourse".equals(view)) { %>
   			 <%@ include file="Register4.jsp" %>
   
   			<%
   			} else if("registerEnrollment".equals(view)) {%>
   			 <%@ include file="Register3.jsp" %>
   			<%} else if("registerUser".equals(view)) {%>
   			<%@ include file="Register2.jsp" %>

    <%
        } else {
    %>
    <% if (u != null) { %>
        <h2 style="color:black; text-align:left;">Welcome, <%= u.getUsername()  %> !</h2>
   <% } else { %>
    <h2 style="color:black; text-align:left;">Welcome to the Dashboard</h2>
<% } %>
        <p>Select an option from the left menu.</p>
    <%
        }
    %>
</div>
</div>
	<script>
document.addEventListener("DOMContentLoaded", function() {
    var coll = document.querySelector(".collapsible");
    coll.addEventListener("click", function() {
        var submenu = this.nextElementSibling;
        submenu.style.display = (submenu.style.display === "block") ? "none" : "block";
    });
});
</script>
	
</body>
</html>