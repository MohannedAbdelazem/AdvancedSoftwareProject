/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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
	private int courseInstructorID;
	private int quizListID;

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
