package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.repository.StudentDao;
import com.studentmanagement.repository.StudentDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Delete")
public class DeleteStudent extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int studentId=Integer.parseInt(req.getParameter("sid")) ;
	StudentDao udao=new StudentDaoimpl();
	
	boolean isDeleted =udao.deleteStudentById(studentId);
	if(isDeleted)
	{
		
		resp.sendRedirect(req.getContextPath() +"/Dashboard?view=students");
	}
}
}
