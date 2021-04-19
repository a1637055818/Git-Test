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

    /**
     * 1.不会出现一级缓存和二级缓存中有同一个数据
     *      二级缓存中：一级缓存关闭了就有了
     *      一级缓存中：二级缓存中没有此数据，
     *      就会看一级缓存，一级缓存没有就去查数据库
     *      数据库的查询后的结果就放在一级缓存中
     * 2.任何时候都是先看二级缓存，在看一级缓存，
     * 如果都没有就去数据库查询
     * 二---->一--->库
     */
    @Test
    public void test03(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        TeacherDao mapper1 = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher1 = mapper1.getTeacherById(1);
        sqlSession.close();

        TeacherDao mapper2 = sqlSession2.getMapper(TeacherDao.class);
        Teacher teacher2 = mapper2.getTeacherById(1);
        Teacher teacher3 = mapper2.getTeacherById(1);
        sqlSession2.close();
    }

    /**
     * 一级缓存失效的几种情况
     * 一级缓存是sqlsession级别的缓存
     * 1.不同sqlsession使用不同的一级缓存
     * 2.同一个方法，不同的参数，由于之前没查过，还会发新的sql
     * 3.在sqlsession期间执行任何一次增删改操作，增删改操作会清除缓存
     * 4.手动清空了缓存
     *
     * 每次查询，先看一级缓存中有没有，如果没有就发送新的sqlsession
     * 每个sqls拥有自己的一级缓存
     *
     * 二级缓存：sqlsession关闭或者提交以后,一级缓存的数据会放在二级缓存中
     *
     */
    @Test
    public void test02(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        TeacherDao mapper1 = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher1 = mapper1.getTeacherById(1);

        //执行任何一个增删改操作
//        Teacher teacher = new Teacher();
//        teacher.setId(3);
//        teacher.setName("rongyao");
//        mapper1.updateTeacher(teacher);
        //清空当前sqlsession的一级缓存
        //sqlSession.clearCache();

        Teacher teacher2 = mapper1.getTeacherById(1);
        sqlSession.close();
    }


    /**
     * 体会一级缓存:sqlsession级别的缓存
     * 只要之前查询过的数据mybatis就会保存起来(一个Map中)
     * 下次获取直接从缓存中获取
     *
     * 二级缓存：namespace级别的缓存
     */
    @Test
    public void test01(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);


        TeacherDao mapper1 = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher1 = mapper1.getTeacherById(1);
        sqlSession.close();

        TeacherDao mapper2 = sqlSession2.getMapper(TeacherDao.class);
        Teacher teacher2 = mapper2.getTeacherById(1);
        sqlSession2.close();

    }

}
