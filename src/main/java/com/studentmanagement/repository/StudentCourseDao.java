package com.studentmanagement.repository;

import java.util.List;

import com.studentmanagement.model.StudentCourse;

public interface StudentCourseDao {
	List<StudentCourse> getStudentCourseDetails() ;
	 List<StudentCourse> getStudentCourseDetailsByStudentId(int studentId);
}
