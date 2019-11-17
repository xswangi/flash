package com.wxs.service.serviceImpl;

import com.wxs.entity.User;
import com.wxs.mapper.UserMapper;
import com.wxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserInfo(Integer id){
        return userMapper.findUserInfo(id);
    }
}
