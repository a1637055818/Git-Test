package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 16370
 * @create 2021-03-30 下午 8:12
 */
@Controller
public class BookController {

    public static final String SUCCESS="success";

    /**
     * 处理查询图书请求
     * @param id
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String getBook(@PathVariable("bid")Integer id){
        System.out.println("查询到了"+id+"号图书");
        return SUCCESS;
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook(){
        System.out.println("添加图书成功");
        return SUCCESS;
    }

    @RequestMapping(value = "/toSuccess")
    public String toSuccess(){
        return SUCCESS;
    }

    /**
     * 图书删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid")Integer id){
        System.out.println("删除了"+id+"号图书");
//        return "redirect:/toSuccess";
        return SUCCESS;
    }

    /**
     * 图书更新
     * @param id
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid")Integer id){
        System.out.println("更新了"+id+"号图书");
//        return "redirect:/toSuccess";
        return SUCCESS;
    }


}
