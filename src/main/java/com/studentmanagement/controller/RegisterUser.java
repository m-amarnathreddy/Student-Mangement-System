package com.studentmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.studentmanagement.model.Course;
import com.studentmanagement.model.User;
import com.studentmanagement.model.User.Role;
import com.studentmanagement.repository.UserDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register2")
public class RegisterUser extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username=req.getParameter("uname");
	String password=req.getParameter("password");
	String Roleparam=req.getParameter("role");
	 if (username == null || username.isEmpty() ||
	            Roleparam== null || Roleparam.isEmpty() ) {
	            
	    	 req.setAttribute("error", "All fields are required");
	    	 req.setAttribute("view", "registerUser");
	    	 req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
	            
	            return;
	    }
	User user=new User();
	user.setUsername(username);
	
	try {
	Role roleEnum = Role.valueOf(Roleparam.toUpperCase()); 
    user.setRole(roleEnum);
	}catch(IllegalArgumentException e) {
		e.printStackTrace();
	}
	UserDaoimpl uri=new UserDaoimpl();
	user.setPassword("temp");
	int userId = uri.registerUser(user);
	
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	if (userId > 0) {
	    // Step 2: Build default password = username + id
	    String finalPassword = username + userId;

	    // Step 3: Update password in DB
	   uri.updatePassword(userId, finalPassword);
        String finalPassword1 = username + userId;
        uri.updatePassword(userId, finalPassword1);
    	req.setAttribute("success", "User registered successfully!");
    	req.setAttribute("view", "registerUser");
    	req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
	}else {
		req.setAttribute("error", "User registration failed!");
	    req.setAttribute("view", "registerUser");
	    req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
	}
}
}
