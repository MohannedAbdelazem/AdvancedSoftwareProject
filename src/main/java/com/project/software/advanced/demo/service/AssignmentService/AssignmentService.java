package com.project.software.advanced.demo.service.AssignmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.Assignment.Assignment;
import com.project.software.advanced.demo.model.Assignment.AssignmentRepository;

@Service
public class AssignmentService implements AssignmentServiceInt {
	@Autowired
	private AssignmentRepository assignmentRepository;

	@Override
	public Assignment getAssignmentById(int assignmentID) {
		Optional<Assignment> assignment = assignmentRepository.findById(assignmentID);
		if (assignment.isPresent()) {
			return assignment.get();
		}
		return null;
	}

	@Override
	public Assignment saveAssignment(Assignment assignment) {
		return assignmentRepository.save(assignment);
	};

	@Override
	public Assignment updateAssignment(Assignment assignment, int assignmentID) {
		Optional<Assignment> existingAssignmentOptional = assignmentRepository.findById(assignmentID);
		if (!existingAssignmentOptional.isPresent()) {
			return null;
		}
		Assignment existingAssignment = existingAssignmentOptional.get();
		existingAssignment.setTitle(assignment.getTitle());
		existingAssignment.setDueDate(assignment.getDueDate());
		return assignmentRepository.save(existingAssignment);
	}

	@Override
	public void deleteAssignment(int assignmentID) {
		Optional<Assignment> existingAssignment = assignmentRepository.findById(assignmentID);
		if (!existingAssignment.isPresent()) {
			return;
		}
		assignmentRepository.deleteById(assignmentID);
	}

	@Override
	public List<Assignment> fetchAssignments() {
		Iterable<Assignment> existingAssignments = assignmentRepository.findAll();

		List<Assignment> assignmentList = new ArrayList<>();
		existingAssignments.forEach(assignmentList::add);

		return assignmentList;
	}

	// public void enrollStudentInAssignment(int studentId, int assignmentId) {
	// User student = userRepository.findById(studentId).orElseThrow();
	// Assignment assignment =
	// assignmentRepository.findById(assignmentId).orElseThrow();
	//
	// student.getAssignments().add(assignment);
	// assignment.getStudents().add(student);
	//
	// userRepository.save(student);
	// assignmentRepository.save(assignment);
	// }
}
