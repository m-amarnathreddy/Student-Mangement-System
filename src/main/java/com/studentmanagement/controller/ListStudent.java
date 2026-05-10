package com.studentmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ListStudents")
public class ListStudent extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection con=Dbconn1.getConnection();
	StudentDaoimpl sri=new StudentDaoimpl();
	List<Student> slist=sri.getAllStudents();
	 req.setAttribute("students", slist);
	 req.setAttribute("view", "students");
     RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
     rd.forward(req, resp);
}
}
