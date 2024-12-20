package com.project.software.advanced.demo.model.Assignment;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.project.software.advanced.demo.model.AssignmentsStudent.AssignmentStudent;
import com.project.software.advanced.demo.model.Course.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 *
 * @author Mohanned
 */

@Entity
public class Assignment {
	@Id
	@GeneratedValue
	private int assignmentID;

	private String title;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	private Date dueDate;

	@OneToMany(mappedBy = "assignment")
	private Set<AssignmentStudent> students = new HashSet<>();

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int id) {
		this.assignmentID = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<AssignmentStudent> getStudents() {
		return students;
	}

	public void setStudents(Set<AssignmentStudent> students) {
		this.students = students;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
