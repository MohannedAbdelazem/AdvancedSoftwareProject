package com.project.software.advanced.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.software.advanced.demo.model.Auth.AuthResponse;
import com.project.software.advanced.demo.model.Auth.RegisterRequest;
import com.project.software.advanced.demo.model.Course.Course;
import com.project.software.advanced.demo.service.AuthService.AuthService;
import com.project.software.advanced.demo.service.CourseService.CourseService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private AuthService service;

	@Autowired
	public AuthController(AuthService service) {
		this.service = service;
	}

	// @GetMapping("/register")
	// public ResponseEntity<List<Course>> register() {
	// List<Course> courses = service.fetchCourses();
	// return ResponseEntity.ok(courses);
	// }

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(service.register(request));
	}

	// @GetMapping("login")
	// public ResponseEntity<String> login(@PathVariable("id") int courseID) {
	// Course course = service.getCourseById(courseID);
	// if (course == null) {
	// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Course not
	// found");
	// }
	// return ResponseEntity.ok("Course: " + course.toString());
	// }

	// @PostMapping("/course")
	// @PreAuthorize("hasRole('ADMIN')")
	// public ResponseEntity<String> postCourse(@RequestBody Course course) {
	// if (course == null) {
	// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Course data
	// is null");
	// }
	// Course savedCourse = service.saveCourse(course);
	// if (savedCourse == null) {
	// return
	// ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
	// }
	// return ResponseEntity.status(HttpStatus.CREATED).body("Course created: " +
	// savedCourse.toString());
	// }
}
