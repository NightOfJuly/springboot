package com.qindy.dao;

import com.qindy.entity.User;

import java.util.List;

/**
 * Created by ibm on 2017/5/18.
 */
public interface UserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 根据登录名查询用户
     * @param loginName
     * @return
     */
    User findByName(String loginName);

    /**
     * 查询全部用户列表
     * @return
     */
    //TODO 分页
    List<User> findAll();
}
