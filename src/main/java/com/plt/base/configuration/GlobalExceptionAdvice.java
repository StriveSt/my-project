package com.plt.base.configuration;

import com.plt.base.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zxq
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
    /**
     * 拦截所有错误
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result ex() {
        return new Result();
    }
}
