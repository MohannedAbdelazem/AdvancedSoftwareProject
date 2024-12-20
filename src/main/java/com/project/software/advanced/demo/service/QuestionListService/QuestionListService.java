/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.service.QuestionListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.QuestionList.QuestionList;
import com.project.software.advanced.demo.model.QuestionList.QuestionListRepository;


/**
 *
 * @author Mohanned
 */

@Service
public class QuestionListService implements QuestionListInt{
@Autowired
    private QuestionListRepository questionListRepository;

    @Override
    public QuestionList saveQuestionList(QuestionList questionList){
        return questionListRepository.save(questionList);
    }
    @Override
    public List<QuestionList> fetchQuestionList(){
        return (List<QuestionList>)questionListRepository.findAll();
    }
    
    @Override
    public void deleteQuestionList(int QuestionID){
        while(questionListRepository.findById(QuestionID) != null){
            questionListRepository.deleteById(QuestionID);
        }
    }
}
