package com.dylan.learnbasic.learnreflection;

/**
 * @author Dylan
 * @Date : Created in 13:32 2021/5/20
 * @Description : 获取字节码信息的四种方式
 * @Function :
 */
public class GetByteCode {

    public static void main(String[] args) throws Exception{
        Person p = new Person();

        // 方式1 getClass
        Class c1 = p.getClass();
        System.out.println("c1 : " + c1);
        // 方式2 class属性
        Class c2 = Person.class;
        System.out.println("c2 : " + c2);
        // 方式3 Class.forName
        Class c3 = Class.forName("com.dylan.learnbasic.learnreflection.Person");
        System.out.println("c3 : " + c3);
        // 方式4 利用类加载器
        ClassLoader loader = GetByteCode.class.getClassLoader();
        Class c4 = loader.loadClass("com.dylan.learnbasic.learnreflection.Person");
        System.out.println("c4 : " + c4);
    }
}
