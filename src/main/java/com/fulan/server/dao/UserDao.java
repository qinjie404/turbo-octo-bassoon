package com.fulan.server.dao;

import com.fulan.server.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao
 * @author qinjie
 */
@Repository
public interface UserDao {

    /**
     * 查询用户信息
     * @return List<User>
     */
    List<User> queryUser();
}
