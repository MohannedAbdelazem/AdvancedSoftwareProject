
package com.project.software.advanced.demo.service.CourseService;

import java.util.List;

import com.project.software.advanced.demo.model.Course.Course;

public interface CourseServiceInt {

	Course getCourseById(int courseID);

	Course saveCourse(Course course);

	List<Course> fetchCourses();

	Course updateCourse(Course course, int courseID);

	void deleteCourse(int courseID);

	void enrollStudentInCourse(int studentID, int courseID);
}
