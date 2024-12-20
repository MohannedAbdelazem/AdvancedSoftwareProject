package com.project.software.advanced.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.software.advanced.demo.model.Assignment.Assignment;
import com.project.software.advanced.demo.service.AssignmentService.AssignmentService;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

	private final AssignmentService assignmentService;

	@Autowired
	public AssignmentController(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@GetMapping("")
	public ResponseEntity<List<Assignment>> getAssignments() {
		List<Assignment> assignments = assignmentService.fetchAssignments();
		return ResponseEntity.ok(assignments);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAssignmentById(@PathVariable("id") int assignmentID) {
		Assignment assignment = assignmentService.getAssignmentById(assignmentID);
		if (assignment == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Course not found");
		}
		return ResponseEntity.ok(assignment);
	}

	@PostMapping("instructor")
	public ResponseEntity<?> postAssignment(@RequestBody Assignment assignment) {
		if (assignment == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Course data is null");
		}

		System.out.println(assignment.toString());
		Assignment savedAssignment = assignmentService.saveAssignment(assignment);

		if (savedAssignment == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(assignment);
	}
}
