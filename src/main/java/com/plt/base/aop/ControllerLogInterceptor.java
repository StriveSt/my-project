package com.plt.base.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * @author zxq
 */
public class ControllerLogInterceptor implements MethodInterceptor {
    private final Logger logger = LoggerFactory.getLogger(ControllerLogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String name = invocation.getMethod().getName();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object value = invocation.proceed();
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        logger.info(" [{}] 接口执行时间 {}ms", name, totalTimeMillis);
        return value;
    }
}
