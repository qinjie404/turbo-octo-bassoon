package com.fulan.server.controller;

import com.fulan.server.model.User;
import com.fulan.server.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户接口
 *
 * @author qinjie
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    @Cacheable(value = "users",key = "'user'")
    public List<User> getUserListByPage(PageInfo pageInfo) {
        Logger  logger= LoggerFactory.getLogger(UserController.class);
        //pageNum:表示第几页  pageSize:表示一页展示的数据
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<User> users = userService.queryUser();
        //将查询到的数据封装到PageInfo对象
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        logger.info("userPageInfo:"+userPageInfo.getPageNum());
        //分割数据成功
        return users;
    }
}
