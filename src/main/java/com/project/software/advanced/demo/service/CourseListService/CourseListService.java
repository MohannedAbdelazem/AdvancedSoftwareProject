/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
@Autowired CourseListRepository courseListRepository;
    
    @Override
    public CourseList saveCourseList(CourseList courseList){
        return courseListRepository.save(courseList);
    }

    @Override
    public List<CourseList> fetchCourseList(){
        return (List<CourseList>) courseListRepository.findAll();
    }

    @Override
    public void deleteCourseList(int CourseListID){
        while(courseListRepository.findById(CourseListID) != null){
            courseListRepository.deleteById(CourseListID);
        }
    }
}
