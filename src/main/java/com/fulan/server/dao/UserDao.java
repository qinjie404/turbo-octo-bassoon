package com.fulan.server.dao;

import com.fulan.server.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户dao
 * @author qinjie
 */
@Mapper
public interface UserDao {

    /**
     * 查询用户信息
     * @return List<User>
     */
    @Select("select * from user")
    List<User> queryUser();
}
