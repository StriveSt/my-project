package com.plt.base.exception;


/**
 * 服务异常定义,封装服务调用异常
 */
public class ServiceException extends BaseException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
