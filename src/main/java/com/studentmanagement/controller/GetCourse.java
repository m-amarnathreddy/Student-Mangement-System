package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.model.Course;
import com.studentmanagement.repository.CourseDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/GetCourse")
public class GetCourse extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("cid"));
	CourseDaoimpl Cdi=new CourseDaoimpl();
	Course course=Cdi.getCourseById(id);
	req.setAttribute("course", course);
	RequestDispatcher rd=req.getRequestDispatcher("CourseDetails.jsp");
	rd.forward(req, resp);
}
}
