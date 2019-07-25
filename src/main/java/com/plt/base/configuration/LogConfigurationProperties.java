package com.plt.base.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zxq
 */
@ConfigurationProperties(prefix = "base.log")
public class LogConfigurationProperties {
    private long maxExecuteTimeMillis = 3000L;

    public long getMaxExecuteTimeMillis() {
        return maxExecuteTimeMillis;
    }

    public void setMaxExecuteTimeMillis(long maxExecuteTimeMillis) {
        this.maxExecuteTimeMillis = maxExecuteTimeMillis;
    }
}
