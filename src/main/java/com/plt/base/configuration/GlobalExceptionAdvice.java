package com.plt.base.configuration;

import com.plt.base.common.Result;
import com.plt.base.common.ResultEnum;
import com.plt.base.exception.AuthException;
import com.plt.base.exception.BusinessException;
import com.plt.base.exception.IllegalParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zxq
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 拦截所有错误
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exHandler(Exception ex) {
        return forException(ResultEnum.SYSTEM_EXCEPTION_ERROR, ex);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result bizExHandler(BusinessException ex) {
        return forException(ResultEnum.BUSINESS_FAIL, ex);
    }

    @ExceptionHandler(IllegalParamException.class)
    public Result argHandler(IllegalParamException ex) {
        return forException(ResultEnum.ILLEGAL_PARAM, ex);
    }

    @ExceptionHandler(AuthException.class)
    public Result authHandler(AuthException ex) {
        return forException(ResultEnum.AUTH_FAIL, ex);
    }


    private Result forException(ResultEnum e, Exception ex) {
        log.error(ex.getMessage(),ex);
        Result<Object> r = Result.generate(e);
        r.setMessage(ex.getMessage());
        return r;
    }
}
