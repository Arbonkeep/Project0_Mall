package com.mmall.common;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author arbonkeep
 * @date 2019/12/19 - 14:10
 * 响应数据枚举类
 */
public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),//响应成功
    ERROR(1, "ERROR"),//响应失败
    NEED_LOGIN(10, "NEED_LOGIN"),//需要登录
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");//参数错误

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    //对外提供获取code和desc的方法
    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
