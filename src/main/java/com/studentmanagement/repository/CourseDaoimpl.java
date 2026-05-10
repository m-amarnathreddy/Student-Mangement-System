package com.studentmanagement.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.Course;

public class CourseDaoimpl implements CourseDao {
	Connection con=Dbconn1.getConnection();
	@Override
	public boolean registerCourse(Course course) {
		String registerQuery="INSERT INTO course(course_name,description,credits) values(?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(registerQuery);
			pstmt.setString(1, course.getCourseName());
			pstmt.setString(2, course.getDescription());
			pstmt.setInt(3, course.getCredits());
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;	
	}
	@Override
	public List<Course> getAllCourse() {
		String allCourses="SELECT * FROM course";
		List<Course> clist=new ArrayList<Course>();
		try {
			PreparedStatement pstmt=con.prepareStatement(allCourses);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Course course=new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDescription(rs.getString(3));
				course.setCredits(rs.getInt(4));
				clist.add(course);
			}
		} catch (SQLException e) {
			System.out.println("error got"+ e.getMessage());
			e.printStackTrace();
		}
		return clist;
	}
	@Override
	public boolean deleteCourse(int courseId) {
		String deleteCourse="DELETE FROM course WHERE course_id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(deleteCourse);
			pstmt.setInt(1, courseId);
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Course getCourseById(int courseId) {
		String cQuery="SELECT * FROM course WHERE course_id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(cQuery);
			pstmt.setInt(1, courseId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				Course cur=new Course();
				cur.setCourseId(rs.getInt(1));
				cur.setCourseName(rs.getString(2));
				cur.setDescription(rs.getString(3));
				cur.setCredits(rs.getInt(4));
				return cur;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updateCourseById(Course course) {
		String cQuery="UPDATE course SET course_name=?,description=?,credits=? WHERE course_id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(cQuery);
			pstmt.setString(1, course.getCourseName());
			pstmt.setString(2, course.getDescription());
			pstmt.setInt(3,course.getCredits());
			pstmt.setInt(4,course.getCourseId());
			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
