/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.software.advanced.demo.model.CourseList.CourseList;
import com.project.software.advanced.demo.service.CourseListService.CourseListService;

/**
 *
 * @author Mohanned
 */
@RestController
@RequestMapping("/api")
public class CourseListController {
	@Autowired
	CourseListService courseListService;

	@GetMapping("/courseLists")
	public ResponseEntity<List<CourseList>> getCourseList() {
		List<CourseList> CourseL = courseListService.fetchCourseList();
		return ResponseEntity.ok(CourseL);
	}

	@PostMapping("/courseLists")
	public ResponseEntity<String> postCourseLists(@RequestBody CourseList cl) {
		if (cl == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Questions data is null");

		}
		CourseList savedCourseList = courseListService.saveCourseList(cl);
		if (savedCourseList == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("CourseList created");
	}

	@DeleteMapping("/deleteCourseList/{id}")
	public String deleteCourseListByID(@PathVariable("id") int courseListID) {
		courseListService.deleteCourseList(courseListID);
		return "Course Deleted successfully";
	}
}
