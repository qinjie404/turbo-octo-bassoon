package com.fulan.server.configuration;

import com.fulan.server.common.util.ApiResultGenerator;
import com.fulan.server.model.ApiResult;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器通知
 * @author 13862
 */
@ControllerAdvice
@ResponseBody
public class RestExceptionHandler
{
    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.toString());
    }
}
