package com.studentmanagement.repository;

import java.util.List;

import com.studentmanagement.model.Enrollment;
import com.studentmanagement.model.Student;

public interface EnrollmentDao {
	boolean registerEnrollment(Enrollment eri);
	List<Enrollment> getAllEnrollments();
	boolean deleteEnrollment(int enrollmentId);
	Enrollment getEnrollmentById(int enrollmentId);
	boolean updateStudentById(Enrollment enrollment);
}
