package com.fulan.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用启动类
 * @author acer
 *
 */
@SpringBootApplication(scanBasePackages = "com.fulan.server")
@MapperScan(basePackages = "com.fulan.server.dao")
@EnableScheduling
public class FulanDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FulanDemoApplication.class, args);
	}

}