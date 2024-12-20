/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.software.advanced.demo.model.Quiz.Quiz;
import com.project.software.advanced.demo.service.QuizService.QuizService;

/**
 *
 * @author Mohanned
 */
@RestController
@RequestMapping("api/quiz")
public class QuizController {
    private QuizService service;

	@Autowired
	public QuizController(QuizService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<List<Quiz>> getQuizs() {
		List<Quiz> Quizs = service.fetchQuizzes();
		return ResponseEntity.ok(Quizs);
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getQuizById(@PathVariable("id") int QuizID) {
		Quiz Quiz = service.getQuizById(QuizID);
		if (Quiz == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Quiz not found");
		}
		return ResponseEntity.ok("Quiz: " + Quiz.toString());
	}

	@PostMapping("/instructor")
	public ResponseEntity<String> postQuiz(@RequestBody Quiz Quiz) {
		if (Quiz == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Quiz data is null");
		}
		Quiz savedQuiz = service.saveQuiz(Quiz);
		if (savedQuiz == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Quiz created: " + savedQuiz.toString());
	}
}
