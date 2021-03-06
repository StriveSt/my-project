package com.plt.base.exception;

/**
 * @author Lee
 * @date 2019/7/3 11:13
 */
public abstract class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }
    public BaseException(Throwable cause) {
        super(cause);
    }
    public BaseException(String message) {
        super(message);
    }
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
