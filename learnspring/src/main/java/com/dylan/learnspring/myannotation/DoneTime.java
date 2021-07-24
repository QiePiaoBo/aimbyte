package com.dylan.learnspring.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Dylan
 * @Date : 2021/7/24 - 15:10
 * @Description :
 * @Function :
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoneTime {

    String param() default "";

}
