package com.fulan.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fulan.server.dao.DemoDao;
import com.fulan.server.model.DemoEntity;
import com.fulan.server.service.DemoService;

/**
 * Demo服务层实现
 * @author foodoo
 *
 */
@Service
public class DemoServiceImpl implements DemoService{
	
	@Resource
	private DemoDao demoDao;

	@Transactional
	@Override
	public Integer addDemo(DemoEntity demoEntity) {
		
		return demoDao.addDemo(demoEntity);
		
	}

	@Override
	public List<DemoEntity> selecDemoListByName(String name) {
		return demoDao.selecDemoListByName(name);
	}
	
}