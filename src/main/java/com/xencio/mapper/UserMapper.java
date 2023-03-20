package com.xencio.mapper;


import com.xencio.entity.User;

import java.util.List;

public interface UserMapper {

    public int save(User user);

    public void delete(Integer id);

    public void update(User book);

    public User getById(Integer id);

    public List<User> selectAll();

    User getUserByUsername(String username);
}
