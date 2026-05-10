package com.studentmanagement.controller;

import java.io.IOException;
import java.util.List;

import com.studentmanagement.repository.StudentCourseDaoimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/StudentCourse")
public class StudentCourse extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 StudentCourseDaoimpl dao = new StudentCourseDaoimpl();
     List<com.studentmanagement.model.StudentCourse> details = dao.getStudentCourseDetails();
     req.setAttribute("details", details);
     req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
}
}
