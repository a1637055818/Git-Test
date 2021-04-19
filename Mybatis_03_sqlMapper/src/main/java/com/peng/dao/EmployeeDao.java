package com.peng.dao;

import com.peng.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 16370
 * @create 2021-04-08 下午 6:30
 */
public interface EmployeeDao {

    /**
     * 列名作为key，值作为value
     * @param id
     * @return
     */
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    /**
     * key就是这个记录的主键,value就是这条记录封装好的对象
     * 把查询的记录的id的值作为key封装这个map
     * @return
     */
    @MapKey("id")
    public Map<String,Employee> getAllEmpsReturnMap();

    public List<Employee> getAllEmps();

    public Employee getEmpById(Integer id);
    public Employee getEmpByIdAndEmpName(@Param("id") Integer id,@Param("empName") String empName);
    public Employee getEmployeeByIdAndEmpName(Map<String,Object> map);

    public int updateEmployee(Employee employee);
    public boolean deleteEmployee(Employee employee);
    public int insertEmployee(Employee employee);

}
