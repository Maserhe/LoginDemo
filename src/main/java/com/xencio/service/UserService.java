package com.xencio.service;

import com.xencio.entity.User;

import java.util.List;

public interface UserService {


    public void save(User user); // 增

    public void delete(Integer id); // 删

    public void update(User book); // 改

    public User getById(Integer id); // 查

    public List<User> selectAll(); // 查全部
}
