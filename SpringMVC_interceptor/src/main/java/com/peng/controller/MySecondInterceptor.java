package com.peng.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.实现HandlerInterceptor接口
 * 2.在SpringMVC配置文件中注册这个拦截器的工作
 *      配置这个拦截器来拦截哪些请求的目标方法
 * @author 16370
 * @create 2021-04-07 下午 6:20
 */
public class MySecondInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前运行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MySecondInterceptor--->preHandle");
        //返回false就是不放行
        return true;
    }

    /**
     * 目标方法执行之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MySecondInterceptor--->postHandle");
    }

    /**
     * 只要放行就一定会执行
     * 来到页面之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MySecondInterceptor--->afterCompletion");
    }
}
