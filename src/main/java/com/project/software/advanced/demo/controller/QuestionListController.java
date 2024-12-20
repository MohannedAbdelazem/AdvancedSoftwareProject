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

import com.project.software.advanced.demo.model.QuestionList.QuestionList;
import com.project.software.advanced.demo.service.QuestionListService.QuestionListService;

/**
 *
 * @author Mohanned
 */

public class QuestionListController {
    @Autowired QuestionListService questionListService;
    @GetMapping("/QuestionLists")
    public ResponseEntity<List<QuestionList>> getQuestionList(){
        List<QuestionList> CourseL = questionListService.fetchQuestionList();
        return ResponseEntity.ok(CourseL);
    }
    @PostMapping("/QuestionLists")
    public ResponseEntity<String> postQuestionLists(@RequestBody QuestionList cl){
        if(cl == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Questions data is null");

        }
        QuestionList savedQuestionList = questionListService.saveQuestionList(cl);
        if (savedQuestionList == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
        return ResponseEntity.status(HttpStatus.CREATED).body("QuestionList created");
    }

    @DeleteMapping("/deleteQuestionList/{id}")
    public String deleteQuestionListByID(@PathVariable("id")int  QuestionListID){
        questionListService.deleteQuestionList(QuestionListID);
        return "Course Deleted successfully";
    }
}
