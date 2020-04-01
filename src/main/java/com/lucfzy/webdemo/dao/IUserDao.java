package com.lucfzy.webdemo.dao;

import com.lucfzy.webdemo.entity.User;

import java.util.List;

public interface IUserDao {
    // 查询数据库返回结果集并封装成list对象
    User findOne(String name);
    // 插入一条数据
    void insertUser(User user);
}
