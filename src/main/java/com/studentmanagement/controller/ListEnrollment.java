package com.studentmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.Enrollment;
import com.studentmanagement.repository.EnrollmentDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ListEnrollment")
public class ListEnrollment extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=Dbconn1.getConnection();
		EnrollmentDaoimpl edi=new EnrollmentDaoimpl();
		List<Enrollment> elist=edi.getAllEnrollments();
		req.setAttribute("enrollments", elist);
		RequestDispatcher rd=req.getRequestDispatcher("EnrollmentList.jsp");
		rd.forward(req, resp);
		
	}

}
