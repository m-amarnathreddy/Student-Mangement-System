package com.studentmanagement.controller;

import java.io.IOException;


import com.studentmanagement.model.User;
import com.studentmanagement.repository.UserDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String username = req.getParameter("username");
     String password = req.getParameter("password");
     String role = req.getParameter("role");
     UserDaoimpl udi=new UserDaoimpl();
     User user = udi.loginUser(username, password, role);
     if(user != null) {
         HttpSession session = req.getSession();
         session.setAttribute("userdata", user);
         resp.sendRedirect("Dashboard");
     } else {
         resp.sendRedirect("Login.jsp?error=Invalid credentials");
     }
}
}
