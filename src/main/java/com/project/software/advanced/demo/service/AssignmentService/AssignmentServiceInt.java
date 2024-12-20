package com.project.software.advanced.demo.service.AssignmentService;

import java.util.List;

import com.project.software.advanced.demo.model.Assignment.Assignment;

public interface AssignmentServiceInt {
	Assignment getAssignmentById(int assignmentID);

	Assignment saveAssignment(Assignment assignment);

	Assignment updateAssignment(Assignment assignment, int assignmentID);

	void deleteAssignment(int assignmentID);

	List<Assignment> fetchAssignments();
}
