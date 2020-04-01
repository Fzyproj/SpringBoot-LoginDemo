package com.lucfzy.webdemo;

import com.lucfzy.webdemo.dao.IUserDao;
import com.lucfzy.webdemo.entity.User;
import com.lucfzy.webdemo.service.MyBatisConnector;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class WebDemoApplicationTests {

    @Test
    public void test() throws Exception{
        // 创建mybatis执行对象
        MyBatisConnector mB = new MyBatisConnector();
        // 创建连接对象,返回users结果集
        IUserDao iUserDao = mB.connectMysql();
        // 执行查找方法
        User user = iUserDao.findOne("admin");
        if (user != null){
            System.out.println("完美获取数据。。。。。。。");
            List<User> list = new ArrayList<>();
            list.add(user);
            for (User iuser : list) {
                System.out.println(iuser);
                System.out.println(list.size());
            }
        }
        // 完美关闭连接
        mB.getSession().close();
        mB.getIn().close();
    }

    @Test
    public void selectOne() throws Exception {
        // 创建mybatis执行对象
        MyBatisConnector mB = new MyBatisConnector();
        // 创建连接对象,返回users结果集
        IUserDao iUserDao = mB.connectMysql();
        // 执行查找方法
        User user = iUserDao.findOne("lyy");
        System.out.println("密码为"+user.getPassword());
        System.out.println("邮件为"+user.getEmail());
    }
}
