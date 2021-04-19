package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 16370
 * @create 2021-04-07 下午 2:32
 */
@Controller
public class FileUpLoadController {

    /**
     * 测试多文件上传
     * @param username
     * @param file
     * @param model
     * @return
     */
    @RequestMapping("/uploads")
    public String uploads(@RequestParam(value = "username",required = false)String username,
                         @RequestParam("headerimg") MultipartFile[] file
            ,Model model){

        System.out.println("上传的文件信息");

        for (MultipartFile m:file){
                if (!m.isEmpty()){
                    //文件保存
                    try {
                        m.transferTo(new File("F:\\fileupload\\"+m.getOriginalFilename()));
                        model.addAttribute("msg", "文件上传成功！");
                    } catch (Exception e) {
                        model.addAttribute("msg", "文件上传失败！"+e.getMessage());
                    }
                }
        }
        return "forward:/index.jsp";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username",required = false)String username,
            @RequestParam("headerimg") MultipartFile file
            ,Model model){

        System.out.println("上传的文件信息");
        System.out.println("文件的大小"+file.getSize());
        System.out.println("文件项的name"+file.getName());
        System.out.println("文件的名字"+file.getOriginalFilename());

        //文件保存
        try {
            file.transferTo(new File("F:\\fileupload\\"+file.getOriginalFilename()));
            model.addAttribute("msg", "文件上传成功！");
        } catch (Exception e) {
            model.addAttribute("msg", "文件上传失败！"+e.getMessage());

        }

        return "forward:/index.jsp";
    }
}
