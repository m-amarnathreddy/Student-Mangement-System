package com.studentmanagement.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import com.studentmanagement.model.Course;
import com.studentmanagement.repository.CourseDaoimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register4")
public class RegisterCourse extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String course_name=req.getParameter("course_name");
	String description=req.getParameter("description");
    String credits=req.getParameter("credits");
    
    if (description == null || description.isEmpty() ||
            course_name == null || course_name.isEmpty() ||
            credits == null || credits.isEmpty()) {
            
    	 req.setAttribute("error", "All fields are required");
    	 req.setAttribute("view", "registerCourse");
    	 req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
            
            return;
    }
    int credit = Integer.parseInt(credits);
    Course course=new Course();
    course.setCourseName(course_name);
    course.setDescription(description);
    course.setCredits(credit);
    
    CourseDaoimpl cri=new CourseDaoimpl();
    boolean isregisterd=cri.registerCourse(course);
    resp.setContentType("text/html");
    PrintWriter out=resp.getWriter();
    if(isregisterd) {
         List<Course> courses = cri.getAllCourse();
    	req.setAttribute("success", "Course registered successfully!");
    	req.setAttribute("courses", courses);  // pass list to JSP 
    	req.setAttribute("view", "courses");
    	req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
        
    }else {
    	 req.setAttribute("error", "Course registration failed!");
    	 req.setAttribute("view", "registerCourse");
    	 req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
    }
	
}
}
