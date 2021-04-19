package com.peng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**@RequestMapping模糊匹配
 * @author 16370
 * URL地址可以写模糊的通配符
 *  ?:能替代任意一个字符
 *  * :能替代任意多个字符和一层路径
 *  **:能替代多层路径
 * @create 2021-03-30 下午 7:17
 */
@Controller
public class RequestMappingTest {

    public static final String SUCCESS="success";

    @RequestMapping("/antTest01")
    public String antTest01(){
        System.out.println("01");
        return SUCCESS;
    }

    /**
     * ?匹配一个字符,0个多个都不行;
     *  模糊和精确匹配的情况下，精确优先
     * @return
     */
    @RequestMapping("/antTest0?")
    public String antTest02(){
        System.out.println("02");
        return SUCCESS;
    }

    /**
     * *匹配任意多个字符或者一层路径
     * @return
     */
    @RequestMapping("/antTest0*")
    public String antTest03(){
        System.out.println("03");
        return SUCCESS;
    }

    /**
     * 路径上可以有占位符
     * 占位符语法就是可以在任意路径的地方写一个{变量名}
     * 路径上的占位符只能占一层路径
     * @return
     */
    @RequestMapping("/test/{id}")
    public String pathVariableTest(@PathVariable("id")String id){
        System.out.println(id);
        return SUCCESS;
    }


}
