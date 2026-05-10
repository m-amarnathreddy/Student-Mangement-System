package com.studentmanagement.repository;

import java.util.List;

import com.studentmanagement.model.Course;
import com.studentmanagement.model.Student;

public interface CourseDao {
boolean registerCourse(Course course);
List<Course> getAllCourse();
boolean deleteCourse(int courseId);
Course getCourseById(int courseId);
boolean updateCourseById(Course course);
}
