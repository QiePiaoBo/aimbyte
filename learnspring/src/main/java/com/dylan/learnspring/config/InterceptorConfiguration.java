package com.dylan.learnspring.config;

import com.dylan.learnspring.interceptor.UrlCheckInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Dylan
 * @Date : Created in 9:57 2020/12/31
 * @Description : 注册拦截器
 * @Function :
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(InterceptorConfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("Adding interceptor for application.");
        // 所有路径都经过拦截器
        registry.addInterceptor(new UrlCheckInterceptor()).addPathPatterns("/**");;
    }
}
