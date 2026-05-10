package com.studentmanagement.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.Student;

public class StudentDaoimpl implements StudentDao {
	Connection con = Dbconn1.getConnection();

	@Override
	public boolean registerStudent(Student student) {
		String registerQuery = "INSERT INTO student(name,email,dob,address,phone,password) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(registerQuery);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail().toLowerCase());
			pstmt.setDate(3, java.sql.Date.valueOf(student.getDob()));
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getPhone());
			pstmt.setString(6, student.getPassword());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while inserting ." + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> getAllStudents() {
		String allstudents = "SELECT * FROM student";
		List<Student> Slist = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(allstudents);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student std = new Student();
				std.setId(rs.getInt(1));
				std.setName(rs.getString(2));
				std.setEmail(rs.getString(3));
				std.setDob(rs.getString(4));
				std.setAddress(rs.getString(5));
				std.setPhone(rs.getString(6));
				Slist.add(std);
			}
			return Slist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteStudentById(int studentId) {
		String deleteStudent = "DELETE FROM student WHERE student_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(deleteStudent);
			pstmt.setInt(1, studentId);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student getStudentById(int studentId) {
		String sQuery="SELECT * FROM student where student_id=?";
		Student std=new Student();
		try {
			PreparedStatement pstmt=con.prepareStatement(sQuery);
			pstmt.setInt(1, studentId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				std.setId(rs.getInt("student_id"));
				std.setName(rs.getString("name"));
				std.setEmail(rs.getString("email"));
				std.setDob(rs.getString("dob"));
				std.setAddress(rs.getString("address"));
				std.setPhone(rs.getString("phone"));
				std.setPassword(rs.getString("password"));
			}
			return std;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
	}

	@Override
	public boolean updateStudentById(Student student) {
		String sQuery="UPDATE student SET name=?,email=?,dob=?,address=?,phone=?,password=? WHERE student_id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(sQuery);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail().toLowerCase());
			pstmt.setDate(3, java.sql.Date.valueOf(student.getDob()));
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getPhone());
			pstmt.setString(6, student.getPassword());
			pstmt.setInt(7,student.getId());
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

	@Override
	public Student loginStudent(String email, String password) {
		String sQuery="SELECT * FROM student WHERE email=? AND password=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(sQuery);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				Student std=new Student();
				std.setId(rs.getInt("student_id"));
				std.setName(rs.getString("name"));
				std.setEmail(rs.getString("email"));
				std.setDob(rs.getString("dob"));
				std.setAddress(rs.getString("address"));
				std.setPhone(rs.getString("phone"));
				std.setPassword(rs.getString("password"));
				return std;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateEmailAndPassword(int id, String email, String password) {
		String sql = "UPDATE student SET email=?, password=? WHERE student_id=?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, email.toLowerCase());
	        ps.setString(2, password);
	        ps.setInt(3, id);
	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
		
	}

}
