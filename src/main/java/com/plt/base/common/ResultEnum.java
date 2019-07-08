package com.plt.base.common;

/**
 * @author zxq
 */
public enum ResultEnum {
    OK(10000, "SUCCESS"),
    AUTH_FAIL(20001, "权限不足"),
    ILLEGAL_PARAM(40001, "非法参数"),
    BUSINESS_FAIL(40002, "业务处理失败"),
    SYSTEM_EXCEPTION_ERROR(50000, "系统异常"),
    ;

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
