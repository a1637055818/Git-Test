package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 16370
 * @create 2021-04-07 下午 6:17
 */
@Controller
public class InterceptorTestController {

    @RequestMapping("/test01")
    public String test01(){
        System.out.println();
        return "success";
    }

}
