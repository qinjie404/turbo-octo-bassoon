package com.fulan.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "用户实体")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id",name = "id",example = "1")
    private Integer id;
    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名",name = "name",example = "qinjie")
    private String name;
    /**
     * 用户年龄
     */
    @ApiModelProperty(value = "用户年龄",name = "age",example = "20")
    private Integer age;

}
