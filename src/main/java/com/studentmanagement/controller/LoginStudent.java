package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/StudentLogin")
public class LoginStudent extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("LoginStudent.jsp").forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String email = req.getParameter("email");
	  String password = req.getParameter("password");
	  System.out.println("Email=" + email + ", Password=" + password);
	  StudentDaoimpl Sdi=new StudentDaoimpl();
	  Student student=Sdi.loginStudent(email, password);
	  if(student != null) {
	         HttpSession session = req.getSession();
	         session.setAttribute("studentdata", student);
	         resp.sendRedirect("StudentDashboard.jsp");
	  } else {
	             resp.sendRedirect("LoginStudent.jsp?error=Invalid credentials");
	         }
	}
}
