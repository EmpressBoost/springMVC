package com.atguigu.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    @GetMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    @GetMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
}
