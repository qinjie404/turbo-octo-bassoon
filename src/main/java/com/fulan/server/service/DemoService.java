package com.fulan.server.service;

import java.util.List;

import com.fulan.server.model.DemoEntity;

/**
 * Demo服务层接口
 * @author acer
 *
 */
public interface DemoService {


	Integer addDemo(DemoEntity demoEntity);
	
	List<DemoEntity> selecDemoListByName(String name);
}
