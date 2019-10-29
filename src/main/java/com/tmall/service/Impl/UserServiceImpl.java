package com.tmall.service.Impl;

import com.tmall.entity.User;
import com.tmall.entity.UserExample;
import com.tmall.mapper.UserMapper;
import com.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
