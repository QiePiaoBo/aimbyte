package com.dylan.learnspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 * @author Dylan
 * @Date : Created in 11:23 2021/4/14
 * @Description :
 * @Function :
 */
@SpringBootApplication
@ServletComponentScan
public class LearnSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LearnSpringApplication.class, args);
        // 打印一句话到控制台，标志着Springboot程序启动成功
        DataSource dataSource =(DataSource) run.getBeanFactory().getBean("dataSource");

        System.out.println(dataSource.getClass());
        System.out.println("LearnSpringApplication started.");
    }
}