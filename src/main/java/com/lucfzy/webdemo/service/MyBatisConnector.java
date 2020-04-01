package com.lucfzy.webdemo.service;

import com.lucfzy.webdemo.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConnector {

    private SqlSession session;
    private InputStream in;

    public MyBatisConnector() throws IOException {

    }

    // 类似bean容器功能目的就是为了注入bean，并创建一个IUserDao的对象。
    public IUserDao connectMysql() throws Exception{
        // 创建输入流,加载mybatis的主配置文件
        in = Resources.getResourceAsStream("MyBatisSessionFactory.xml");
        // 创建sqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 加载IUserDao.class,目的是为了class到mybatis中
        session = factory.openSession();
        return session.getMapper(IUserDao.class);
    }

    public InputStream getIn() {
        return in;
    }

    public SqlSession getSession() {
        return session;
    }
}
