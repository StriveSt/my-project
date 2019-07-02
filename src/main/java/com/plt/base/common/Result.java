package com.plt.base.common;

/**
 * 前端报文
 * @author zxq
 */
public class Result<T> {
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
}
