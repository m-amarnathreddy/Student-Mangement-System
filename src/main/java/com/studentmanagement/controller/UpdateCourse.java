package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.model.Course;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.CourseDaoimpl;
import com.studentmanagement.repository.StudentDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/UpdateCourse")
public class UpdateCourse extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int courseId=Integer.parseInt(req.getParameter("courseId"));
		CourseDaoimpl Cdi=new CourseDaoimpl();
		Course cu=Cdi.getCourseById(courseId);
		req.setAttribute("course", cu);
	    req.getRequestDispatcher("UpdateCourse.jsp").forward(req, resp);

	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int courseidId=Integer.parseInt(req.getParameter("courseId"));
			String courseName=req.getParameter("course_name");
			String description=req.getParameter("description");
			int credits=Integer.parseInt(req.getParameter("credits"));
			Course cu=new Course();
			cu.setCourseId(courseidId);
			cu.setCourseName(courseName);
			cu.setDescription(description);
			cu.setCredits(credits);
		CourseDaoimpl Cdi = new CourseDaoimpl();
			boolean isUpdated=Cdi.updateCourseById(cu);
			resp.setContentType("text/html");
			String origin = req.getParameter("origin");

			if (isUpdated) {
			    System.out.println("Updated Student Successfully");
			    if (origin != null && !origin.isEmpty()) {
			        resp.sendRedirect(req.getContextPath() + "/" + origin);
			    } else {
			        resp.sendRedirect(req.getContextPath() + "/Dashboard?view=courses");
			    }
			}else {
				System.out.println("Update Failed");
				 resp.sendRedirect("error.jsp");
			}
		}
}
