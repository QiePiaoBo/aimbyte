package com.dylan.learnspring;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@SpringBootApplication
@ServletComponentScan
public class LearnSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LearnSpringApplication.class, args);
        // 打印一句话到控制台，标志着Springboot程序启动成功
        DataSource dataSource =(DataSource) run.getBeanFactory().getBean("dataSource");

        log.info(dataSource.getClass().getName());
        log.info("LearnSpringApplication started.");
    }
}