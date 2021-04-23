package com.dylan.learnmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dylan
 * @Date : Created in 11:23 2021/4/14
 * @Description :
 * @Function :
 */
@SpringBootApplication
@MapperScan
public class LearnMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisApplication.class, args);
        System.out.println("LearnMybatisApplication started.");
    }


}
