package cn.lunyh.user.service;

import cn.lunyh.user.pojo.User;

import java.util.List;

public interface UserService {
    public User queryById(Long id);

    public void deleteById(Long id);

    List<User> selectAll();
}
