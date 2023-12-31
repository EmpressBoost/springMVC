package com.atguigu.springMVC.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    private String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
