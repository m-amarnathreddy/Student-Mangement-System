package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.model.Enrollment;
import com.studentmanagement.repository.EnrollmentDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/GetEnrollment")
public class GetEnrollment extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("eid"));
	EnrollmentDaoimpl Edi=new EnrollmentDaoimpl();
	Enrollment en=Edi.getEnrollmentById(id);
	req.setAttribute("enrollment", en);
	RequestDispatcher rd=req.getRequestDispatcher("EnrollmentDetails.jsp");
	rd.forward(req, resp);
}
}
