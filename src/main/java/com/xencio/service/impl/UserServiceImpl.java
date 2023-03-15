package com.xencio.service.impl;

import com.xencio.entity.User;
import com.xencio.mapper.UserMapper;
import com.xencio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(User book) {

    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> selectAll() {
        return null;
    }
}
