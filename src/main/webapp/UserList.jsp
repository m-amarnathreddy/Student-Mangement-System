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
<body>
<table border="1">
<tr>
<th>user_id</th>
<th>username</th>
<th>password</th>
<th>role</th>
<th>Action</th>
</tr>
<%
List<User> ulist=(List<User>) request.getAttribute("users");
if(ulist!=null){
 for(User user:ulist){
 %>
 <tr>
	<td><%= user.getUserId() %> </td>
	<td><%= user.getUsername() %></td>
	<td><%= user.getPassword() %></td>
	<td><%= user.getRole() %></td>
	<td>
	<a href="UpdateUser?uid=<%=  user.getUserId() %>">Edit</a> |
	<a href="DeleteUser?uid=<%= user.getUserId() %>">Delete</a></td>
 </tr>
 
 <% }} %>
</table>

</body>
</html>