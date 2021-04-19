package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 16370
 * @create 2021-04-01 下午 12:10
 */
@Controller
public class TestController {

    public static final String SUCCESS="success";

    @RequestMapping("/hello")
    public String testSuccess(){
        return SUCCESS;
    }

}
