package com.peng.controller;

import com.peng.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author 16370
 * @create 2021-03-30 下午 10:24
 */
@Controller
public class RequestParamController {

    public static final String SUCCESS="success";

    /**
     * SpringMVC可以直接在参数上写原生API
     * HttpServletRequest
     * HttpSession
     */
    @RequestMapping("/API")
    public String testAPI(HttpSession session, HttpServletRequest request){
        request.setAttribute("requestparam", "我是请求域中的");
        session.setAttribute("sessionparam", "我是会话域中的");
        return SUCCESS;
    }


    /**
     * 如果请求的参数是一个pojo
     * SpringMVC会自动为这个pojo进行赋值
     * 1.将pojo中的每一个属性，从request参数中尝试获取出来，并封装
     * 2.还可以级联封装
     * 3.请求参数的参数名和对象中的属性名一一对应即可
     *
     *  提交的数据可能有乱码
     *  请求乱码：
     *      get请求：改server.xml
     *      post请求：
     *          在第一次获取请求参数之前设置
     *          request.setCharacterEnconding("utf-8");
     *          SpringMVC有这个filter
     *  响应乱码：
     *      response.setContextType("text/html;charset=utf-8");
     * @param book
     * @return
     */
    @RequestMapping("/books")
    public String addBook(Book book){
        System.out.println("要保存的图书："+book);
        return SUCCESS;
    }

    /**
     * SpringMVC如何获取请求带来的各种信息
     *
     * @RequestParam: 获取请求参数:参数默认是必须带的
     *  默认方式获取请求参数：
     *      直接给方法入参上写一个和请求参数相同的变量，
     *      这个变量就来接受请求参数的值
     *      带参：有值，没带：null
     *      @RequestParam("username") String username
     *      username=request.getParameter("username");
     *  value:指定要获取的参数的key
     *  required:这个参数是否必须的
     *  defaultValue:默认值。没带默认是null
     *
     * @RequestParam("username")  /book?username=xxx
     * @PathVariable("username") /book/{username}
     *
     * @RequestHeader:获取请求头中的某个key的值
     * 如果请求头中没有这个值，就会报错
     *
     * @CookieValue:获取某个Cookie的值
     */
    @RequestMapping("/handle01")
    public String handle(@RequestParam(value = "username",required = false,defaultValue = "你没带参数")
            String username, @RequestHeader(value = "Cookie",required = false,defaultValue = "他也没带")
            String cookie, @CookieValue(value = "Idea-16047a7",required = false,defaultValue = "他叒没带")
            String cookieValue){
        System.out.println(username);
        System.out.println(cookie);
        System.out.println(cookieValue);
        return SUCCESS;
    }
}
