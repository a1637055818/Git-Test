package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 告诉SpringMVC这是一个处理器,可以处理请求
 * @Controller 标识那个组件是控制器
 *
 * 1.运行流程：
 *  1.客户端点击链接会发送http://localhost:8080/Spring_MVC/hello请求
 *  2.来到Tomcat服务器
 *  3.MVC的前端控制器收到所有请求
 *  4.来找请求地址和@RequestMapping标注的那个匹配。来到底使用哪个方法
 *  5.前端控制器找到了目标处理器类和目标方法，直接利用返回执行目标方法
 *  6.方法执行完成以后会有一个返回值，MVC认为这个返回值就是要去的页面地址
 *  7.拿到方法返回值以后，用视图解析器进行拼串，得到完整的页面地址
 *  8.拿到页面的值，前端控制器帮我们转发到页面
 *
 * 2.@RequestMapping：
 *  就是告诉SpringMVC这个方法用来处理什么请求
 *  这个/是可以省略的，即使省略了也是默认从当前项目开始
 *  习惯加上比较好 /hello
 *
 * 3.如果不指定配置文件位置
 *  如果不指定，也会默认去找一个文件
 *      /WEB-INF/dispatcherServlet-servlet.xml
 *  就在web应用的/WEB-INF/前端控制器名-servlet.xml
 *
 *  @RequestMapping的使用
 *
 * @author 16370
 * @create 2021-03-30 下午 3:06
 */
@Controller
public class MyFirstController {

    public static final String SUCCESS="success";

    /**
     * / 代表从当前项目下开始，处理当前项目下的hello请求
     * @return
     */
    @RequestMapping("/hello")
    public String testHelloWorld(){
        System.out.println("请求正在处理中");
        //视图解析器前后拼串
        return "success";
    }

    /**
     * RequestMapping的其他属性
     * method:限定请求方式
     *      HTPP协议中的所有请求方式
     *      GET\POST
     *      method = RequestMethod.POST
     *      不是规定的方式就报错：4xx都是客户端错误
     *      HTTP Status 405 - Request method 'GET' not supported
     * params:  规定请求参数
     *  params ={"username"}发送请求的时候必须带上
     *       一个名为username的参数，没带就会404
     * headers:规定请求头，和params一样，也能写简单的表达式
     * consumes:只接受内容类型是那种的请求,规定请求头中的content-type
     * produces:告诉浏览器返回的内容类型是什么,给响应头加上
     * Content-Type:text/html;charset=utf-8
     */
    @RequestMapping(value = "/handle02",method = RequestMethod.POST)
    public String handle02(){

        return "success";
    }

    /**
     * params ={"username"}发送请求的时候必须带上
     * 一个名为username的参数，没带就会404
     * @return
     */
    @RequestMapping(value = "/handle03",params ={"username"})
    public String handle03(){
        return "success";
    }
    //User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36
    @RequestMapping(value = "/handle04",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36"})
    public String handle04(){
        return SUCCESS;
    }
}
