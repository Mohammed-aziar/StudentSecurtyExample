package com.ExampeStudentSecurity;

public class Student {
	private Integer studentId;
	private String name;
	/**
	 * @param i
	 * @param name
	 */
	public Student(Integer studentID, String name) {
		super();
		this.studentId = studentID;
		this.name = name;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
