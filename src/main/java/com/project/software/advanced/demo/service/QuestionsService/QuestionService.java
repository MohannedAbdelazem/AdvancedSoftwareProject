/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.service.QuestionsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.Questions.Questions;
import com.project.software.advanced.demo.model.Questions.QuestionsRepository;

/**
 *
 * @author Mohanned
 */
@Service
public class QuestionService implements  QuestionsServiceInt{
    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    public Questions saveQuestion(Questions question){
        return questionsRepository.save(question);
    }
    @Override
    public List<Questions> fetchQuestionList(){
        return (List<Questions>)questionsRepository.findAll();
    }
    
    @Override
    public Questions updateQuestion(Questions question, int QuestionID){
        Questions questionDB = questionsRepository.findById(QuestionID).get();
        if(questionDB != null){
            questionDB.setCorrectAnswer(question.getCorrectAnswer());
            questionDB.setQuestion(question.getQuestion());
        }

        return questionsRepository.save(questionDB);
    }
    @Override
    public void deleteQuestion(int QuestionID){
        questionsRepository.deleteById(QuestionID);
    }
}
