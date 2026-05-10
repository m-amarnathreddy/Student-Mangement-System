<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.studentmanagement.model.Student" %>
    <%@ page import="com.studentmanagement.model.StudentCourse"%>
    <%@ page import="java.util.List" %>
    
    <%
    Student student1 = (Student) session.getAttribute("studentdata");
    if(student1 == null) {
        response.sendRedirect("LoginStudent.jsp");
        return;
   
    } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    
}
.main-layout {
    display: flex;
    flex: 1;
    height:100vh;
}

/* Sidebar */
.sidebar {
    width: 220px;
    background-color: #2c3e50;
    height: 100vh;
    padding-top: 20px;
}
.sidebar button {
    width: 90%;
    padding: 10px;
    margin: 8px auto;
    background-color: #34495e;
    border: none;
    color: white;
    text-align: left;
    cursor: pointer;
    border-radius: 4px;
    display: block;
}

.sidebar button:hover {
    background-color: #1abc9c;
}
/* Content area */
.content {

    flex: 1;
    padding: 20px;
}
</style>
</head>
<body>
<%@ include file="Nav.jsp" %>
<div class="main-layout">
    <div class="sidebar">
    <button onclick="location.href='Dashboard?view=studentd'">Profile</button>
    <button onclick="location.href='Dashboard?view=courses'">Courses List</button> 
    <button onclick="location.href='Dashboard?view=studentcourse'">Student–Course List</button>
</div>
<div class="content">
<%
    String view = request.getParameter("view");
    if ("courses".equals(view)) {
%>
        <%@ include file="CourseList.jsp" %>
<%
    } else if ("studentcourse".equals(view)) {
%>
        <%@ include file="StudentCourse.jsp" %>
        <%} else if("studentd".equals(view)){ %>
        <%@ include file="StudentDetails.jsp" %>
        <%} else if("student".equals(view)) {%>
        <%@ include file="UpdateStudent.jsp" %>
     <% }else{ %>
    <h3 style="color:black; text-align:left;">Welcome, <%= student1.getName()  %> !</h3>
    <p>Select an option from the left sidebar....</p>
    <%} %>
    </div>
</div>

</body>
</html>