package com.tmall.service;

import com.tmall.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User get(int id);
}
