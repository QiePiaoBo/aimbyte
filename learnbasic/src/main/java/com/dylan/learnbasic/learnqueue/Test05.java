package com.dylan.learnbasic.learnqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Dylan
 * @Date : 2021/6/2 - 22:53
 * @Description :
 * @Function :
 */
public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Object> pq = new PriorityBlockingQueue<>();
        // 不可放入空对象
        //pq.put(null);
        // 添加对象
        pq.put(new Student("Dylan1", 22));
        pq.put(new Student("Dylan2", 23));
        pq.put(new Student("Dylan3", 32));
        pq.put(new Student("Dylan4", 20));
        // 打印结果发现并没有按照优先级
        System.out.println(pq);
        // 取出数据的时候 数据按照优先级进行顺序取出
        // 优先级队列 说的优先级就是取数据时的优先级
        System.out.println(pq.take());
        System.out.println(pq.take());
        System.out.println(pq.take());
        System.out.println(pq.take());
    }
}
class Student implements Comparable<Student>{

    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}