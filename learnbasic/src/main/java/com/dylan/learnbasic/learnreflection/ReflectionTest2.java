package com.dylan.learnbasic.learnreflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Dylan
 * @Date : 2021/5/20 - 23:28
 * @Description :
 * @Function :
 */
public class ReflectionTest2 {
    public static void main(String[] args) throws Exception {
        // 获取属性和对属性赋值
        // 1. 获取字运行时类的节码信息
        Class<Student> cls = Student.class;

        // 2.获取属性
        // 获取public属性
        Field[] fields = cls.getFields();
        // 获取所有属性
        Field[] declaredFields = cls.getDeclaredFields();
        System.out.println("获取public属性集合");
        for (Field f : fields){
            System.out.println(f);
        }
        System.out.println("获取所有属性集合");
        for (Field f : declaredFields){
            System.out.println(f);
        }
        System.out.println("------------");
        // 获取public的指定属性
        Field score = cls.getField("score");
        System.out.println("获取score属性：" + score);
        // 获取所有权限的指定属性
        Field sno = cls.getDeclaredField("sno");
        System.out.println("获取weight属性" + sno);
        System.out.println("------------");
        // 属性的具体结构
        // 获取属性的修饰符、数据类型、属性的名字
        String snoName = sno.getName();
        System.out.println("属性的名字：" + snoName);
        Class<?> snoType = sno.getType();
        System.out.println("属性的类型：" + snoType);
        int snoModifiers = sno.getModifiers();
        System.out.println("属性的修饰符的值：" + snoModifiers);
        System.out.println("属性的修饰符的值转成Modifier中的值：" + Modifier.toString(snoModifiers));
        System.out.println("------------");
        // 给属性赋值，赋值时不仅需要赋的那个值，还需要一个具体的对象
        Student student = cls.newInstance();
        score.set(student, 99.9);
        System.out.println(student);
    }
}
