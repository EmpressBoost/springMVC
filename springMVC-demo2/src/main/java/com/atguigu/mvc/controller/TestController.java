package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "test_param";
    }

/*    @RequestMapping("/testparam")
    public String testparam(){
        return "test_param";
    }*/


}
