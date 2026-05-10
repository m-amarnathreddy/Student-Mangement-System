package com.studentmanagement.controller;

import java.io.IOException;

import com.studentmanagement.repository.UserDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int userId=Integer.parseInt(req.getParameter("uid"));
	UserDaoimpl Udi=new UserDaoimpl();
	boolean isdeleted=Udi.deleteUserById(userId);
	if(isdeleted) {
		resp.sendRedirect("ListUsers");
	}
}
}
