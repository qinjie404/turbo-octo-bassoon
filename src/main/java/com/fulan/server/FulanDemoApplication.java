package com.fulan.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动类
 * @author acer
 *
 */
@SpringBootApplication(scanBasePackages = "com.fulan.server")
@MapperScan(basePackages = "com.fulan.server.dao")
public class FulanDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FulanDemoApplication.class, args);
	}

}