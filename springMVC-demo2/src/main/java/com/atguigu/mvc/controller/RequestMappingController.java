package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping(
            value = {"/testRequestMapping","/test"},
            method = {RequestMethod.GET,RequestMethod.POST}
    )
    public String success(){
        return "success";
    }


    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    @RequestMapping(
            value = {"/testParamsAndHeader"},
            params = {"username","password!=123456"},
            headers = {"Host=localhost:8081"}
    )
    public String testParamsAndHeader(){
        return "success";
    }


    @RequestMapping(value = "/a?a/testAnt1")
    public String testAnt1(){
        return "success";
    }

    @RequestMapping(value = "/a*a/testAnt2")
    public String testAnt2(){
        return "success";
    }

    @RequestMapping(value = "/a**a/testAnt3")
    public String testAnt3(){
        return "success";
    }
    @RequestMapping(value = "/**/testAnt4")
    public String testAnt4(){
        return "success";
    }
    @RequestMapping(value = "/testPath/{id}/{admin}")
    public String testPath(@PathVariable("id") Integer id,
                           @PathVariable("admin") String admin){
        System.out.println("id:"+id+" admin:"+admin);
        return "success";
    }

}
