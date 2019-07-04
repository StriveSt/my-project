package com.plt.base.configuration;

import com.plt.base.common.Result;
import com.plt.base.common.ResultEnum;
import com.plt.base.exception.AuthException;
import com.plt.base.exception.BusinessException;
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
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exHandler(Exception ex) {
        ex.printStackTrace();
        return new Result<>(ResultEnum.SYSTEM_EXCEPTION_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result bizExHandler(BusinessException bx) {
        Result result = new Result<>();
        result.setCode(ResultEnum.BUSINESS_FAIL.getCode());
        result.setMessage(bx.getMessage());
        return result;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result argHandler(IllegalArgumentException ex) {
        return new Result(ResultEnum.ILLEGAL_PARAM);
    }

    @ExceptionHandler(AuthException.class)
    public Result authHandler(AuthException ex) {
        return new Result(ResultEnum.AUTH_FAIL);
    }
}
