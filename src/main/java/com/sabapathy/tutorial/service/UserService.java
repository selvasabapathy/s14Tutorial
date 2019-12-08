package com.sabapathy.tutorial.service;

import com.sabapathy.tutorial.model.Login;
import com.sabapathy.tutorial.model.User;

public interface UserService {
    int register(User user);

    User login(Login login);

    int update(User user);
}
