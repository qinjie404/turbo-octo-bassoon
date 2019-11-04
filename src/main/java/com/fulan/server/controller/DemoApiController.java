package com.fulan.server.controller;

import com.fulan.server.model.DemoEntity;
import com.fulan.server.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * DEMO_API接口
 *
 * @author demo
 */
@RestController
public class DemoApiController {

    @Value("${server.servlet.context-path}")
    private String basePath;
    @Resource
    private DemoService demoService;

    /**
     * 入库查询测试
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/demoapi")
    public Map<String, Object> index(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setAge(18);
        demoEntity.setName("demo测试");
        demoEntity.setSex("男");
        demoService.addDemo(demoEntity);
        map.put("message", "入库成功");
        map.put("code", "9999");
        map.put("result", demoService.selecDemoListByName("demo测试"));
        map.put("path", basePath);
        Logger logger = LoggerFactory.getLogger(DemoApiController.class);
        logger.info(basePath);
        return map;
    }
}
