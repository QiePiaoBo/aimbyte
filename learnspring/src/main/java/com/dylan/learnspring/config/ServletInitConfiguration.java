package com.dylan.learnspring.config;

import com.dylan.learnspring.servlet.MyServlet;
import com.dylan.learnspring.servlet.MyServletContext;
import com.dylan.learnspring.servlet.NumberServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

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
}
