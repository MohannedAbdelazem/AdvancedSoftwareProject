/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
*/

package com.project.software.advanced.demo.service.QuestionListService;

import java.util.List;

import com.project.software.advanced.demo.model.QuestionList.QuestionList;


/**
 *
 * @author Mohanned
 */
public interface QuestionListInt {
    QuestionList saveQuestionList(QuestionList questionList);
    List<QuestionList> fetchQuestionList();
    void deleteQuestionList(int QuestionID);
}
// got httpie ? 
/*




lets open the mikes lol

*/