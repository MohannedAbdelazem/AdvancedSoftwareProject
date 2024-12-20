/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.project.software.advanced.demo.service.QuizListService;

import java.util.List;

import com.project.software.advanced.demo.model.QuizList.QuizList;

/**
 *
 * @author Mohanned
 */
public interface QuizListInt {
    QuizList saveQuizList(QuizList quizList);
    List<QuizList> fetchQuizList();
    void deleteQuizList(int QuizID);
}
