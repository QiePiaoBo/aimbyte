package com.dylan.learnmybatis;

import com.dylan.learnmybatis.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Dylan
 * @Date : Created in 11:23 2021/4/14
 * @Description :
 * @Function :
 */
@SpringBootApplication
public class LearnMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisApplication.class, args);
        System.out.println("LearnMybatisApplication started.");
    }
}