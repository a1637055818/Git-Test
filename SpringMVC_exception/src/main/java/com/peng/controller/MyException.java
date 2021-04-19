package com.peng.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 集中处理异常
 * 1.集中处理所有的异常的类加入到ioc容器中
 * 2.@ControllerAdvice专门处理异常的类
 * @author 16370
 * @create 2021-04-07 下午 10:39
 */
@ControllerAdvice
public class MyException {

    @ExceptionHandler(value={Exception.class})
    public ModelAndView handleException02(Exception e){
        System.out.println("全局的handleException02..."+e);
        //视图解析器拼串
        ModelAndView modelAndView = new ModelAndView("myError");
        modelAndView.addObject("ex", e);
        return modelAndView;
    }
}
