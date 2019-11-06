package com.fulan.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 13862
 */
@Getter
@Setter
@ToString
public class LoggerEntity implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 客户端请求ip
     */
    private String clientIp;
    /**
     * 客户端请求路径
     */
    private String uri;
    /**
     * 终端请求方式（普通请求，ajax请求）
     */
    private String type;
    /**
     * 请求方式（post,get等）
     */
    private String method;
    /**
     * 请求参数
     */
    private String paramData;
    /**
     * 请求接口唯一sessionid
     */
    private String sessionId;
    /**
     * 请求时间
     */
    private Timestamp time;
    /**
     * 接口返回数据json
     */
    private String returnData;
    /**
     * 接口返回状态码
     */
    private String httpStatusCode;
    /**
     * 请求耗时
     */
    private Integer timeConsuming;
}
