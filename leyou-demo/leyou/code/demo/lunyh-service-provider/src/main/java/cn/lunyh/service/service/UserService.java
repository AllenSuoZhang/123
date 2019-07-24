package cn.lunyh.service.service;

import cn.lunyh.service.pojo.User;

import java.util.List;

public interface UserService {
    public User queryById(Long id);

    public void deleteById(Long id);

    List<User> selectAll();
}
