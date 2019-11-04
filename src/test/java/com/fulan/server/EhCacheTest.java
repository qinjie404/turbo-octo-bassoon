package com.fulan.server;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EhCacheTest {
    @Test
    public void contextLoads() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(EhCacheTest.class);
        CacheManager create = CacheManager.create(this.getClass().getResourceAsStream("/ehcache.xml"));
        Cache cache = create.getCache("helloWorldCache");
        cache.put(new Element("name", "qinjie"));
        Element element1 = cache.get("name");
        logger.info(element1.getObjectKey()+" : "+element1.getObjectValue());
        Thread.sleep(5000);
        Element element2 = cache.get("name");
        if(element2!=null){
            logger.info(element2.getObjectKey()+" : "+element2.getObjectValue());
        }else{
            logger.info("对象不存在");
        }
    }
}
