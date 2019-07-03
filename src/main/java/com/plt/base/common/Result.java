package com.plt.base.common;

import java.io.Serializable;

/**
 * 前端报文
 *
 * @author zxq
 */
public final class Result<T> implements Serializable {
    /**
     * 响应码
     */
    private final int code;
    /**
     * 消息
     */
    private final String message;
    /**
     * 报文体
     */
    private final T data;

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> Result<T> of(ResultEnum e) {
        return new Result<>(e.getCode(), e.getMessage(), null);
    }

    public static <T> Result<T> of(ResultEnum e, String message) {
        return new Result<>(e.getCode(), message, null);
    }

    public static <T> Result<T> of(ResultEnum e, T data) {
        return new Result<>(e.getCode(), e.getMessage(), data);
    }

    public static <T> Result<T> of(ResultEnum e, String message, T data) {
        return new Result<>(e.getCode(), message, data);
    }
}
