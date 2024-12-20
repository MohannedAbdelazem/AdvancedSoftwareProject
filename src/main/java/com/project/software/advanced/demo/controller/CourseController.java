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

import com.project.software.advanced.demo.model.Course.Course;
import com.project.software.advanced.demo.service.CourseService.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	private CourseService service;

	@Autowired
	public CourseController(CourseService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> courses = service.fetchCourses();
		return ResponseEntity.ok(courses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getCourseById(@PathVariable("id") int courseID) {
		Course course = service.getCourseById(courseID);
		if (course == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Course not found");
		}
		return ResponseEntity.ok("Course: " + course.toString());
	}


	@PostMapping("/instructor")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> postCourse(@RequestBody Course course) {
		if (course == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Course data is null");
		}
		Course savedCourse = service.saveCourse(course);
		if (savedCourse == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Course created: " + savedCourse.toString());
	}
}
