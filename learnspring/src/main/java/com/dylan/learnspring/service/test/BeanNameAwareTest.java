package com.dylan.learnspring.service.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Dylan
 * @Date : Created in 9:12 2020/12/31
 * @Description :
 * @Function :
 */
@Component(value = "beanNameAware4Test")
public class BeanNameAwareTest implements BeanNameAware {
    private static final Logger logger = LoggerFactory.getLogger(BeanNameAwareTest.class);

    String name;

    @Override
    public void setBeanName(String s) {
        name = s;
    }

    public String getBeanName(){
        logger.info("You are using BeanNameAwareTest, " + "the bean name is: " + name);
        return name;
    }
}
