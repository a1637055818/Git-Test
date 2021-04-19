package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 16370
 * @create 2021-04-01 下午 5:27
 */
@Controller
public class TestController {
    public static final String SUCCESS="success";


//    @RequestMapping("/toLoginPage")
//    public String testLogin(){
//        return "login";
//    }

    @RequestMapping("/hello")
    public String testSuccess(){
        return SUCCESS;
    }

    /**
     *forward:转发到一个页面
     * /hello 转发到当前项目下的hello;
     * forward:前缀的转发，不会由配置的视图解析器拼串
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(){
        return "forward:/hello";
    }

    @RequestMapping("/handle02")
    public String handle02(){
        return "forward:/handle01";
    }

    /**
     * 重定向到hello.jsp
     *
     * 转发 forward：转发的路径
     * 重定向 redirect：重定向的路径
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03(){
        return "redirect:/hello";
    }
}
