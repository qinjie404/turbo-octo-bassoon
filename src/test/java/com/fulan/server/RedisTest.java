package com.fulan.server;

import com.alibaba.fastjson.JSON;
import com.fulan.server.model.DemoEntity;
import com.fulan.server.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    DemoService demoService;

    @Test
    public void contextLoads() {
        Logger logger = LoggerFactory.getLogger(RedisTest.class);
        // 创建Jedis对象，传递两个参数：第一个host为redis服务器的名称，第二个为redis服务器的端口号
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("123456");
        // 进行设值操作
        List<DemoEntity> demoEntities = demoService.selecDemoListByName("demo测试");
        jedis.set("username", JSON.toJSONString(demoEntities));
        // 从redis中取值
        List<DemoEntity> demoEntities1 = (List<DemoEntity>)JSON.parse(jedis.get("username"));
        logger.info("username:" + demoEntities1.toString());
    }
}
