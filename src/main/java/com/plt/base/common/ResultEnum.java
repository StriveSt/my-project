package com.plt.base.common;

/**
 * @author zxq
 */
public enum ResultEnum {
    OK(200, "SUCCESS"),
    AUTH_FAIL(400, "权限不足"),
    ILLEGAL_PARAM(501, "参数错误"),
    BUSINESS_FAIL(502, "业务处理失败"),
    SYSTEM_EXCEPTION_ERROR(503, "系统异常"),
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
