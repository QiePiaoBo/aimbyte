package com.dylan.learnspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Dylan
 * @Date : Created in 11:23 2021/4/14
 * @Description :
 * @Function :
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.dylan.learnspring.filter")
public class LearnSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringApplication.class, args);
        System.out.println("LearnSpringApplication started.");
    }
}