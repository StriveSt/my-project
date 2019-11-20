package com.plt.base.aop;

import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

//@Configuration
//@ConditionalOnClass(InfrastructureAdvisorAutoProxyCreator.class)
public class ControllerLogProxyConfiguration {
    @Bean
    @Primary
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