
package com.project.software.advanced.demo.service.QuestionListService;
import java.util.List;

import com.project.software.advanced.demo.model.QuestionList.QuestionList;

public interface IQuestionList{
    QuestionList saveQuestionList(QuestionList questionList);
    List<QuestionList> fetchQuestionList();
    // QuestionList updateQuestionList(QuestionList questionList, int questionListID, int questionID);
    void deleteQuestionList(int questionListID);
}
