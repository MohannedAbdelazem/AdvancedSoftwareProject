/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.service.QuizListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.software.advanced.demo.model.QuizList.QuizList;
import com.project.software.advanced.demo.model.QuizList.QuizListRepository;

/**
 *
 * @author Mohanned
 */
@Service
public class QuizListService implements QuizListInt{
    @Autowired QuizListRepository quizListRepository;
    
    @Override
    public QuizList saveQuizList(QuizList quizList){
        return quizListRepository.save(quizList);
    }

    @Override
    public List<QuizList> fetchQuizList(){
        return (List<QuizList>) quizListRepository.findAll();
    }

    @Override
    public void deleteQuizList(int QuizListID){
        while(quizListRepository.findById(QuizListID) != null){
            quizListRepository.deleteById(QuizListID);
        }
    }
}