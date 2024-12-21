package com.project.software.advanced.demo.model.Lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    // Custom query to find all lessons for a given course
    List<Lesson> findByCourseCourseID(int courseID);
}
