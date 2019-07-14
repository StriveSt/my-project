package com.plt.base.common;

import java.io.Serializable;

/**
 * 前端报文
 *
 * @author zxq
 */
public class Result<T> implements Serializable {
    /**
     * 响应码
     */
    private int code;
    /**
     * 消息
     */
    private String message;
    /**
     * 报文体
     */
    private T data;

    private Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> generateSuccess(T data) {
        return generate(ResultEnum.OK, data);
    }

    public static <T> Result<T> generateSuccess() {
        return generate(ResultEnum.OK);
    }

    public static <T> Result<T> generate(ResultEnum e, T data) {
        return new Result<>(e, data);
    }

    public static <T> Result<T> generate(ResultEnum e) {
        return generate(e, null);
    }
}
