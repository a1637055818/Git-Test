package com.peng.controller;

import com.peng.dao.DepartmentDao;
import com.peng.dao.EmployeeDao;
import com.peng.entities.Department;
import com.peng.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author 16370
 * @create 2021-04-01 下午 11:00
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工,来到展示页面
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "list";
    }

    /**
     * 去添加员工页面,去页面之前查询出所有部门名
     * @return
     */
    @RequestMapping("/toAddPage")
    public String toAddPage(Model model){

        model.addAttribute("employee", new Employee());
        return "add";
    }

    /**
     * 保存员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult result){
        System.out.println(employee);
        //获取是否有校验错误
        boolean hasErrors = result.hasErrors();

        if (hasErrors){
            System.out.println("有校验错误");
            return "add";
        }else {

        employeeDao.save(employee);
        //返回列表页面,重定向到查询所有员工的请求
        return "redirect:/emps";
        }

    }

    /**
     * 查询员工,来到修改页面回显
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id
    ,Model model){
        //1.查出员工信息
        Employee employee = employeeDao.get(id);
        //2.放在请求域中
        model.addAttribute("employee", employee);
        //3.继续查出部门信息放在隐含模型中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "edit";
    }

    /**
     * 修改页面,来到展示页面
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(Employee employee){
        System.out.println(employee);
        //更新保存二合一
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void myModelAndAttribute(@RequestParam(value = "id",required = false) Integer id
    ,Model model){
        if (id!=null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee", employee);
        }
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
