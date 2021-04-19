package com.peng.service;

import com.peng.bean.Teacher;
import com.peng.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 16370
 * @create 2021-04-13 下午 12:28
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;



    public Teacher getTeacher(Integer id) {
        return teacherDao.getTeacherById(id);
    }


    public List<Teacher> getAll() {
        return teacherDao.getTeachers();
    }
}
