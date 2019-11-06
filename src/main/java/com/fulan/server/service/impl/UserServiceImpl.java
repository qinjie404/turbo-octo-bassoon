package com.fulan.server.service.impl;

import com.fulan.server.dao.UserDao;
import com.fulan.server.model.User;
import com.fulan.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务层实现
 * @author qinjie
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> queryUser() {
        return userDao.queryUser();
    }
}
