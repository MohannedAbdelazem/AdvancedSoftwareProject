/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.software.advanced.demo.model.Questions.Questions;
import com.project.software.advanced.demo.service.QuestionsService.QuestionService;

/**
 *
 * @author Mohanned
 */
public class QuestionsController {
private QuestionService service;

	@Autowired
	public QuestionsController(QuestionService service) {
		this.service = service;
	}

	@GetMapping("/Questions")
	public ResponseEntity<List<Questions>> getQuestionS() {
		List<Questions> questionS = service.fetchQuestionList();
		return ResponseEntity.ok(questionS);
	}

	@GetMapping("/Questions/{id}")
	public ResponseEntity<String> getQuestionsById(@PathVariable("id") int QuestionsID) {
		Questions questions = service.getQuestionById(QuestionsID);
		if (questions == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Questions not found");
		}
		return ResponseEntity.ok("Questions: " + questions.toString());
	}

	@PostMapping("/Questions")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> postQuestions(@RequestBody Questions questions) {
		if (questions == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Questions data is null");
		}
		Questions savedQuestions = service.saveQuestion(questions);
		if (savedQuestions == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Questions created: " + savedQuestions.toString());
	}
}
