/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.Course;

import java.util.HashSet;
import java.util.Set;

import com.project.software.advanced.demo.model.Assignment.Assignment;
import com.project.software.advanced.demo.model.User.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

/**
 *
 * @author Mohanned
 */
@Entity
public class Course {
	@Id
	@GeneratedValue
	private int courseID;
	private String courseName;

	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<User> students = new HashSet<>();

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Assignment> assignments = new HashSet<>();

	private int courseInstructorID;
	private int quizListID;

	public Set<User> getStudents() {
		return students;
	}

	public void setStudents(Set<User> students) {
		this.students = students;
	}

	public void setQuizListID(int quizListID) {
		this.quizListID = quizListID;
	}

	public int getQuizListID() {
		return quizListID;
	}

	public int getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCourseInstructorID() {
		return courseInstructorID;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseInstructorID(int courseInstructorID) {
		this.courseInstructorID = courseInstructorID;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
		assignment.setCourse(this);
	}

	public void removeAssignment(Assignment assignment) {
		assignments.remove(assignment);
		assignment.setCourse(null);
	}

	@Override
	public String toString() {
		return "Course{" +
				"courseID=" + courseID +
				", courseName='" + courseName + '\'' +
				", courseInstructorID=" + courseInstructorID +
				", QuizListID=" + quizListID +
				'}';
	}

}
