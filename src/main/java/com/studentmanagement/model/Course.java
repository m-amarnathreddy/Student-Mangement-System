package com.studentmanagement.model;

public class Course {
	   private  int courseId;
	    private  String courseName;
	    private  String description;
	    private  int credits;
	    public int getCourseId() {
			return courseId;
	    }
	    public void setCourseId(int courseId) {
	    	this.courseId=courseId;
	    }
	    public  String getCourseName() {
			return courseName;
	    }
	    public void setCourseName(String courseName) {
	    	this.courseName=courseName;
	    }
	    public  int getCredits() {
			return credits;
	    }
	    public  void setCredits(int credits) {
	    	this.credits=credits;
	    }
		public  String getDescription() {
			return description;
		}
		public  void setDescription(String description) {
			this.description = description;
		}
}
