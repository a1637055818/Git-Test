package com.peng.dao;

import com.peng.bean.Teacher;

import java.util.List;

/**
 * @author 16370
 * @create 2021-04-13 下午 12:37
 */
public interface TeacherDao {

    public Teacher getTeacherById(Integer id);

    public List<Teacher> getTeachers();
}
