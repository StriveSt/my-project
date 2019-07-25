package com.plt.base.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.util.StopWatch;

/**
 * @author zxq
 */
public class ControllerLogInterceptor implements MethodInterceptor {
    private final Logger logger = LoggerFactory.getLogger(ControllerLogInterceptor.class);

    /**
     * 最大执行时间
     */
    private long maxExecuteTimeMillis = 3000;

    public long getMaxExecuteTimeMillis() {
        return maxExecuteTimeMillis;
    }

    public void setMaxExecuteTimeMillis(long maxExecuteTimeMillis) {
        this.maxExecuteTimeMillis = maxExecuteTimeMillis;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String simpleName = invocation.getThis().getClass().getSimpleName();
        String name = invocation.getMethod().getName();
        String joinPoint = simpleName + "#" + name;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object value = invocation.proceed();
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        // 监听时间
        String timeMillis;
        if (totalTimeMillis >= maxExecuteTimeMillis) {
            timeMillis = AnsiOutput.toString(AnsiColor.BRIGHT_RED, totalTimeMillis);
        } else {
            timeMillis = AnsiOutput.toString(AnsiColor.BRIGHT_GREEN, totalTimeMillis);
        }
        logger.info("[{}] 接口执行时间 {}ms", joinPoint, timeMillis);
        return value;
    }
}
