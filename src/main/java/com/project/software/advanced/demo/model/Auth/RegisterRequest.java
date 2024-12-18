package com.project.software.advanced.demo.model.Auth;

public class RegisterRequest {

	private String name;
	private String email;
	private String password;
	private String role;
	private int CourseListID;

	public RegisterRequest(String name, String email, String password, String role, int courseListID) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.CourseListID = courseListID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	// Setter for password
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCourseListID() {
		return CourseListID;
	}

	public void setCourseListID(int courseListID) {
		this.CourseListID = courseListID;
	}
}
