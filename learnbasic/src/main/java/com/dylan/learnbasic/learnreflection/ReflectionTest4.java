package com.dylan.learnbasic.learnreflection;

import java.lang.annotation.Annotation;

/**
 * @author Dylan
 * @Date : Created in 13:22 2021/5/21
 * @Description :
 * @Function :
 */
public class ReflectionTest4 {
    public static void main(String[] args) {
        // 获取类的接口信息、所在包、注解
        // 1. 获取字节码对象
        Class cls = Student.class;
        // 获取运行时类的接口
        Class[] interfaces = cls.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }
        // 得到父类的接口
        // 得到父类的字节码信息->父类的接口
        Class superclass = cls.getSuperclass();
        Class[] interfaces1 = superclass.getInterfaces();
        for (Class c : interfaces1){
            System.out.println(c);
        }
        // 获取运行时类所在的包
        Package aPackage = cls.getPackage();
        System.out.println(aPackage.getName());
        // 获取运行时类的注解
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation a : annotations){
            System.out.println(a);
        }
    }
}
