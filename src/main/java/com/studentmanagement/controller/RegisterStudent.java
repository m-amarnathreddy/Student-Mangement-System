package com.studentmanagement.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class RegisterStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("sname");
		String email=req.getParameter("email");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		if (name == null || name.isEmpty() ||
		        email == null || email.isEmpty() ||
		        dob == null || dob.isEmpty() ||
		        address == null || address.isEmpty() ||
		        phone == null || phone.isEmpty() ||
		        password == null || password.isEmpty()) {

		        req.setAttribute("errorMsg", "All fields are required!");
		        req.getRequestDispatcher("Register.jsp").forward(req, resp);
		        return;
		    }
		
		Student std=new Student();
		std.setName(name);
		std.setEmail(email);
		std.setDob(dob);
		std.setAddress(address);
		std.setPhone(phone);
		std.setPassword(password);
		
		StudentDaoimpl sri = new StudentDaoimpl();
		boolean isRegisterd=sri.registerStudent(std);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		if(isRegisterd) {
			System.out.println("Register Student Sucessfully");
	        resp.sendRedirect("LoginStudent.jsp?success=Registration successful, please login..");
		}else {
			 req.setAttribute("errorMsg", "Registration failed. Try again.");
		        req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
	}

}
