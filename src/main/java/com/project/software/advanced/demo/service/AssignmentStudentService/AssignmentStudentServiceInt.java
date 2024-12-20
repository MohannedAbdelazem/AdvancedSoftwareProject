package com.project.software.advanced.demo.service.AssignmentStudentService;

import java.util.Date;

import org.springframework.stereotype.Service;

public interface AssignmentStudentServiceInt {
	void assignStudentToAssignment(int studentId, int assignmentId, Date dueDate);

	void submitAssignment(int studentId, int assignmentId);

	void gradeAssignment(int studentId, int assignmentId, double grade);
}
