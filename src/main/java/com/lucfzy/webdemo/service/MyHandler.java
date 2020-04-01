package com.lucfzy.webdemo.service;

import com.lucfzy.webdemo.dao.IUserDao;
import com.lucfzy.webdemo.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyHandler {

    @Autowired
    private User user;

    @PostMapping("/loginHandler")
    public String loginHandler (@RequestParam String name,
                    @RequestParam String password, Model m) throws Exception{
        // 创建连接对象,返回users结果集
        IUserDao iUserDao = new MyBatisConnector().connectMysql();
        // 执行查找方法
        User iuser = iUserDao.findOne(name);

        if (iuser != null && iuser.getPassword().equals(password)){
            m.addAttribute("username",name);
            return "loginSuccess";
        }
        return "loginFailed";
    }

    @PostMapping("/registerHandler")
    public String registerHandler(@RequestParam String name,@RequestParam String password,
                                  @RequestParam String email) throws Exception{
        MyBatisConnector mb = new MyBatisConnector();
        // 创建连接对象,返回users结果集
        IUserDao iUserDao = mb.connectMysql();
        SqlSession session = mb.getSession();
        // 封装User对象
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        // 执行查找方法
        iUserDao.insertUser(user);
        session.commit();
        session.close();
        mb.getIn().close();
        System.out.println("for test");
        return "registerSuccess";
    }
}
