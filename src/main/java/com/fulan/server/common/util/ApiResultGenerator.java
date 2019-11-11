package com.fulan.server.common.util;

import com.fulan.server.model.ApiResult;
/**
 * @author 13862
 */
public final class ApiResultGenerator
{
    /**
     * 创建普通消息方法
     * @param flag 执行接口状态，true:执行成功,false:执行失败
     * @param msg 返回消息内容
     * @return
     */
    public static ApiResult result(boolean flag, String msg)
    {
        //创建返回对象
        ApiResult apiResult = ApiResult.newInstance();
        apiResult.setFlag(flag);
        apiResult.setMsg(msg);
        return apiResult;
    }

    /**
     * 执行失败后返回视图方法
     * @param msg 执行失败后的错误消息内容
     * @return
     */
    public static ApiResult errorResult(String msg)
    {
        return result(false,msg);
    }
}
