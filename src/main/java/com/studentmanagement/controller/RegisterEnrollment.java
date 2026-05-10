package com.studentmanagement.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import com.studentmanagement.model.Enrollment;
import com.studentmanagement.repository.EnrollmentDaoimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register3")
public class RegisterEnrollment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String student_id = req.getParameter("student_id");
		String course_id = req.getParameter("course_id");
		String grade = req.getParameter("grade");
		 if (student_id== null || student_id.isEmpty() ||
		            course_id == null || course_id.isEmpty() ) {
		            
		    	 req.setAttribute("error", "All fields are required");
		    	 req.setAttribute("view", "registerEnrollment");
		    	 req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
		            
		            return;
		    }
int student_id1=Integer.parseInt(student_id);
int course_id1 = Integer.parseInt(course_id);
		Enrollment en = new Enrollment();
		en.setStudent_id(student_id1);
		en.setCourse_id(course_id1);
		//en.setGrade(grade);

		EnrollmentDaoimpl eri = new EnrollmentDaoimpl();
		boolean isRegisterd = eri.registerEnrollment(en);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (isRegisterd) {
			List<Enrollment> enrollment=eri.getAllEnrollments();
			req.setAttribute("success", "Enrolment registered successfully!");
	    	req.setAttribute("enrollments", enrollment);  // pass list to JSP 
	    	req.setAttribute("view", "enrollments");
	    	req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
		} else {
			 req.setAttribute("error", "Course registration failed!");
	    	 req.setAttribute("view", "registerEnrollment");
	    	 req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
		}
	}
}
