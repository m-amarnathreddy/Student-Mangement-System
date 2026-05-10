package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.model.Student;
import com.studentmanagement.model.User;
import com.studentmanagement.repository.StudentDaoimpl;
import com.studentmanagement.repository.UserDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/GetUser")
public class GetUser extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("uid"));
	UserDaoimpl Udi=new UserDaoimpl();
	User user=Udi.getUserById(id);
	req.setAttribute("user", user);
	RequestDispatcher rd=req.getRequestDispatcher("UserDetails.jsp");
	rd.forward(req, resp);
}
}
