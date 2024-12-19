package com.project.software.advanced.demo.service.QuizListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.QuizList.QuizList;
import com.project.software.advanced.demo.model.QuizList.QuizListRepository;

@Service
public class QuizListService implements IQuizList{

    @Autowired
    private QuizListRepository quizListRepository;

    @Override
    // Save a new QuizList or update an existing one
    public QuizList saveQuizList(QuizList quizList) {
        return quizListRepository.save(quizList);
    }

    @Override
    // Fetch all QuizLists
    public List<QuizList> fetchQuizList() {
        // We use findAll() since CrudRepository returns Iterable, convert it to List
        return (List<QuizList>) quizListRepository.findAll();
    }
    // @Override
    // // Update a QuizList, given QuizListID and QuizID
    // public QuizList updateQuizList(QuizList quizList, int quizListID, int quizID) {
    //     // // Fetch the existing QuizList by matching both IDs
    //     Qui/zList existingQuizList = quizListRepository.findByQuizListIDAndQuizID(quizListID, quizID)
    //     //     .filter(quiz -> quiz.getQuizID() == quizID)
    //     //     .orElseThrow(() -> new RuntimeException("QuizList not found with quizListID: " 
    //     //         + quizListID + " and quizID: " + quizID));

    //     // Update the QuizList fields
    //     // existingQuizList.setQuizID(quizList.getQuizID());  // Set new QuizID

    //     // Save and return the updated QuizList
    //     return quizListRepository.save(existingQuizList);
    // }
    @Override
    // Delete a QuizList by QuizListID
    public void deleteQuizList(int quizListID) {
        if (quizListRepository.existsById(quizListID)) {
            quizListRepository.deleteById(quizListID);
        } else {
            throw new RuntimeException("QuizList not found with quizListID: " + quizListID);
        }
    }
}