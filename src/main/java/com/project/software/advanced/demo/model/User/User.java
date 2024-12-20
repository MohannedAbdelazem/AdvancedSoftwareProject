/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.software.advanced.demo.model.Course.Course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Mohanned
 */

@Entity
@Table(name = "app_user")
public class User implements UserDetails {
	@Id
	@GeneratedValue
	private int userID;

	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToMany(mappedBy = "students")
	private Set<Course> courses = new HashSet<>();

	private int CourseListID;

	public User(String name, String email, String password, String role, int CourseListID) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.CourseListID = CourseListID;
		this.role = Role.valueOf(role.toUpperCase());
	}

	public User() {
	}

	public User(String name, String email, String password, Role role, int CourseListID) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.CourseListID = CourseListID;
		this.role = role;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	public int getUserID() {
		return userID;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public int getCourseListID() {
		return CourseListID;
	}

	public void setCourseListID(int courseListID) {
		CourseListID = courseListID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return email;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" +
				"userID=" + userID +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", role=" + role +
				'}';
	}
}
