<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.studentmanagement.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h2 {
margin-top:10px;
	color: light-black;
}

table {
	border-collapse: collapse;
	width: 50%;
	margin-top: 10px;
	font-size:14px;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f4f4f4;
}
</style>

<body>
<%
    User currentUser = (User) session.getAttribute("userdata");
    if (currentUser == null) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>
<%
User user=(User) request.getAttribute("userdetails");
if(user!=null){

%>
<h2>User Details: </h2>
<table border="1">
 <tr>
        <th>User ID</th>
        <td><%= user.getUserId() %></td>
    </tr>
    <tr>
        <th>Username</th>
        <td><%= user.getUsername() %></td>
    </tr>
    <tr>
        <th>Password</th>
        <td><%= user.getPassword() %></td>
    </tr>
    <tr>
        <th>Role</th>
        <td><%= user.getRole() %></td>
    </tr>
 </tr>
 <% } else{%>
 <p>No user found at this id</p>
 <% } %>
</table>
<div style="margin-top:20px; margin-left:14vw">
<a href="Dashboard?view=users" style="display:inline-block; padding:7px 12px; background:#34495e; color:white; text-decoration:none; border-radius:7px;">Update</a>
</div>
</body>
</html>