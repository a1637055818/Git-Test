package com.peng.test;

import com.peng.bean.Employee;
import com.peng.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 16370
 * @create 2021-04-08 下午 6:56
 */
public class MyBatisTest {

    @Test
    public void testSelectById() throws IOException {
        /**
         * 1.根据全局配置文件创建出一个SqlSessionFactory
         * SqlSessionFactory：是SqlSession工厂，负责创建
         * SqlSession对象
         * SqlSession：sql会话(代表和数据库的一次会话)
         */
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession=null;
        try {
            //2.获取和数据的一次会话:getConnection()
            sqlSession = sqlSessionFactory.openSession();
            //3.使用sqlSession操作数据库,获取到dao接口的实现
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            //4.调用之前的方法
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }

    }
}
