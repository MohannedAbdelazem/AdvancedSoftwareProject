package com.project.software.advanced.demo.service.AssignmentStudentService;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.Assignment.Assignment;
import com.project.software.advanced.demo.model.Assignment.AssignmentRepository;
import com.project.software.advanced.demo.model.AssignmentsStudent.AssignmentStudent;
import com.project.software.advanced.demo.model.AssignmentsStudent.AssignmentStudentRepository;
import com.project.software.advanced.demo.model.User.UserRepository;

import com.project.software.advanced.demo.model.User.*;

@Service
public class AssignmentStudentService implements AssignmentStudentServiceInt {
	@Autowired
	private UserRepository studentRepository;

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	private AssignmentStudentRepository assignmentStudentRepository;

	@Override
	public void assignStudentToAssignment(int studentId, int assignmentId, Date dueDate) {
		User student = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found"));
		Assignment assignment = assignmentRepository.findById(assignmentId)
				.orElseThrow(() -> new RuntimeException("Assignment not found"));

		AssignmentStudent assignmentStudent = new AssignmentStudent(student, assignment);
		assignmentStudentRepository.save(assignmentStudent);
	}

	@Override
	public void submitAssignment(int studentId, int assignmentId) {
		Optional<AssignmentStudent> assignmentStudentOpt = assignmentStudentRepository.findAll()
				.stream()
				.filter(as -> as.getStudent().getUserID() == studentId && as.getAssignment().getAssignmentID() == assignmentId)
				.findFirst();

		if (assignmentStudentOpt.isPresent()) {
			AssignmentStudent assignmentStudent = assignmentStudentOpt.get();
			assignmentStudent.setSubmitted(true);
			assignmentStudentRepository.save(assignmentStudent);
		} else {
			throw new RuntimeException("Assignment not found for the student");
		}
	}

	@Override
	public void gradeAssignment(int studentId, int assignmentId, double grade) {
		Optional<AssignmentStudent> assignmentStudentOpt = assignmentStudentRepository.findAll()
				.stream()
				.filter(as -> as.getStudent().getUserID() == studentId && as.getAssignment().getAssignmentID() == assignmentId)
				.findFirst();

		if (assignmentStudentOpt.isPresent()) {
			AssignmentStudent assignmentStudent = assignmentStudentOpt.get();
			assignmentStudent.setGrade(grade);
			assignmentStudentRepository.save(assignmentStudent);
		} else {
			throw new RuntimeException("Assignment not found for the student");
		}
	}
}
