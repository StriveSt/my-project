package com.plt.base.configuration;

import com.plt.base.common.Result;
import com.plt.base.common.ResultEnum;
import com.plt.base.exception.AuthException;
import com.plt.base.exception.BusinessException;
import com.plt.base.exception.IllegalParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zxq
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionAdvice {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 拦截所有错误
     */
    @ExceptionHandler(RuntimeException.class)
    public Result exHandler(RuntimeException ex) {
        log.error("系统错误: ", ex);
        return Result.generate(ResultEnum.SYSTEM_EXCEPTION_ERROR);
    }

    /**
     * 业务错误
     */
    @ExceptionHandler(BusinessException.class)
    public Result bizExHandler(BusinessException ex) {
        log.info("业务错误: {}", ex.getMessage());
        Result<Object> result = Result.generate(ResultEnum.BUSINESS_FAIL);
        result.setMessage(ex.getMessage());
        return result;
    }

    /**
     * 参数错误
     */
    @ExceptionHandler({IllegalParamException.class, IllegalArgumentException.class, IllegalStateException.class})
    public Result argHandler(RuntimeException ex) {
        log.info("参数错误: {}", ex.getMessage());
        return Result.generate(ResultEnum.ILLEGAL_PARAM);
    }

    /**
     * 授权失败
     */
    @ExceptionHandler(AuthException.class)
    public Result authHandler(AuthException ex) {
        log.info("授权失败: {}", ex.getMessage());
        return Result.generate(ResultEnum.AUTH_FAIL);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, HttpMediaTypeException.class})
    public Result methodException(HttpRequestMethodNotSupportedException ex) {
        log.info("不支持的请求", ex);
        Result<Object> result = Result.generate(ResultEnum.ILLEGAL_PARAM);
        result.setMessage("不支持的请求");
        return result;
    }
}
