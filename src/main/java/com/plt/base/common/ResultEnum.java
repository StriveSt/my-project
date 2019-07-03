package com.plt.base.common;

/**
 * @author zxq
 */
public enum ResultEnum {
    OK(10000, "success"),
    AUTH_FAIL(10001, "Authorization failure"),
    ILLEGAL_REQUEST(10002, "Illegal request"),
    ERROR(10003, "error")
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
