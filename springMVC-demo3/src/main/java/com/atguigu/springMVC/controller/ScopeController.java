package com.atguigu.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    /**
     *     使用ServletAPI向request域对象共享数据
     */
    @RequestMapping("/testRequestByServletApi")
    public String testRequestByServletApi(HttpServletRequest request){
        request.setAttribute("testRequestByScope","hello ServletApi");
        return "success";
    }
    /**
     * 使用ModelAndView向request域对象共享数据
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        //向请求域共享数据
        modelAndView.addObject("testRequestByScope","hello ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 使用Model向request域对象共享数据
     */
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestByScope","hello Model");
        System.out.println(model);
        System.out.println(model.getClass().getName());
        return "success";
    }

    /**
     * 使用Map向request域对象共享数据
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestByScope","hello Map");
        System.out.println(map);
        System.out.println(map.getClass().getName());
        return "success";
    }

    /**
     * 使用ModelMap向request域对象共享数据
     */
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestByScope","hello ModelMap");
        System.out.println(modelMap);
        System.out.println(modelMap.getClass().getName());
        return "success";
    }
    //org.springframework.validation.support.BindingAwareModelMap

    /**
     * 向session域共享数据
     */
    @GetMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello session");
        return "success";
    }

    /**
     * 向application域共享数据
     */
    @GetMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello Application");
        return "success";
    }
}
