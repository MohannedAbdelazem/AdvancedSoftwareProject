/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.software.advanced.demo.model.QuizList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 *
 * @author Mohanned
 */
@Entity
public class QuizList {
    @Id
    @GeneratedValue
    private int QuizListID;
    private int QuizID;

    public int getQuizList(){
        return QuizListID;
    }
    public int getQuizID(){
        return QuizID;
    }
    public void setQuizID(int QuizID){
        this.QuizID = QuizID;
    }
}
