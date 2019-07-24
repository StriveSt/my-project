package com.plt.base.configuration;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.plt.base.aop.ControllerLogInterceptor;
import com.plt.base.banner.PltBanner;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zxq
 */
@Configuration
public class BaseAutoConfiguration {
    /**
     * banner
     */
    @Configuration
    public static class BannerConfiguration implements InitializingBean {
        @Override
        public void afterPropertiesSet() {
            new PltBanner().printBanner(null, null, System.out);
        }
    }

    /**
     * mvc全局异常处理
     */
    @Configuration
    public static class ControllerAdviceAutoConfiguration {
        @Bean
        public GlobalExceptionAdvice getGlobalExceptionAdvice() {
            return new GlobalExceptionAdvice();
        }
    }

    /**
     * mybatisplus配置
     */
    @Configuration
    public static class MyBatisPlusAutoConfig {
        /**
         * 分页插件
         */
        @Bean
        public PaginationInterceptor paginationInterceptor() {
            PaginationInterceptor interceptor = new PaginationInterceptor();

            List<ISqlParser> list = new LinkedList<>();
            interceptor.setSqlParserList(list);
            // 攻击SQL阻断解析器
            list.add(new BlockAttackSqlParser());

            return interceptor;
        }

        /**
         * SQL执行效率插件
         * dev test 环境开启, 线上不开启
         */
        @Bean
        @Profile({"dev", "test"})
        public PerformanceInterceptor performanceInterceptor() {
            PerformanceInterceptor interceptor = new PerformanceInterceptor();
            // SQL格式化
            interceptor.setFormat(true);
            // 记录进日志
            interceptor.setWriteInLog(true);
            return interceptor;
        }
    }

    @Configuration
    public static class ControllerLogProxyConfiguration {
        @Bean
        public DefaultBeanFactoryPointcutAdvisor getDefaultBeanFactoryPointcutAdvisor() {
            DefaultBeanFactoryPointcutAdvisor defaultBeanFactoryPointcutAdvisor = new DefaultBeanFactoryPointcutAdvisor();
            AnnotationMatchingPointcut annotationMatchingPointcut = new AnnotationMatchingPointcut(Controller.class, true);
            defaultBeanFactoryPointcutAdvisor.setPointcut(annotationMatchingPointcut);
            defaultBeanFactoryPointcutAdvisor.setAdvice(getControllerLogInterceptor());
            return defaultBeanFactoryPointcutAdvisor;
        }
        @Bean
        public ControllerLogInterceptor getControllerLogInterceptor() {
            return new ControllerLogInterceptor();
        }
    }
}
