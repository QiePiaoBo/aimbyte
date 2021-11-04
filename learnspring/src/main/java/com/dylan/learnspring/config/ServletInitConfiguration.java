package com.dylan.learnspring.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.dylan.learnspring.servlet.MyServlet;
import com.dylan.learnspring.servlet.MyServletContext;
import com.dylan.learnspring.servlet.NumberServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @author Dylan
 * @Date : 2021/6/6 - 15:06
 * @Description : 向Spring容器中添加Servlet对象并为其配置对应的路由
 * @Function :
 */
@Configuration
public class ServletInitConfiguration {


    @Bean("svlt")
    public ServletRegistrationBean<MyServlet> getMyServlet(){
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>(new MyServlet());
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/mysvlt");
        bean.setUrlMappings(urls);
        bean.setLoadOnStartup(1);
        return bean;
    }
    @Bean("svltContext")
    public ServletRegistrationBean<MyServletContext> getMyServletContext(){
        ServletRegistrationBean<MyServletContext> bean = new ServletRegistrationBean<>(new MyServletContext());
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/myctxt");
        bean.setUrlMappings(urls);
        bean.setLoadOnStartup(1);
        return bean;
    }
    @Bean("numberServlet")
    public ServletRegistrationBean<NumberServlet> getNumberServlet(){
        ServletRegistrationBean<NumberServlet> bean = new ServletRegistrationBean<>(new NumberServlet());
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/numbersvlt");
        bean.setUrlMappings(urls);
        bean.setLoadOnStartup(1);
        return bean;
    }

    /**
     * 配置用于druid监控的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServletRegisterBean(){
        ServletRegistrationBean<StatViewServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUserName", "admin");
        initParams.put("loginPassword", "123456");
        // 后台允许谁能访问 localhost 表示只有本机可以访问 空值表示所有机器都能访问
        initParams.put("allow", "127.0.0.1");
        servletServletRegistrationBean.setInitParameters(initParams);
        return servletServletRegistrationBean;
    }

    /**
     * 配置用于Druid监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidFilterRegisterBean(){
        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        // exclusion 设置哪些请求进行过滤排除 从而不进行统计
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusion", "*.js,*.css,/druid/*");
        filterFilterRegistrationBean.setInitParameters(initParams);
        filterFilterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return filterFilterRegistrationBean;
    }

}