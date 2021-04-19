package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 16370
 * @create 2021-04-01 下午 9:51
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String testHandle(){
        return "success";
    }
}
