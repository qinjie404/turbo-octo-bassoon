package com.fulan.server.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fulan.server.common.util.LoggerUtils;
import com.fulan.server.dao.LoggerDao;
import com.fulan.server.model.LoggerEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 13862
 */
public class LoggerInterceptor implements HandlerInterceptor {

    /**
     * 请求开始时间标识
     */
    private static final String LOGGER_SEND_TIME="logger_send_time";
    /**
     * 请求日志实体标识
     */
    private static final String LOGGER_ENTITY="logger_entity";

    public LoggerDao loggerDao;
    public LoggerInterceptor(LoggerDao loggerDao){
        this.loggerDao=loggerDao;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoggerEntity loggerEntity = new LoggerEntity();
        //获取请求sessionId
        String sessionId=request.getSession().getId();
        //获取请求路径
        String uri=request.getRequestURI();
        //获取请求参数
        String paramData= JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.DisableCircularReferenceDetect);
        //设置客户端ip
        loggerEntity.setClientIp(LoggerUtils.getCliectIp(request));
        //设置请求方法
        loggerEntity.setMethod(request.getMethod());
        //设置请求类型（json|普通请求）
        loggerEntity.setType(LoggerUtils.getRequestType(request));
        loggerEntity.setParamData(paramData);
        loggerEntity.setUri(uri);
        loggerEntity.setSessionId(sessionId);
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY, loggerEntity);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //获取请求码
        int status=response.getStatus();
        //当前时间
        long currentTime=System.currentTimeMillis();
        //请求开始时间
        long time=Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        LoggerEntity loggerEntity= (LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        //设置响应时间
        loggerEntity.setTimeConsuming(Integer.valueOf((currentTime-time)+""));
        loggerEntity.setHttpStatusCode(status+"");
        //设置返回值
        loggerEntity.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        loggerDao.addLoggerInfo(loggerEntity);
    }
}
