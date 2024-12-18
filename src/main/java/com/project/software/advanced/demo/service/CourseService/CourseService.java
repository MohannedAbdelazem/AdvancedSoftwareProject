
package com.project.software.advanced.demo.service.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.Course.Course;
import com.project.software.advanced.demo.model.Course.CourseRepository;

@Service
public class CourseService implements CourseServiceInt {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course getCourseById(int courseID) {
		Optional<Course> course = courseRepository.findById(courseID);
		if (course.isPresent()) {
			return course.get();
		}
		return null;
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	};

	@Override
	public Course updateCourse(Course course, int courseID) {
		Optional<Course> existingCourseOptional = courseRepository.findById(courseID);
		if (!existingCourseOptional.isPresent()) {
			return null;
		}
		Course existingCourse = existingCourseOptional.get();
		existingCourse.setCourseName(course.getCourseName());
		existingCourse.setQuizListID(course.getQuizListID());
		existingCourse.setCourseInstructorID(course.getCourseInstructorID());
		return courseRepository.save(existingCourse);
	}

	@Override
	public void deleteCourse(int courseID) {
		Optional<Course> existingCourse = courseRepository.findById(courseID);
		if (!existingCourse.isPresent()) {
			return;
		}
		courseRepository.deleteById(courseID);
	}

	@Override
	public List<Course> fetchCourses() {
		Iterable<Course> existingCourses = courseRepository.findAll();

		List<Course> courseList = new ArrayList<>();
		existingCourses.forEach(courseList::add);

		return courseList;
	}
}
