package com.dylan.learnbasic.learnreflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Dylan
 * @Date : Created in 12:59 2021/5/21
 * @Description :
 * @Function :
 */
public class ReflectionTest3 {
    public static void main(String[] args) throws Exception {
        // 获取方法和使用方法
        // 1. 获取字节码信息对象
        Class<Student> cls = Student.class;
        // 2. 获取方法
        // 获取运行时类的public方法和所有父类中的public方法
        Method[] m1 = cls.getMethods();
        for (Method m : m1){
            System.out.println(m);
        }
        System.out.println("----------");
        // 获取运行时类的所有方法，不包括其父类的
        Method[] m2 = cls.getDeclaredMethods();
        for (Method m : m2){
            System.out.println(m);
        }
        System.out.println("---------------");
        // 获取指定的方法
        Method showInfo1 = cls.getMethod("showInfo", int.class, int.class);
        Method showInfo2 = cls.getMethod("showInfo");
        Method work = cls.getDeclaredMethod("work");
        Method myMethod = cls.getDeclaredMethod("myMethod");
        System.out.println(showInfo1);
        System.out.println(showInfo2);
        System.out.println(work);
        // 获取方法的具体结构
        String workName = work.getName();
        String workModifier = Modifier.toString(work.getModifiers());
        Annotation[] annotations = myMethod.getAnnotations(); // 只能获取到运行时的注解
        for (Annotation a : annotations){
            System.out.println(a);
        }
        Class<?>[] myMethodExceptionTypes = myMethod.getExceptionTypes();
        for (Class c : myMethodExceptionTypes){
            System.out.println(c);
        }
        // 调用方法,需要一个具体的对象和调用方法所需的参数
        Student student = cls.newInstance();
        // 调用student对象的myMethod方法
        myMethod.invoke(student);
        System.out.println(showInfo1.invoke(student, 1, 1));
    }
}
