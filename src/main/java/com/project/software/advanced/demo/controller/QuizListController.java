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

import com.project.software.advanced.demo.model.QuizList.QuizList;
import com.project.software.advanced.demo.service.QuizListService.QuizListService;

/**
 *
 * @author Mohanned
 */
public class QuizListController {
    @Autowired QuizListService quizListService;
    @GetMapping("/QuizLists")
    public ResponseEntity<List<QuizList>> getQuizList(){
        List<QuizList> CourseL = quizListService.fetchQuizList();
        return ResponseEntity.ok(CourseL);
    }
    @PostMapping("/QuizLists")
    public ResponseEntity<String> postQuizLists(@RequestBody QuizList cl){
        if(cl == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Questions data is null");

        }
        QuizList savedQuizList = quizListService.saveQuizList(cl);
        if (savedQuizList == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
        return ResponseEntity.status(HttpStatus.CREATED).body("QuizList created");
    }

    @DeleteMapping("/deleteQuizList/{id}")
    public String deleteQuizListByID(@PathVariable("id")int  QuizListID){
        quizListService.deleteQuizList(QuizListID);
        return "Course Deleted successfully";
    }
}
