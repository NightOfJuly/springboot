package com.qindy.service.impl;

import com.qindy.dao.UserDao;
import com.qindy.entity.User;
import com.qindy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ibm on 2017/5/18.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
