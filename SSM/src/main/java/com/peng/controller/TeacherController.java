package com.peng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peng.bean.Teacher;
import com.peng.service.TeacherService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 16370
 * @create 2021-04-13 下午 1:02
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getTeacher")
    public String getTeacher(@RequestParam(value = "id",defaultValue = "1")Integer id, Model model){
        Teacher teacher=teacherService.getTeacher(id);
        model.addAttribute("teacher", teacher);
        return "success";
    }

    @RequestMapping("/getAll")
    public String getTeachers(
     @RequestParam(value = "pn",defaultValue = "1")
             Integer pn,Model model){
        //紧跟的查询就是一个分页查询
        PageHelper.startPage(pn, 5);
        List<Teacher>teachers= teacherService.getAll();

        //我们可以将查询的结果,放在pageinfo中
        //这个pageinfo就有非常多能用的东西
        //第二个传入要连续显示的页码
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers, 5);
        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("当前页有几条记录"+pageInfo.getSize());
        System.out.println("当前的pagesize"+pageInfo.getPageSize());
        System.out.println("前一页"+pageInfo.getPrePage());
        System.out.println("结果"+pageInfo.getList());
        int[] nums = pageInfo.getNavigatepageNums();
        model.addAttribute("pageInfo", pageInfo);
        return "success";
    }

}
