package com.peng.test;

import com.peng.bean.Teacher;
import com.peng.dao.TeacherDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 16370
 * @create 2021-04-08 下午 6:56
 */
public class MyBatisTest {

    public SqlSessionFactory initSqlSessionFactory(){
        String resource = "mybatis-config.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        return  sqlSessionFactory;
    }

    @Test
    public void test06(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("zhifei");
            mapper.updateTeacher(teacher);
        } finally {
            sqlSession.close();
        }
    }
    
    @Test
    public void test05(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            List<Teacher> teachers = mapper.getTeacherByConditionChoose(teacher);
            for (Teacher t : teachers) {
                System.out.println(t);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test04(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            List<Teacher> teachers = mapper.getTeacherByIdIn(Arrays.asList(1, 2, 3, 4, 5));
            for (Teacher t : teachers) {
                System.out.println(t);
            }
        } finally {
            sqlSession.close();
        }
    }



    @Test
    public void test03(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            //teacher.setName("%李%");
            //teacher.setBirth(new Date());
            List<Teacher> teachers = mapper.getTeacherByCondition(teacher);
            for (Teacher t : teachers) {
                System.out.println(t);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test01(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = mapper.getTeacherById(1);
            System.out.println(teacher);
        } finally {
            sqlSession.close();
        }
    }

}
