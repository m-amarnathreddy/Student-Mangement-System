package com.studentmanagement.model;

public class Enrollment {
	private  int enrollment_id;
    private  int student_id;
    private  int course_id;
    private  String grade;
	public  int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student) {
		this.student_id = student;
	}
	public  int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course) {
		this.course_id = course;
	}
	public  String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public  int getEnrollment_id() {
		return enrollment_id;
	}
	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
	}
}
