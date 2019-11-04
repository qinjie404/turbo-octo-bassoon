package com.fulan.server.service;

import com.fulan.server.model.User;

import java.util.List;

/**
 * 用户服务层接口
 * @author qinjie
 */
public interface UserService {

    /**
     * 查询用户信息
     * @return List<User>
     */
    List<User> queryUser();
}
