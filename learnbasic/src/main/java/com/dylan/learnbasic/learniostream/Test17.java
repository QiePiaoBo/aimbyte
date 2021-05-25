package com.dylan.learnbasic.learniostream;

import java.io.*;

/**
 * @author Dylan
 * @Date : 2021/5/25 - 22:10
 * @Description :
 * @Function :
 */
public class Test17 {

    public static void main(String[] args) throws Exception{
        /**
         * 对象流操作自定义类
         */
        // 序列化
        //testObjectOutputStream();
        // 反序列化
        testObjectInputStream();
    }

    private static void testObjectOutputStream() throws Exception{
        Person p = new Person("Dl", 24);
        // 将内存的Person对象写出到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("fileTestDir/test10/Person.txt")));
        oos.writeObject(p);
        oos.close();
    }

    private static void testObjectInputStream() throws Exception{
        // 将文件中的内容读入到程序中
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(new File("fileTestDir/test10/Person.txt")));
        Person p = (Person)oin.readObject();
        System.out.println(p);
        oin.close();
    }
}

/**
 * 自定义的类必须要实现Serializable接口之后才能被序列化，否则会报没有序列化的异常
 * Serializable内部什么都没有，仅仅起到标识作用，标识着只有实现了这个接口，这个类的对象才能被序列化，否则不行
 */
class Person implements Serializable{

    /**
     * 对于同一个类，序列化之前没有toString方法，加上了toString方法之后进行反序列化的时候发生异常
     * 解决这个异常可以通过给类添加序列化号的方法，告诉程序这串数据对应的类是同一个
     *
     * ---：凡是实现Serializable接口（标识接口）的类都有一个标识序列化版本标识符的静态变量：serialVersionUID,它用来
     * 表明类的不同版本之间的兼容性。简言之，其目的是以序列化对象进行版本控制，有关各版本反序列化时是否兼容
     * 如果类没有定义这个静态变量，Java也会根据运行时环境根据类的内部细节自动生成。若类的实例变量做了修改，serialVersionUID
     * 可能会发生变化，所以建议显式声明
     *
     * 简单来说，java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID
     * 与本地相应实体类的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化、否则就会出现序列化版本不一致的异常（InvalidCastException）
     *
     */
    private static final long serialVersionUID = 99999999L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}