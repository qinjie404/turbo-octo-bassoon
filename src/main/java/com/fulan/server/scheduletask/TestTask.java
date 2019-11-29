package com.fulan.server.scheduletask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 * @author 13862
 */
@Component
@Slf4j
public class TestTask {

    //@Scheduled(cron = "0/10 * * * * ? ")
    public void cron(){
        log.info("执行测试cron时间"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
