/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-defaimport org.springframework.data.jpa.repository.query.QueryEnhancer;

ult.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.service.CourseListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.CourseList.CourseList;
import com.project.software.advanced.demo.model.CourseList.CourseListRepository;

/**
 *
 * @author Mohanned
 */

@Service
public class CourseListService implements CourseListInt{
    @Autowired
    private CourseListRepository courseListRepository;

    @Override
    public CourseList saveCourseList(CourseList courseList){
        return courseListRepository.save(courseList);
    }
    @Override
    public List<CourseList> fetchCourseList(){
        return (List<CourseList>) courseListRepository.findAll();
    }
    // @Override
    // public CourseList updateCourseList(CourseList courseList, int courseListID, int courseID) {
    // // Fetch the CourseList entity matching both IDs
    //     CourseList existingCourseList = courseListRepository.findByCourseListIDAndCourseID(courseListID, courseID)
    //         .orElseThrow(() -> new RuntimeException("CourseList not found with courseListID: " 
    //             + courseListID + " and courseID: " + courseID));
    
    //     // Update the fields of the existing course list
    //     existingCourseList.setCourseId(courseList.getCourseId()); // Example field
    //     // Add more fields to update as needed
    //     // Save the updated entity
    //     return courseListRepository.save(existingCourseList);
    // }
    @Override
    public void deleteCourseList(CourseList courseList){
        courseListRepository.delete(courseList);
    }
    
}
