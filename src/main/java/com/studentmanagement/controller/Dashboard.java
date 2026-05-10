package com.studentmanagement.controller;

import java.io.IOException;
import java.util.List;

import com.studentmanagement.model.Course;
import com.studentmanagement.model.Enrollment;
import com.studentmanagement.model.Student;
import com.studentmanagement.model.StudentCourse;
import com.studentmanagement.model.User;
import com.studentmanagement.repository.CourseDaoimpl;
import com.studentmanagement.repository.EnrollmentDaoimpl;
import com.studentmanagement.repository.StudentCourseDaoimpl;
import com.studentmanagement.repository.StudentDaoimpl;
import com.studentmanagement.repository.UserDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String view = req.getParameter("view");
		Student student = (Student) req.getSession().getAttribute("studentdata");
		User user = (User) req.getSession().getAttribute("userdata");

		 User currentUser = (User) req.getSession().getAttribute("userdata");
		if ("students".equals(view)) {
			StudentDaoimpl studentDao = new StudentDaoimpl();
			List<Student> students = studentDao.getAllStudents();
			req.setAttribute("students", students);
			req.setAttribute("view", "students");

		} else if ("courses".equals(view)) {
			CourseDaoimpl courseDao = new CourseDaoimpl();
			List<Course> courses = courseDao.getAllCourse();
			req.setAttribute("courses", courses);

		} else if ("studentcourse".equals(view)) {
			StudentCourseDaoimpl scDao = new StudentCourseDaoimpl();
			
			if (student != null) {
				// Student → only their records
				List<StudentCourse> details = scDao.getStudentCourseDetailsByStudentId(student.getId());
				req.setAttribute("details", details);
			} else if (user != null) {
				// Admin/teacher → all records
				List<StudentCourse> details = scDao.getStudentCourseDetails();
				req.setAttribute("details", details);
			}
		} else if ("enrollments".equals(view)) {
			EnrollmentDaoimpl enrollmentDao = new EnrollmentDaoimpl();
			List<Enrollment> enrollments = enrollmentDao.getAllEnrollments();
			req.setAttribute("enrollments", enrollments);
			
		} else if("userdetails".equals(view)) {
			
			    if (currentUser == null) {
			        resp.sendRedirect("Login.jsp");
			        return;
			    }
			    req.setAttribute("userdetails", currentUser);
		}
		
		else if ("registerCourse".equals(view)) {	    
		    req.setAttribute("view", "registerCourse");
		} else if ("registerUser".equals(view)) {
		    req.setAttribute("view", "registerUser");
		} else if ("registerEnrollment".equals(view)) {
		    req.setAttribute("view", "registerEnrollment");
		}
		if (user != null && user.getRole() == User.Role.ADMIN || user.getRole() == User.Role.TEACHER) {
		    // Admin/User → Dashboard.jsp
		    req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);
		}else if(student !=null) {
			req.getRequestDispatcher("StudentDashboard.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("Login.jsp");
		}
	}

}
