/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.project.software.advanced.demo.service.CourseListService;

import java.util.List;

import com.project.software.advanced.demo.model.CourseList.CourseList;

/**
 *
 * @author Mohanned
 */
public interface CourseListInt {
    CourseList saveCourseList(CourseList courseList);
    List<CourseList> fetchCourseList();
    void deleteCourseList(int courseListID);
}
