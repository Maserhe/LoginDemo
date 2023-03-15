package com.xencio.mapper;


import com.xencio.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {

    public void save(User user); // 增

    public void delete(Integer id); // 删

    public void update(User book); // 改

    public User getById(Integer id); // 查

    public List<User> selectAll(); // 查全部
}
