package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.repository.CourseDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int courseId=Integer.parseInt(req.getParameter("courseId"));
	CourseDaoimpl Cdi=new CourseDaoimpl();
	boolean isdeleted=Cdi.deleteCourse(courseId);
	if(isdeleted) {
		resp.sendRedirect(req.getContextPath() +"/Dashboard?view=courses");
	}
}
}
