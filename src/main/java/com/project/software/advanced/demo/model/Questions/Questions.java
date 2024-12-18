/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.Questions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 * @author Mohanned
 */

@Entity
public class Questions {
    @Id
    @GeneratedValue
    private int questionID;
    private String question;
    private String correctAnswer;

    public int getQuestionID(){
        return questionID;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getQuestion(){
        return this.question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
}
