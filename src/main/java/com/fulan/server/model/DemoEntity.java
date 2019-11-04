package com.fulan.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Demo实体
 * @author acer
 *
 */
@Setter
@Getter
@ToString
public class DemoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
}