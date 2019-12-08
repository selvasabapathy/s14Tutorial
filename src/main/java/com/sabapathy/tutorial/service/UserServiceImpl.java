package com.sabapathy.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sabapathy.tutorial.dao.UserDao;
import com.sabapathy.tutorial.model.Login;
import com.sabapathy.tutorial.model.User;

public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    public int register(User user) {
        return userDao.register(user);
    }

    public User login(Login login) {
        return userDao.login(login);
    }
}
