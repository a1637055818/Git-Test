package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义视图解析器和视图对象
 * @author 16370
 * @create 2021-04-01 下午 8:39
 */
@Controller
public class MyViewResolverController {


    @RequestMapping("/handlePlus")
    public String handlePlus(Model model){
        List<String> vName=new ArrayList<>();
        List<String> imgName=new ArrayList<>();
        vName.add("张三");
        vName.add("李四");
        imgName.add("王五");

        model.addAttribute("video",vName);
        model.addAttribute("imgs",imgName);
        return "tupian:/gaoqing";
    }
}
