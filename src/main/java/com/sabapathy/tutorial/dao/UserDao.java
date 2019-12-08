package com.sabapathy.tutorial.dao;

import com.sabapathy.tutorial.model.Login;
import com.sabapathy.tutorial.model.User;

public interface UserDao {
    int register(User user);

    User login(Login login);
}
