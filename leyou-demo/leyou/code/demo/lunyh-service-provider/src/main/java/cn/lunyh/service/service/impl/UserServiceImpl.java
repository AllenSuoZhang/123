package cn.lunyh.service.service.impl;

import cn.lunyh.service.mapper.UserMapper;
import cn.lunyh.service.pojo.User;
import cn.lunyh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return this.userMapper.selectAll();
    }
}
