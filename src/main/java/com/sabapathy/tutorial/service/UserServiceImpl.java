package com.sabapathy.tutorial.service;

import com.sabapathy.tutorial.dao.UserRoleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sabapathy.tutorial.dao.UserDao;
import com.sabapathy.tutorial.model.Login;
import com.sabapathy.tutorial.model.User;

public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserDao userDao;

    @Autowired
    public UserRoleDao userRoleDao;

    public int register(User user) {
        logger.debug("Registering user " + user.getName());

        userDao.register(user);
        return userRoleDao.register(user.getUsername());
    }

    public User login(Login login) {
        return userDao.login(login);
    }

    public int update(User user) {
        return userDao.update(user);
    }
}
