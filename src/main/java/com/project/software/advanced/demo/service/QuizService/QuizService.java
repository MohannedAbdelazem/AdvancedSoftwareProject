
package com.project.software.advanced.demo.service.QuizService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.Quiz.Quiz;
import com.project.software.advanced.demo.model.Quiz.QuizRepository;

@Service
public class QuizService implements QuizServiceInt {
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz saveQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	};

	@Override
	public Quiz updateQuiz(Quiz quiz, int quizID) {
		Optional<Quiz> existingQuizOptional = quizRepository.findById(quizID);
		if (!existingQuizOptional.isPresent()) {
			return null;
		}
		Quiz existingQuiz = existingQuizOptional.get();
		existingQuiz.setQuizName(quiz.getQuizName());
		existingQuiz.setQuestionListID(quiz.getQuestionListID());
		existingQuiz.setMark(quiz.getMark());
		return quizRepository.save(existingQuiz);
	}

	@Override
	public void deleteQuiz(int quizID) {
		Optional<Quiz> existingQuiz = quizRepository.findById(quizID);
		if (!existingQuiz.isPresent()) {
			return;
		}
		quizRepository.deleteById(quizID);
	}
	@Override
	public Quiz getQuizById(int QuizID) {
		Optional<Quiz> quiz = quizRepository.findById(QuizID);
		if (quiz.isPresent()) {
			return quiz.get();
		}
		return null;
	}
	@Override
	public List<Quiz> fetchQuizzes() {
		Iterable<Quiz> existingQuizs = quizRepository.findAll();

		List<Quiz> quizList = new ArrayList<>();
		existingQuizs.forEach(quizList::add);

		return quizList;
	}
}
