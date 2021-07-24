package com.dylan.learnspring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Dylan
 * @Date : 2021/7/24 - 14:44
 * @Description : 直接使用切面的方式 Aspect注解表明是一个切面类 Component注解表示将当前类注册到Spring容器中
 * @Function :
 */
@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * execution(方法修饰符_可选 返回类型 方法名(参数) 异常模式_可选) “*”可以匹配任意字符
     */
    @Pointcut("execution(public * com.dylan.learnspring.controller.*.*(..))")
    public void LogAspect(){}


    /**
     * 在方法前执行
     * @param joinPoint
     */
    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint){
        if (logger.isInfoEnabled()){
            logger.info("doBefore on" + joinPoint.getKind() + "." + joinPoint.getTarget());
        }
    }

    /**
     * 在方法后执行
     * @param joinPoint
     */
    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint){
        if (logger.isInfoEnabled()){
            logger.info("doAfter on" + joinPoint.getKind() + "." + joinPoint.getTarget());
        }
    }

    /**
     * 在方法执行完毕并返回一个结果后执行
     * @param joinPoint
     */
    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint){
        if (logger.isInfoEnabled()){
            logger.info("doAfterReturning on" + joinPoint.getKind() + "." + joinPoint.getTarget());
        }
    }

    /**
     * 在方法执行过程中抛出一个异常时执行
     * @param joinPoint
     */
    @AfterThrowing("LogAspect()")
    public void doAfterThrowing(JoinPoint joinPoint){
        if (logger.isInfoEnabled()){
            logger.info("doAfterThrowing on" + joinPoint.getKind() + "." + joinPoint.getTarget());
        }
    }

    /**
     * 环绕通知，就是可以在执行前后都使用，这个方法参数必须为ProceedingJoinPoint，
     * proceed()方法就是被切面的方法，除此之外上面的方法都可以使用JoinPoint，
     * JoinPoint包含了类名，被切面的方法名，参数等信息
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("LogAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (logger.isInfoEnabled()){
            logger.info("doAround");
        }
        return joinPoint.proceed();
    }


}
