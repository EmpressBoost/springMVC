package com.atguigu.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/test_view")
    public String testView(){
        return "test_view";
    }
}
