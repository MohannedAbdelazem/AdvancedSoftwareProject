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

import com.project.software.advanced.demo.Util.AuthUsername;
import com.project.software.advanced.demo.model.Course.Course;
import com.project.software.advanced.demo.model.User.User;
import com.project.software.advanced.demo.service.CourseService.CourseService;
import com.project.software.advanced.demo.service.UserService.UserService;


@RestController
@RequestMapping("/api/course")
public class CourseController {
	private CourseService courseService;
	private UserService userService;

	@Autowired
	public CourseController(CourseService service, UserService userService) {
		this.courseService = service;
		this.userService = userService;
	}

	@GetMapping("")
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> courses = courseService.fetchCourses();
		return ResponseEntity.ok(courses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getCourseById(@PathVariable("id") int courseID) {
		Course course = courseService.getCourseById(courseID);
		if (course == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Course not found");
		}
		return ResponseEntity.ok("Course: " + course.toString());
	}

	@PostMapping("/{id}/enroll")
	public ResponseEntity<?> enrollCourse(@PathVariable("id") int courseID) {
		Course course = courseService.getCourseById(courseID);
		if (course == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Course not found");
		}

		String username = AuthUsername.getAuthUsername();

		if (username == null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error: Wrong Authentication");
		}

		User user = userService.getUserByEmail(username);

		courseService.enrollStudentInCourse(user.getUserID(), courseID);

		return ResponseEntity.ok("Course Registered");

	}

	@PostMapping("/instructor")
	public ResponseEntity<?> postCourse(@RequestBody Course course) {
		if (course == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Course data is null");
		}
		System.out.println(course.toString());
		Course savedCourse = courseService.saveCourse(course);
		if (savedCourse == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(course);
	}
}
