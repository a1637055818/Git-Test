package com.peng.dao;

import com.peng.bean.Employee;

/**
 * @author 16370
 * @create 2021-04-08 下午 6:30
 */
public interface EmployeeDao {

    public Employee getEmpById(Integer id);

    public int updateEmployee(Employee employee);
    public boolean deleteEmployee(Employee employee);
    public int insertEmployee(Employee employee);

}
