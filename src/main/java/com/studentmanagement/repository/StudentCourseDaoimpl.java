package com.studentmanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.Utill.Dbconn1;
import com.studentmanagement.model.StudentCourse;

public class StudentCourseDaoimpl implements StudentCourseDao {
	public List<StudentCourse> getStudentCourseDetails() {
		List<StudentCourse> list = new ArrayList<>();
		try (Connection con = Dbconn1.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT s.student_id,s.name,s.email,s.dob,s.address,s.phone,c.course_id,"
					+ "c.course_name,c.description,c.credits,e.enrollment_id,e.grade FROM student s "
							+ "JOIN enrollment e ON s.student_id = e.student_id "
							+ "JOIN course c ON e.course_id = c.course_id ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentCourse sc = new StudentCourse();
				sc.setStudentid(rs.getInt("student_id"));
				sc.setName(rs.getString("name"));
				sc.setEmail(rs.getString("email"));
				sc.setDob(rs.getString("dob"));
				sc.setAddress(rs.getString("address"));
				sc.setPhone(rs.getString("phone"));
				sc.setCourseId(rs.getInt("course_id"));
				sc.setCourse_name(rs.getString("course_name"));
				sc.setDescription(rs.getString("description"));
				sc.setCredits(rs.getInt("credits"));
				sc.setEnrollment_id(rs.getInt("enrollment_id"));
				sc.setGrade(rs.getString("grade"));
				
				list.add(sc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	  // For students: only their own records
    public List<StudentCourse> getStudentCourseDetailsByStudentId(int studentId) {
        List<StudentCourse> list = new ArrayList<>();
        try (Connection con = Dbconn1.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT s.student_id,s.name,s.email,s.dob,s.address,s.phone," +
                "c.course_id,c.course_name,c.description,c.credits," +
                "e.enrollment_id,e.grade " +
                "FROM student s " +
                "JOIN enrollment e ON s.student_id = e.student_id " +
                "JOIN course c ON e.course_id = c.course_id " +
                "WHERE s.student_id = ?"
            );
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentCourse sc = new StudentCourse();
                sc.setStudentid(rs.getInt("student_id"));
                sc.setName(rs.getString("name"));
                sc.setEmail(rs.getString("email"));
                sc.setDob(rs.getString("dob"));
                sc.setAddress(rs.getString("address"));
                sc.setPhone(rs.getString("phone"));
                sc.setCourseId(rs.getInt("course_id"));
                sc.setCourse_name(rs.getString("course_name"));
                sc.setDescription(rs.getString("description"));
                sc.setCredits(rs.getInt("credits"));
                sc.setEnrollment_id(rs.getInt("enrollment_id"));
                sc.setGrade(rs.getString("grade"));
                list.add(sc);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

