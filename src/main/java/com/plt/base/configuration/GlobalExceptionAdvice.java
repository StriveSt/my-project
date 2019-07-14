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
@ResponseBody
public class GlobalExceptionAdvice {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 拦截所有错误
     */
    @ExceptionHandler(RuntimeException.class)
    public Result exHandler(RuntimeException ex) {
        return forException(ResultEnum.SYSTEM_EXCEPTION_ERROR, ex);
    }

    @ExceptionHandler(BusinessException.class)
    public Result bizExHandler(BusinessException ex) {
        return forException(ResultEnum.BUSINESS_FAIL, ex);
    }

    @ExceptionHandler({IllegalParamException.class, IllegalArgumentException.class, IllegalStateException.class})
    public Result argHandler(IllegalParamException ex) {
        return forException(ResultEnum.ILLEGAL_PARAM, ex);
    }
    @ExceptionHandler(AuthException.class)
    public Result authHandler(AuthException ex) {
        return forException(ResultEnum.AUTH_FAIL, ex);
    }


    private Result forException(ResultEnum e, Exception ex) {
        log.error("异常信息：{}", ex.getMessage());
        ex.printStackTrace();
        Result<Object> r = Result.generate(e);
        r.setMessage(ex.getMessage());
        return r;
    }
}
