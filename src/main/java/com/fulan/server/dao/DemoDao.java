package com.fulan.server.dao;

import com.fulan.server.model.DemoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoDao {

	/**
	 * 添加demo数据
	 * @param demoEntity
	 * @return
	 */
	@Insert("insert into t_demo(name,s_ex,age) values(#{name},#{sex},#{age})")
	Integer addDemo(DemoEntity demoEntity);
	
	/**
	 * 查询demo表中List
	 * @param name
	 * @return
	 */
	@Select("select id,name,s_ex,age from t_demo where name=#{name}")
	List<DemoEntity> selecDemoListByName(@Param("name") String name);
}
