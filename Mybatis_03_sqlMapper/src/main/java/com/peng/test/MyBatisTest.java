package com.peng.test;

import com.peng.bean.Cat;
import com.peng.bean.Employee;
import com.peng.bean.Key;
import com.peng.bean.Lock;
import com.peng.dao.CatDao;
import com.peng.dao.EmployeeDao;
import com.peng.dao.KeyDao;
import com.peng.dao.LockDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void test09(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            KeyDao mapper = sqlSession.getMapper(KeyDao.class);
            Key key = mapper.getKeyByIdSimple(1);
            //开启延迟加载
            System.out.println(key);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test08(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            LockDao mapper = sqlSession.getMapper(LockDao.class);
            Lock lock = mapper.getLockById(3);
            List<Key> keys = lock.getKeys();
            for (Key key : keys) {
                System.out.println(key);
            }
            System.out.println(lock);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test07(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            KeyDao mapper = sqlSession.getMapper(KeyDao.class);
            Key key = mapper.getKeyById(2);
            System.out.println(key);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 默认mybatis自动封装结果集：
     * 1.按照列名和属性名一一对应（不区分大小写）
     * 2.如果不一一对应
     *      1.开启驼峰命名法(满足驼峰命名的规则)
     *      2.起别名
     */
    @Test
    public void test06(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            CatDao mapper = sqlSession.getMapper(CatDao.class);
            Cat cat = mapper.getCatById(1);
            System.out.println(cat);
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void test05(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);

            //查询单条记录封装map
            Map<String, Employee> map = mapper.getAllEmpsReturnMap();
            System.out.println(map);
            Employee employee = map.get(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test04(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            //查询多条记录封装list
            List<Employee> emps = mapper.getAllEmps();
            for (Employee e:emps){
                System.out.println(e);
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
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("id", 1);
            map.put("empName", "zhifei");
            Employee employee = mapper.getEmployeeByIdAndEmpName(map);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test02(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = mapper.getEmpByIdAndEmpName(1, "zhifei");
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test01(){
        SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee(null, "千秋", "qq@qq.com", 0);
            mapper.insertEmployee(employee);
            System.out.println("刚才插入的id-->"+employee.getId());
        } finally {
            sqlSession.close();
        }


    }

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
