package com.fulan.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * api所有结构返回实体，由jsonobject改成该类
 * 最终呈现还是json方式
 * @author 13862
 */
@Getter
@Setter
@ToString
public class ApiResult implements Serializable
{
    /**
     * 禁止new创建对象
     */
    private ApiResult() {}

    /**
     * 统一创建ApiResultBean对象
     * 方便后期扩展
     * @return
     */
    public static ApiResult newInstance(){
        return new ApiResult();
    }

    /**
     * 消息提示
     */
    private String msg;
    /**
     * 状态信息
     */
    private boolean flag;
}
