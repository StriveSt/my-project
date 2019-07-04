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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.OK.getCode());
        result.setMessage(ResultEnum.OK.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> generateResult(ResultEnum resultEnum, T data) {
        Result<T> result = new Result<>();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        result.setData(data);
        return result;
    }
}
