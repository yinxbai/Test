package com.jad.test;

import com.jad.dao.IUserDao;
import com.jad.dao.impl.UserDaoImpl;
import com.jad.mapper.CityMapper;
import com.jad.mapper.UserMapper;
import com.jad.po.City;
import com.jad.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



/**
 * @author 54020
 */

public class UserTest {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            String resources = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resources);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindById() {
        IUserDao dao = new UserDaoImpl();
        User user = dao.findById(2);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        IUserDao dao = new UserDaoImpl();
        List<User> list = dao.findByName("w");
        System.out.println(list);
    }
    @Test
    public void testSave() {
        IUserDao dao = new UserDaoImpl();

    }

    @Test
    public void testMapper() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object>  map = mapper.findUserById(2);
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key+":"+map.get(key));
        }

//        User user = new User(10,20212210,"傻逼","女",19);
//        mapper.update(user);
//        sqlSession.commit();
//        System.out.println(user);
///*        List<User> list = mapper.findByName("w");
//        System.out.println(list);
//        mapper.deleteById(1);*/
//        User user = new User(null,20212210,"李四","女",19);
//        mapper.save(user);
//        sqlSession.commit();

    }
    @Test
    public void testSearch(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("w");
        user.setAge(1);
        List<User> list = mapper.search(user);
        for (int i = 0; i < list.size(); i++) {
            user = list.get(i);
            System.out.println(user);
        }
    }

    @Test
    public void testqueryList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> list = mapper.queryList();
//        for (int i = 0; i < list.size(); i++) {
//            User user = list.get(i);
//            System.out.println(user);
//        }
    }
    @Test
    public  void  testfindId(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CityMapper mapper = sqlSession.getMapper(CityMapper.class);
        City city = mapper.findById(2);
        System.out.println(city);
    }
}
