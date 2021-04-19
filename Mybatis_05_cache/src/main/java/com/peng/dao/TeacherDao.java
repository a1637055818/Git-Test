package com.peng.dao;

import com.peng.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 16370
 * @create 2021-04-12 下午 1:40
 */
public interface TeacherDao {

    public Teacher getTeacherById(Integer id);

    public List<Teacher> getTeacherByCondition(Teacher teacher);

    public List<Teacher> getTeacherByIdIn(@Param("ids") List<Integer>ids);

    public List<Teacher> getTeacherByConditionChoose(Teacher teacher);

    public int updateTeacher(Teacher teacher);
}
