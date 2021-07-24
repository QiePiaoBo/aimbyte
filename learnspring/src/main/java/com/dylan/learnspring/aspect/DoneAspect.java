package com.dylan.learnspring.aspect;

import com.dylan.learnspring.myannotation.DoneTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Dylan
 * @Date : 2021/7/24 - 15:15
 * @Description : 使用自定义注解使用AOP
 * @Function :
 */
@Aspect
@Component
public class DoneAspect {

    Logger logger = LoggerFactory.getLogger(DoneAspect.class);


    @Around(value = "@annotation(doneTime)")
    public Object doAround(ProceedingJoinPoint pj, DoneTime doneTime) throws Throwable {

        logger.info("Start time of method is : " + new Date());
        Object o = pj.proceed();
        logger.info("End time of method is : " + new Date());
        return o;
    }

}
