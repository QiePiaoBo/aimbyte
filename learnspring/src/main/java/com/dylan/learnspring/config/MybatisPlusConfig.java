package com.dylan.learnspring.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * @author Dylan
 * @Date : 2021/7/29 - 22:17
 * @Description :
 * @Function :
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {


    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLimit(-1);
        Properties p = new Properties();
        p.setProperty("format", "true");
        paginationInterceptor.setProperties(p);
        return paginationInterceptor;
    }


}
