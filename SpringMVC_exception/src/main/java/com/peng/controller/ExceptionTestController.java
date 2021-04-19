package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 16370
 * @create 2021-04-07 下午 9:58
 */
@Controller
public class ExceptionTestController {

    @RequestMapping("/handle01")
    public String handle01(@RequestParam("i")Integer i){
        System.out.println(10/i);
        return "success";
    }


    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username")String username){
        if (!username.equals("admin")){
            System.out.println("登陆失败");
            throw  new UserNameNotFoundException();
        }
        System.out.println("登录成功");
        return "success";
    }

    @RequestMapping(value = "/handle03",method = RequestMethod.POST)
    public String handle03(){
        return "success";
    }
    /**
     * 告诉SpringMVC这个方法专门处理这个类发生的异常
     * 1.给方法上写上一个Exception,用来接受发生的异常
     * 2.要携带异常信息不能给参数位置写Model
     * 3.返回ModelAndView
     * 4.如果有多个@ExceptionHandler都能获取，精确优先
     * 5.全局异常处理与本类同时存在，本类优先
     */
//    @ExceptionHandler(value={ArithmeticException.class})
//    public ModelAndView handleException01(Exception e){
//        System.out.println("handleException01..."+e);
//        //视图解析器拼串
//        ModelAndView modelAndView = new ModelAndView("myError");
//        modelAndView.addObject("ex", e);
//        return modelAndView;
//    }


}
