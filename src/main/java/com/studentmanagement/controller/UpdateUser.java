package com.studentmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentmanagement.model.User;
import com.studentmanagement.model.User.Role;
import com.studentmanagement.repository.UserDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  User currentUser = (User) req.getSession().getAttribute("userdata");
	        if (currentUser == null) {
	            resp.sendRedirect("Login.jsp");
	            return;
	        }
	        req.setAttribute("user", currentUser);
	        req.getRequestDispatcher("UpdateUser.jsp").forward(req, resp);
	    }
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User currentUser = (User) req.getSession().getAttribute("userdata");
    if (currentUser == null) {
        resp.sendRedirect("Login.jsp"); // not logged in
        return;
    }
	String userName=req.getParameter("uname");
	String Password=req.getParameter("password");
	if (userName == null || userName.trim().isEmpty()) {
	    userName = currentUser.getUsername();
	}
	if (Password == null || Password.trim().isEmpty()) {
	    Password = currentUser.getPassword();
	}
	currentUser.setUsername(userName);
    currentUser.setPassword(Password);
	
	UserDaoimpl Udi=new UserDaoimpl();
	boolean isupdated=Udi.updateUserById(currentUser);
	resp.setContentType("text/html");
	if(isupdated) {
		
		System.out.println("User updated successfully.");
	    req.setAttribute("success", "User updated successfully!");
	    req.setAttribute("view", "userdetails");
	    req.setAttribute("userdetails", currentUser); 
	    req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
	}else {
		System.out.println("Update failed.");
	    req.setAttribute("error", "Update failed!");
	    req.setAttribute("user", currentUser);
	    req.setAttribute("view", "updateUser");
	    req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
	}
}
}
