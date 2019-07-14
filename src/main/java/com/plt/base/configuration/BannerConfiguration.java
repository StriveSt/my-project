package com.plt.base.configuration;

import com.plt.base.banner.PltBanner;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxq
 */
@Configuration
public class BannerConfiguration implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        new PltBanner().printBanner(null, null, System.out);
    }
}
