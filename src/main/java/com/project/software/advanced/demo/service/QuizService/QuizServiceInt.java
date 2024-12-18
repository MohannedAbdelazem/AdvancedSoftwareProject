
package com.project.software.advanced.demo.service.QuizService;

import java.util.List;

import com.project.software.advanced.demo.model.Quiz.Quiz;

public interface QuizServiceInt {
	Quiz saveQuiz(Quiz quiz);

	List<Quiz> fetchQuizzes();

	Quiz updateQuiz(Quiz quiz, int quizID);

	void deleteQuiz(int quizID);
}
