package com.dylan.learnspring.controller;

import com.dylan.learnspring.service.test.ApplicationContextAwareTest;
import com.dylan.learnspring.service.test.BeanNameAwareTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dylan
 * @Date : Created in 9:11 2020/12/31
 * @Description : 对BeanNameAware和ApplicationContextAware进行测试
 * @Function :
 */
@RestController
@RequestMapping("awareTest")
public class AwareTestController {
    private static final Logger logger = LoggerFactory.getLogger(AwareTestController.class);

    @Autowired
    BeanNameAwareTest beanNameAwareTest;

    @Autowired
    ApplicationContextAwareTest applicationContextAwareTest;


    @RequestMapping("beanName")
    public String testBeanNameAware(){
        logger.info("Doing test for beanNameAware in controller.");
        return beanNameAwareTest.getBeanName();
    }

    @RequestMapping("applicationContext")
    public String testApplicationContext(){
        String applicationName = applicationContextAwareTest.getContext().getId();
        return applicationName;
    }
}
