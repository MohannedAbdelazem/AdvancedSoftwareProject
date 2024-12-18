/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.project.software.advanced.demo.service.QuestionsService;
import java.util.List;

import com.project.software.advanced.demo.model.Questions.Questions;
/**
 *
 * @author Mohanned
 */
public interface QuestionsServiceInt {
    Questions saveQuestion(Questions question);
    List<Questions> fetchQuestionList();
    Questions updateQuestion(Questions question, int QuestionID);
    void deleteQuestion(int QuestionID);
}
