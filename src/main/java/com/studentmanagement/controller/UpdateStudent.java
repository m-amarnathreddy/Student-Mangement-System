package com.studentmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentmanagement.model.Student;
import com.studentmanagement.model.User;
import com.studentmanagement.repository.StudentCourseDaoimpl;
import com.studentmanagement.repository.StudentDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int studentId=Integer.parseInt(req.getParameter("id"));
	StudentDaoimpl Sdi=new StudentDaoimpl();
	Student std=Sdi.getStudentById(studentId);
	req.setAttribute("student", std);
	req.getSession().setAttribute("studentdata", std); 
    req.getRequestDispatcher("UpdateStudent.jsp").forward(req, resp);

}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sidParam=req.getParameter("sid");
		int studentId;
		if(sidParam != null && !sidParam.isEmpty()) {
		    studentId = Integer.parseInt(sidParam);
		} else {
		    Student sessionStd = (Student) req.getSession().getAttribute("studentdata");
		    studentId = sessionStd.getId();
		}
		StudentDaoimpl Sdi=new StudentDaoimpl();
		Student existing=Sdi.getStudentById(studentId);
		String studentName=req.getParameter("sname");
	    if(studentName == null || studentName.isEmpty()) {
	    	studentName = existing.getName();
	    }
		String email=req.getParameter("email");
	    if(email == null || email.isEmpty()) {
	        email = existing.getEmail();
	    }
		String dob=req.getParameter("dob");
		if(dob == null || dob.isEmpty()) {
			dob = existing.getDob();
	    }
		String address=req.getParameter("address");
		if(address == null || address.isEmpty()) {
			address = existing.getAddress();
	    }
		String phone=req.getParameter("phone");
		if(phone == null ||phone.isEmpty()) {
			phone = existing.getPhone();
	    }
		User user = (User) req.getSession().getAttribute("userdata");
		String password=req.getParameter("password");
		if(password == null || password.isEmpty()) {
			password = existing.getPassword();
	    }
		if(user != null && user.getRole() == User.Role.ADMIN) {
		    password = existing.getPassword();
		}
		if(existing.getPassword() == null) {
		    System.out.println("Warning: existing password is null for student " + studentId);
		}
		Student std=new Student();
		std.setId(studentId);
		std.setName(studentName);
		std.setEmail(email);
		std.setDob(dob);
		std.setAddress(address);
		std.setPhone(phone);
		std.setPassword(password);

		StudentDaoimpl sri = new StudentDaoimpl();
		boolean isUpdated=sri.updateStudentById(std);
		resp.setContentType("text/html");
		if (isUpdated) {
		    System.out.println("Updated Student Successfully");
		    req.getSession().setAttribute("studentdata", sri.getStudentById(studentId));
			String origin = req.getParameter("origin");

		    if (origin != null && !origin.isEmpty()) {
		        resp.sendRedirect(req.getContextPath() + "/" + origin + "&success=Profile updated successfully");
		    	}	else  if ("Dashboard?view=studentd".equals(origin)) {
		        resp.sendRedirect(req.getContextPath() + "/Dashboard?view=studentd&success=Profile updated successfully");
		    }else if ("StudentCourse".equals(origin)) {
		        resp.sendRedirect(req.getContextPath() + "/Dashboard?view=studentcourse");
		    }  else {
		        resp.sendRedirect(req.getContextPath() + "/Dashboard?view=students");
		    }
		} else {
		    System.out.println("Update Failed");
		    resp.sendRedirect("error.jsp");
		}
	}
}
