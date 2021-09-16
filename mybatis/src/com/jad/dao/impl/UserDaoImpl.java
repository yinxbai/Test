package com.jad.dao.impl;

import com.jad.dao.IUserDao;
import com.jad.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 54020
 */
public class UserDaoImpl implements IUserDao {

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

    @Override
    public User save(User user) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.save",user);
        sqlSession.commit();
        sqlSession.close();

        return user;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> findAll() {

        return null;
    }

    @Override
    public User findById(int id) {
        User user = null;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        user = sqlSession.selectOne("test.findById",id);

        return user;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> list = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        list = sqlSession.selectList("test.findByName",name);

        return list;
    }

    @Override
    public List<User> queryList() {
        return null;
    }
}
