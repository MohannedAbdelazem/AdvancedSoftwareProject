/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.Quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 * @author Mohanned
 */

@Entity
public class Quiz {
    @Id
    @GeneratedValue
    private int QuizID;
    private int QuestionListID;
    private int mark;
    public int getQuizID() {
        return QuizID;
    }
    public void setQuestionListID(int QuestionListID){
        this.QuestionListID = QuestionListID;
    }
    public int getQuestionListID() {
        return QuestionListID;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    public int getMark() {
        return mark;
    }
}
