/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package com.project.software.advanced.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mohanned
 */
@Controller
public class WebController {
    @RequestMapping("/home")
    public String htmlStuff(){
        return "forward:/index.html";
    }
    @RequestMapping("/signup")
    public String htmlFunc(){
        return "forward:/signup.html";
    }
}
// look chat 
// i need httpie to test from terminal
// and give terminal access
// sup?
//aight?
//done