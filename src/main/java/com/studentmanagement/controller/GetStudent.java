package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/GetStudent")
public class GetStudent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("Sid"));
		StudentDaoimpl Sdi=new StudentDaoimpl();
		Student std=Sdi.getStudentById(id);
		req.setAttribute("student", std);
		RequestDispatcher rd=req.getRequestDispatcher("StudentDetails.jsp");
		rd.forward(req, resp);
	}
}
