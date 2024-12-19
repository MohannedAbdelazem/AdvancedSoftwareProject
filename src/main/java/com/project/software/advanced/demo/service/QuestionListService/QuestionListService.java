package com.project.software.advanced.demo.service.QuestionListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.QuestionList.QuestionList;
import com.project.software.advanced.demo.model.QuestionList.QuestionListRepository;

@Service
public class QuestionListService implements IQuestionList {

    @Autowired
    private QuestionListRepository questionListRepository;

    @Override
    public QuestionList saveQuestionList(QuestionList questionList) {
        // Save the new question list to the database
        return questionListRepository.save(questionList);
    }

    @Override
    public List<QuestionList> fetchQuestionList() {
        // Return all question lists from the database
        return (List<QuestionList>) questionListRepository.findAll();
    }

    // @Override
    // public QuestionList updateQuestionList(QuestionList questionList, int questionListID, int questionID) {
    //     // Fetch the QuestionList entity matching both IDs
    //     QuestionList existingQuestionList = questionListRepository.findByQuestionListIDAndQuestionID(questionListID, questionID)
    //         .orElseThrow(() -> new RuntimeException("QuestionList not found with questionListID: "
    //             + questionListID + " and questionID: " + questionID));

    //     // Update the fields of the existing question list
    //     existingQuestionList.setQuestionID(questionList.getQuestionID()); // Example field update
    //     // Add more fields to update as needed

    //     // Save the updated entity
    //     return questionListRepository.save(existingQuestionList);
    // }
    @Override
    public void deleteQuestionList(int questionListID) {
        if (questionListRepository.existsById(questionListID)) {
            questionListRepository.deleteById(questionListID);
        }
    }

}
