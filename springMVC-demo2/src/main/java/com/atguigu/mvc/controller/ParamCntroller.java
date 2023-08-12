package com.atguigu.mvc.controller;

import com.atguigu.mvc.controller.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamCntroller {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username+" password="+password);
        return "success";
    }

    @RequestMapping("/testParam")
    /*public String testParam(String username,String password,String hobby){
        System.out.println("username="+username+" password="+password+" hobby="+hobby);*/
    //多请求参数种出现多个同名请求参数，可以在控制器方法的形参位置设置字符串类型或者字符串数组接收此参数
    //若使用字符串类型的形参，最终结果为每个请求参数的每一个值用，隔开
    public String testParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "hehe") String username,
            String password,
            String[] hobby,
//            @RequestHeader(value = "Host",required = true,defaultValue = "haha") String host){
            @RequestHeader(value = "sayHaha",required = true,defaultValue = "haha") String host,
            @CookieValue(value = "JSESSIONID")String JSESSIONID){
        System.out.println("username="+username+" password="+password+" hobby="+ Arrays.toString(hobby));
        System.out.println("username="+host);
        System.out.println("JSESSIONID="+JSESSIONID);
        return "success";
    }

    /**
     * request获取的参数有中文乱码问题思考该如何解决：
     *     1.DispatcherServlet里面必定来获取了本次请求参数，如果我当前已经获取了请求参数，再来设置它的编码没有用了
     *     2.你的DispatcherServlet获取请求参数在前，还是在这儿你写了一个request对象设置编码在前，
     *     应该是DispatcherServlet获取请求参数在前，那在这再设这个请求的这个编码没有用了
     *     3.既然DispatcherServlet里边他是不是已经获取了请求参数，而我们现在是不是要在他获取请求参数之前是不是来设置编码
     *     有什么内容是要比咱们的Servlet执行更早的呢？服务器启动时候。因为我们在注册Servlet的时候，设了一个load-on-startup，
     *     这个是不是应该是在服务器启动时就加载的
     *     4.那可能它在里面已经获取了一些小的参数，是不是要找到一种技术，或者说找到咱们服务器中的一个组件，
     *     它的一个执行时间是要比咱们的Servlet执行时间更早一些的
     *     5.那大家想想咱们服务器中学过三大组件，监听器，过滤器，Servlet 谁的加载时间 ServletContextListener的加载时间最早
     *     （时间先后 Servlet监听器——>过滤器filter——>Servlet）
     *     6.ServletContext监听器作用是来听Servlet的创建和销毁，这两方法都是只执行一次，
     *     6.过滤器呢，是不是只要咱们来设置的过滤路径，只要当前所访问的请求地址满足过滤路径，是不是都会被过滤器顶过滤
     *     经过分析应该用过滤器，通过过滤器是不是来设置我当前的编码，每一次发送请求是不是都要先经过过离器的处理，处理完之后再交给DispatcherServlet处理
     *     7.当然这个过滤器肯定不用写就行了，因为springMVC已经提供好了，既然已经提供好了，要想让过滤器有作用，
     *     就需要在web.xml进行注册,也就是配置
    */
    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
