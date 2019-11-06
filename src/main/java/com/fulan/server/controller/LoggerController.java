package com.fulan.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.fulan.server.common.util.LoggerUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 13862
 */
@RestController
@RequestMapping("/logger")
public class LoggerController {

    @RequestMapping("/login")
    public JSONObject login(HttpServletRequest request,String name){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg", "用户"+name+"登录成功");
        request.setAttribute(LoggerUtils.LOGGER_RETURN, jsonObject);
        return jsonObject;
    }
}
