package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.model.Enrollment;
import com.studentmanagement.repository.EnrollmentDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/UpdateEnrollment")
public class UpdateEnrollment extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eidParam = req.getParameter("enrollmentId");
	    if(eidParam == null || eidParam.trim().isEmpty()) {
	        System.out.println("Enrollment ID missing");
	        resp.sendRedirect("error.jsp");
	        return;
	    }
		int enrollmentId=Integer.parseInt(eidParam);
		EnrollmentDaoimpl Edi=new EnrollmentDaoimpl();
		Enrollment en=Edi.getEnrollmentById(enrollmentId);
		req.setAttribute("enrollment", en);
	    req.getRequestDispatcher("UpdateEnrollment.jsp").forward(req, resp);

	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String eidParam = req.getParameter("enrollmentId");
	    if(eidParam == null || eidParam.trim().isEmpty()) {
	        System.out.println("Enrollment ID missing");
	        resp.sendRedirect("error.jsp");
	        return;
	    }int enrollmentId=Integer.parseInt(eidParam);
			int studentId=Integer.parseInt(req.getParameter("student_id"));
			int courseId=Integer.parseInt(req.getParameter("course_id"));
			String grade=req.getParameter("grade");
		Enrollment en=new Enrollment();
			en.setEnrollment_id(enrollmentId);
			en.setStudent_id(studentId);
			en.setCourse_id(courseId);
			en.setGrade(grade);
			EnrollmentDaoimpl Edi = new EnrollmentDaoimpl();
			boolean isUpdated=Edi.updateStudentById(en);
			resp.setContentType("text/html");
			String origin = req.getParameter("origin");

			if(isUpdated) {
				 System.out.println("Updated Student Successfully");
				    if (origin != null && !origin.isEmpty()) {
				        resp.sendRedirect(req.getContextPath() + "/" + origin);
				    } else {
				        resp.sendRedirect(req.getContextPath() + "/Dashboard?view=enrollments");
				    }
			}else {
				System.out.println("Update Failed");
				 resp.sendRedirect("error.jsp");
			}
		}

}
