package com.fulan.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户实体
 * @author qinjie
 */
@Setter
@Getter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户年龄
     */
    private Integer age;

}
