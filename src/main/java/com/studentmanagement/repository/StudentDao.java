package com.studentmanagement.repository;

import java.util.List;


import com.studentmanagement.model.Student;
import com.studentmanagement.model.User;

public interface StudentDao{
	boolean registerStudent(Student student);
	List<Student> getAllStudents();
	boolean deleteStudentById(int studentId);
	Student getStudentById(int studentId);
	boolean updateStudentById(Student student);
	Student loginStudent(String email,String password);
	}


