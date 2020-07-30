package com.fulan.server.controller;

import com.fulan.server.aop.TimeAnnotation;
import com.fulan.server.model.User;
import com.fulan.server.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户接口
 *
 * @author qinjie
 */
@RestController
@RequestMapping("/user")
@Api(value = "/fulan/user",tags = "用户接口")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    /**
     * @Cacheable(value = "users",key = "'user'")
     */
    @ApiOperation(value = "获取用户信息",notes = "根据页码跟页面大小获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum" ,value = "页码" ,required = true,paramType = "query"),
            @ApiImplicitParam(name = "pageSize" ,value = "显示数目" ,required = true,paramType = "query")
    })
    @TimeAnnotation
    public PageInfo<User> getUserListByPage(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        log.info("执行getUserListByPage()方法");
        //pageNum:表示第几页  pageSize:表示一页展示的数据
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.queryUser();
        //将查询到的数据封装到PageInfo对象
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        //分割数据成功
        return userPageInfo;
    }
}
