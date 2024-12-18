/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.QuestionList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 * @author Mohanned
 */
@Entity
public class QuestionList {
    @Id
    @GeneratedValue
    private int QuestionListID;
    private int questionID;

    public int getQuestionListID() {
        return QuestionListID;
    }
    public void setQuestionID(int questionID){
        this.questionID = questionID;
    }
    public int getQuestionID(){
        return this.questionID;
    }
}
