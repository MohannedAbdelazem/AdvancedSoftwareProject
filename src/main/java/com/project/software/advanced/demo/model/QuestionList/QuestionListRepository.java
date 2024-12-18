/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.project.software.advanced.demo.model.QuestionList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohanned
 */
@Repository
public interface QuestionListRepository extends CrudRepository<QuestionList, Integer> {

}
