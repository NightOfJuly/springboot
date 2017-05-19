package com.qindy.service;

import com.qindy.entity.User;

import java.util.List;

/**
 * Created by ibm on 2017/5/18.
 */
public interface IUserService {

    /**
     * 根据id查询用户
     */
    User findById(String id);

    /**
     * 查询用户列表
     */
    List<User> findAll();
}
