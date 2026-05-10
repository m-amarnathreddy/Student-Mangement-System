package com.studentmanagement.controller;

import java.io.IOException;
import java.sql.Connection;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.repository.EnrollmentDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteEnrollment")
public class DeleteEnrollment extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int enrollmentId=Integer.parseInt(req.getParameter("enrollmentId")) ;
	EnrollmentDaoimpl Edi=new EnrollmentDaoimpl();
	boolean isdeleted=Edi.deleteEnrollment(enrollmentId);
	if(isdeleted) {
		resp.sendRedirect(req.getContextPath() +"/Dashboard?view=enrollments");
	}
}
}
