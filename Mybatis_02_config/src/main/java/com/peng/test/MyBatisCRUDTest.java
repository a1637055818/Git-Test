package com.peng.test;

import com.peng.bean.Employee;
import com.peng.dao.EmployeeDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author 16370
 * @create 2021-04-08 下午 7:39
 */
public class MyBatisCRUDTest {

    public SqlSessionFactory initSqlSessionFactory(){
        String resource = "mybatis-config.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        return sqlSessionFactory;
    }

    @Test
    public void testUpdate(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            employee.setId(7);
            employee.setEmail("asd@qq.com");
            employee.setEmpName("rongyao");
            employee.setGender(0);
            mapper.updateEmployee(employee);
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void testDelete(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            employee.setId(6);
            mapper.deleteEmployee(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            mapper.insertEmployee(new Employee(null, "qianqiu", "qianqiu@qq.com", 0));
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void testSelectById(){
        /**
         * 1.根据全局配置文件创建出一个SqlSessionFactory
         * SqlSessionFactory：是SqlSession工厂，负责创建
         * SqlSession对象
         * SqlSession：sql会话(代表和数据库的一次会话)
         */
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();

        SqlSession sqlSession= sqlSessionFactory.openSession();
        try {
            //2.获取和数据的一次会话:getConnection()
            //3.使用sqlSession操作数据库,获取到dao接口的实现
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            //4.调用之前的方法
            Employee empById = mapper.getEmpById(1);
            System.out.println(empById);
        } finally {
            sqlSession.close();
        }

    }
}
