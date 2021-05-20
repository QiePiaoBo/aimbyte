package com.dylan.learnbasic.learnreflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
/**
 * @author Dylan
 * @Date : 2021/5/20 - 22:50
 * @Description :
 * @Function :
 *
 * @Target :定义当前注解能够用来修饰程序中的哪些元素
 * @Rentention: 定义注解的生命周期
 *
 *
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value();

}
