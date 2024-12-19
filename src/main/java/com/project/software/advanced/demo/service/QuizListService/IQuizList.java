
package com.project.software.advanced.demo.service.QuizListService;
import java.util.List;

import com.project.software.advanced.demo.model.QuizList.QuizList;

public interface IQuizList{
    QuizList saveQuizList(QuizList quizList);
    List<QuizList> fetchQuizList();
    // QuizList updateQuizList(QuizList quizList, int quizListID, int questionID);
    void deleteQuizList(int quizListID);
}
