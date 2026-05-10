package com.studentmanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.Enrollment;

public class EnrollmentDaoimpl implements EnrollmentDao{
Connection con=Dbconn1.getConnection();
	@Override
	public boolean registerEnrollment(Enrollment eri) {
		String registerQuery="INSERT INTO enrollment(student_id,course_id,grade) values(?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(registerQuery);
			pstmt.setInt(1,eri.getStudent_id());
			pstmt.setInt(2,eri.getCourse_id());
			pstmt.setString(3,eri.getGrade());
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Enrollment> getAllEnrollments() {
		String allEnrollments="SELECT * FROM enrollment";
		List<Enrollment> elist=new ArrayList<>();
		try {
			PreparedStatement pstmt=con.prepareStatement(allEnrollments);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Enrollment en=new Enrollment();
				en.setEnrollment_id(rs.getInt(1));
				en.setStudent_id(rs.getInt(2));
				en.setCourse_id(rs.getInt(3));
				en.setGrade(rs.getString(4));
				elist.add(en);
			}return elist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deleteEnrollment(int enrollmentId) {
		String deleteenr="DELETE FROM enrollment WHERE enrollment_id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(deleteenr);
			pstmt.setInt(1, enrollmentId);
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
	public Enrollment getEnrollmentById(int enrollmentId) {
		String eQuery="SELECT * FROM enrollment WHERE enrollment_id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(eQuery);
			pstmt.setInt(1, enrollmentId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				Enrollment en1=new Enrollment();
				en1.setEnrollment_id(rs.getInt(1));
				en1.setStudent_id(rs.getInt(2));
				en1.setCourse_id(rs.getInt(3));
				en1.setGrade(rs.getString(4));
				return en1;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updateStudentById(Enrollment enrollment) {
		String eQuery="UPDATE enrollment SET student_id=?,course_id=?,grade=? WHERE enrollment_id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(eQuery);
			pstmt.setInt(1, enrollment.getStudent_id());
			pstmt.setInt(2, enrollment.getCourse_id());
			pstmt.setString(3, enrollment.getGrade());
			pstmt.setInt(4, enrollment.getEnrollment_id());
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

}
