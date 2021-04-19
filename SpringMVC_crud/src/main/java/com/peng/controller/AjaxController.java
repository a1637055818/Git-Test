package com.peng.controller;

import com.peng.dao.EmployeeDao;
import com.peng.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author 16370
 * @create 2021-04-03 上午 10:02
 */
@Controller
public class AjaxController {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * 将返回的数据放在响应体中
     * @return
     */
    @ResponseBody
    @RequestMapping("/test03")
    public String test03(){
        return "success";
    }

    /**
     * 如果参数位置写HttpEntity<String> body
     * 比@RequestBody更强，可以拿到请求头
     * @param body
     * @return
     */
    @RequestMapping("/test02")
    public String test02(HttpEntity<String> body){
        System.out.println(body);
        return "success";
    }


    @RequestMapping("/test01")
    public String test01(@RequestBody String body){
        System.out.println("请求体"+body);
        return "success";
    }

    /**
     * @ResponseBody:可以把对象转为json数据，返回给浏览器
     * @RequestBody:接收json数据,封装为对象
     * 请求体：获取一个请求的请求体
     * @return
     */
//    @RequestBody
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody Employee employee){
        System.out.println("请求体："+employee);
        return "success";
    }

    /**
     * @ResponseBody:返回json数据
     * 将返回的数据放在响应体中;
     * 如果是对象，jackson包自动将对象转为json
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllAjax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> employees = employeeDao.getAll();
        return employees;
    }
}
