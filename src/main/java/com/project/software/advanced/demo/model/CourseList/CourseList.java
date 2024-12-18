/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.CourseList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 * @author Mohanned
 */
@Entity
public class CourseList {
    @Id
    @GeneratedValue
    private int courseListID;
    private int courseId;
    public int getCourseListID() {
        return courseListID;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
