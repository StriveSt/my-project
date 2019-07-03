package com.plt.base.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plt.base.common.Result;
import com.plt.base.common.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Lee
 * @date 2019/7/3 13:20
 */
@Slf4j
public class GlobalHandleExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (!(e instanceof BaseException)) {
            log.error("", e);
            return new ModelAndView();
        }

        try {
            Result<String> result = Result.of(ResultEnum.ERROR, e.getMessage());

            PrintWriter writer = httpServletResponse.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(result));
            writer.flush();
            writer.close();
        } catch (Exception e1) {
            throw new RuntimeException(e);
        }
        return new ModelAndView();
    }
}
