package com.fulan.server.model.eo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
* EO - 
* ============================================================================
* 版权所有 2019 。
*
* @author qinjie
* @version 1.0 2019-11-12
* ============================================================================
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_generator")
@ApiModel(value = "testGeneratorEO实体")
public class TestGeneratorEO implements Serializable {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "删除标识（0：未删除1：删除）")
    private Boolean deleteFlag;


}