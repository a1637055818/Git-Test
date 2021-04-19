package com.peng.test;

import com.peng.bean.Teacher;
import com.peng.bean.TeacherExample;
import com.peng.dao.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
    public void testPage(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

    }

    @Test
    public void test02(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher>list=new ArrayList<Teacher>();
        for (int i=0;i<1000;i++){
            Teacher teacher = new Teacher();
            teacher.setTeachername(UUID.randomUUID().toString().substring(0, 5));
            teacher.setClassName(UUID.randomUUID().toString().substring(0,3));
            list.add(teacher);
        }
        mapper.insertBatch(list);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test01(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeachernameLike("%z%");
        criteria.andAddressIn(Arrays.asList("宝安区"));

        TeacherExample.Criteria criteria1 = teacherExample.createCriteria();
        criteria1.andAddressIn(Arrays.asList("南山区"));
        teacherExample.or(criteria1);

        int i = mapper.countByExample(teacherExample);
        System.out.println(i);

    }


}
