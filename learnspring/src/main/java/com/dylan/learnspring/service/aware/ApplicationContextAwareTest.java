package com.dylan.learnspring.service.aware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author Dylan
 * @Date : Created in 9:44 2020/12/31
 * @Description : 通过实现ApplicationContextAware获取到当前的ApplicationContext
 * @Function :
 */
@Service
public class ApplicationContextAwareTest implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextAwareTest.class);

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public ApplicationContext getContext(){
        return context;
    }
}
