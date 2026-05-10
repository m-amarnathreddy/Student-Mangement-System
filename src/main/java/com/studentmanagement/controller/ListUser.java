package com.studentmanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.User;
import com.studentmanagement.repository.UserDaoimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ListUsers")
public class ListUser extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection con=Dbconn1.getConnection();
	UserDaoimpl udi=new UserDaoimpl();
	List<User> ulist=udi.getAllUsers();
	req.setAttribute("users", ulist);
	RequestDispatcher rd=req.getRequestDispatcher("UserList.jsp");
	rd.forward(req, resp);
}
}
