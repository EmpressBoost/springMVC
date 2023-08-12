package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//controller handler命名都可以
@Controller
//左侧的小叶子图标是表示该类（组件）已经交给springIOC容器进行管理
public class Hellocontroller {

    // 访问 /  ---》实则访问的是WEB-INF/templates/index.html
    @RequestMapping("/")
    public String inddex(){
        //返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}
