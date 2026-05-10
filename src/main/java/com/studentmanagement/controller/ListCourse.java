package com.studentmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.Course;
import com.studentmanagement.repository.CourseDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ListCourse")
public class ListCourse extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection con=Dbconn1.getConnection();
	CourseDaoimpl cdi=new CourseDaoimpl();
	List<Course> clist=cdi.getAllCourse();
	req.setAttribute("Courses", clist);
	RequestDispatcher rd=req.getRequestDispatcher("CourseList.jsp");
	rd.forward(req, resp);
}
}
