package com.dylan.learnbasic.learnreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Dylan
 * @Date : 2021/5/20 - 23:04
 * @Description :
 * @Function :
 */
public class ReflectionTest1 {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过反射来获取Student、Person、MyInterface、MyAnnotation的字节码信息
        // 1. 获取构造器和创建对象，但想获得构造器首先得获取字节码信息
        Class cls = Student.class;
        // 获取构造器的方法1，这个方法只能获取到被public修饰的构造器
        Constructor[] c1 = cls.getConstructors();
        for (Constructor c : c1){
            System.out.println("getConstructors: " + c);
        }
        // 获取构造器的方法2，能得到运行时类的所有的构造器
        Constructor[] c2 = cls.getDeclaredConstructors();
        for (Constructor c : c2){
            System.out.println("getDeclaredConstructors: " + c);
        }
        // 获取构造器的方法3，得到运行时类的指定的构造器
        // 获取无参构造器
        Constructor c3 = cls.getConstructor();
        System.out.println("获取一个参数的构造器：" + c3);
        // 获取两个参数的构造器
        Constructor c4 = cls.getConstructor(double.class, double.class);
        System.out.println("获取两个参数的构造器：" + c4);
        // 得到一个参数的有参构造器，限制条件是private的
        Constructor c5 = cls.getDeclaredConstructor(int.class);
        System.out.println("得到一个参数的且private的构造器：" + c5);
        // 2. 有了构造器之后就可以创建对象了
        Object o1 = c4.newInstance(4.0, 5.0);
        Object o2 = c3.newInstance();
        System.out.println("构造器创建的对象：" + o1);
        System.out.println("构造器创建的对象：" + o2);

    }
}
