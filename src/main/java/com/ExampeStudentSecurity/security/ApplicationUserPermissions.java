package com.ExampeStudentSecurity.security;

public enum ApplicationUserPermissions {
		STUDENT_READ("student:read"),
		STUDENT_WRITE("student:write"),
		COURSE_READ("course:read"),
		COURSE_WRITE("course:write");
	
	private final String permission;

	/**
	 * @param permission
	 */
	private ApplicationUserPermissions(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	
		
}
